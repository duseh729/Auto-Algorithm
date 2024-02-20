n=int(input())

arr = []

for _ in range(n):
  arr.append(input().split())

opcode = {
  'ADD' : '00000',
  'ADDC' : '00001',
  'SUB' : '00010',
  'SUBC' : '00011',
  'MOV' : '00100',
  'MOVC' : '00101',
  'AND' : '00110',
  'ANDC' : '00111',
  'OR' : '01000',
  'ORC' : '01001',
  'NOT' : '01010',
  'MULT' : '01100',
  'MULTC' : '01101',
  'LSFTL' : '01110',
  'LSFTLC' : '01111',
  'LSFTR' : '10000',
  'LSFTRC' : '10001',
  'ASFTR' : '10010',
  'ASFTRC' : '10011',
  'RL' : '10100',
  'RLC' : '10101',
  'RR' : '10110',
  'RRC' : '10111'
}

for i in arr:
  four_bit = opcode[i[0]][4]  

  print(opcode[i[0]], end='')
  print('0', end='')
  print(format(int(i[1]), 'b').zfill(3), end='')  
  print(format(int(i[2]), 'b').zfill(3), end='')
  if four_bit=='0':
    print(format(int(i[3]), 'b').zfill(3), end='')
    print('0')
  else:
    print(format(int(i[3]), 'b').zfill(4))
