import sys
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    temp = input()
    print(temp[0], end="")
    print((temp[len(temp) - 2]))