input="request.txt"
dir="patch/"

if [ ! -d "$dir" ]; then
	mkdir $dir
fi

while IFS= read -r line
do
	url=$(echo $line|sed -e 's/[\r\n]//g')
	file_name=$(echo ${line##*/}|sed -e 's/[\r\n]//g')
	curl $url --output $dir$file_name
done < "$input"
#sed -e 's/\x4b\x75\x72\x6f//g' $dir$file_name > new_$dir$file_name
