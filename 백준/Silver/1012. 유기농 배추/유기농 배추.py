import sys
sys.setrecursionlimit(10**5)

n = int(input())

def dfs(x, y, graph):
  # print(x,y)
  if x <= -1 or x >= len(graph) or y <= -1 or y >= len(graph[0]):
    return False
  # print(x,y)
  if graph[x][y] == 1:
    graph[x][y] = 0
    dfs(x-1, y, graph)
    dfs(x, y-1, graph)
    dfs(x+1, y, graph)
    dfs(x, y+1, graph)
    return True

  return False
answer=[]
for _ in range(n):
  a, b, c = map(int, input().split())
  graph=[]
  for _ in range(b):
    graph.append(list(0 for _ in range(a)))
    
  for _ in range(c):
    temp1, temp2 = map(int, input().split())
    graph[temp2][temp1] = 1

  result=0
  
  for i in range(b):
    for j in range(a):
      if dfs(i, j, graph):
        result+=1

  answer.append(result)
  continue

for i in answer:
  print(i)