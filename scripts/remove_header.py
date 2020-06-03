from os import walk
from os import remove
from os import rename
from os import path

directory = "assets/resource"
file_list = []
for (dirpath, dirnames, filenames) in walk(directory):
	file_list.extend(filenames)

for filename in file_list:
	file = open(directory + "/" + filename, "rb")
	byte = file.read(4)
	if byte == b'Kuro':
		with open(directory + "/" + filename + ".new", 'wb') as out_file:
			out_file.write(file.read()[:])
		file.close()
		remove(directory + "/" + filename)
	else:
		file.close()

for filename in file_list:
	if path.exists(directory + "/" + filename + ".new"):
		rename(directory + "/" + filename + ".new", directory + "/" + filename)