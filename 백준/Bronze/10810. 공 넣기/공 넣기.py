import sys
input = sys.stdin.readline

a, b = map(int, input().split())
answer = ['0'] * a

for i in range(b):
    i, j, k = map(int, input().split())
    for temp in range(i-1,j):
        answer[temp]=str(k)

print(" ".join(answer))