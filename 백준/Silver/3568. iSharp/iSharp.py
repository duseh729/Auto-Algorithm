import re

var_list = input().split()

# print(var_list)

first_var = var_list.pop(0)

for i in var_list:
  i=i.replace(',', '')
  i=i.replace(';', '')
  eng_str = re.sub(r"[^a-zA-Z\s]", "", i)
  print(first_var, end="")
  if '][' in i[::-1][:len(i)-1]:
    print(i[::-1][:len(i)-len(eng_str)].replace('][', '[]'), end=" ")
  else: 
    print(i[::-1][:len(i)-len(eng_str)], end=" ")
  print(eng_str, end='')
  print(';')