import sys 
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
from collections import deque 

n, m, r = map(int, input().split())

graph = [[] for _ in range(n+1)]

for i in range(m):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)
             
for i in graph:
  i.sort(reverse=True)
# print(graph)

visited = [0] * (n+1)

def dfs(graph, v, visited):
  global k
  k+=1
  visited[v]=k

  for i in graph[v]:
    if visited[i]==0:
      dfs(graph, i, visited)
k=0
dfs(graph, r, visited)

for i in range(1, len(visited)):
  print(visited[i])

