
function createDir (dirname)
    -- this will print out an error if the directory already exists, but that's fine
    os.execute("mkdir " .. dirname)
end

local tap = Listener.new("http", "ip.dst == 47.246.5.173 || ip.dst == 47.246.5.172")
local full_request_url = Field.new("http.request.full_uri")
local dir = "extract_to"
createDir(dir)
file = io.open("extract_to/request.txt", "a")
local dmp = nil
do
	local function packet_listener()
		function tap.packet(pinfo, tvb, ip)
			local ip_src, ip_dst = tostring(ip.ip_src), tostring(ip.ip_dst)
			local request_url = full_request_url();
			if not dmp then
				dmp = Dumper.new_for_current( dir .. "/zspns_extract.pcap" )			
			end
			dmp:dump_current()
			dmp:flush()
			file:write(tostring(request_url) .. "\n")
		end
		function tap.draw()
			print("draw called")
		end
		function tap.reset()
			print("reset called")
			if dmp then
				dmp:close()
			end
		end
	end
	packet_listener()
end