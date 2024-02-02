n = int(input())

graph=[]

for _ in range(n):
  graph.append(list(map(int, input())))

# print(graph)
  
answer=[]

def dfs(x, y):
  if x <= -1 or x >= n or y <= -1 or y>=n:
    return False

  if graph[x][y] == 1:
    global count
    count+=1
    graph[x][y]=0
    dfs(x-1, y)
    dfs(x, y-1)
    dfs(x+1, y)
    dfs(x, y+1)

    return True
  return False
  

count=0

  
for i in range(n):
  for j in range(n):
    if dfs(i, j) == True:
      answer.append(count)
      count=0

print(len(answer))

answer.sort()

for i in answer:
  print(i)