import sys
input = sys.stdin.readline

a, b = map(int, input().split())
answer=[]
for i in range(a):
    answer.append(i+1)

for i in range(b):
    j, k = map(int, input().split())
    answer[j-1], answer[k-1]=answer[k-1], answer[j-1]

for i in answer:
    print(i, end=" ")