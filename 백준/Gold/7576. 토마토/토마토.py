import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

from collections import deque 

n, m = map(int, input().split())

graph = []

for _ in range(m):
  graph.append(list(map(int, input().split())))


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
# print(graph)
  
def bfs(temp):
  queue = deque(temp)

  while queue:
    # print(queue)
    x, y = queue.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or ny < 0 or nx>=m or ny>=n:
        # print("칸넘")
        continue
      if graph[nx][ny]==-1:
        continue

      if graph[nx][ny]==0:
        graph[nx][ny] = graph[x][y]+1
        queue.append((nx, ny))


temp=[]

for i in range(len(graph)):
  for j in range(len(graph[0])):
    if graph[i][j]==1:
      temp.append((i, j))

# print(temp)
# if len(temp)>1:
#   bfs(i[0], i[1])


bfs(temp)

answer = 0
for i in graph:
  if 0 in i:
    answer=0
    break
  for j in i:
    if j>answer:
      answer=j
print(answer-1)

# 1이 여러개인 경우를 못 풀었음
# 6 4
# 1 -1 0 0 0 0
# 0 -1 0 0 0 0
# 0 0 0 0 -1 0
# 0 0 0 0 -1 1