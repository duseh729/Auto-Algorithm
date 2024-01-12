import sys
input = sys.stdin.readline

a, b = map(int, input().split())
answer=[]
for i in range(a):
    answer.append(i+1)

for i in range(b):
    j, k = map(int, input().split())
    answer[j-1:k]=reversed(answer[j-1:k])

for i in answer:
    print(i, end=" ")