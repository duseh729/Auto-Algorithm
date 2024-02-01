import sys
input = sys.stdin.readline
from collections import deque

n, m, start = map(int, input().split())

graph =[[] for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

# print(graph)

dfs_visited = [False] * (n+1)
bfs_visited = [False] * (n+1)

# print(visited)
def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=" ")

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

dfs(graph, start, dfs_visited)

print()

def bfs(graph, start, visited):
    queue = deque([start])

    visited[start] = True
    
    while queue:
        v = queue.popleft()
        
        print(v, end=" ")

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]=True

bfs(graph, start, bfs_visited)