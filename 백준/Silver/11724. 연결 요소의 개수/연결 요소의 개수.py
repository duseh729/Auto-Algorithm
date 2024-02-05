import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# print(graph)
visited = [False] * (n+1)

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

result = 0

for i in range(1, n+1):
    if not visited[i]:
        dfs(graph, i, visited)
        result+=1
print(result)
# print(visited)
# 6 5
# 1 2
# 2 5
# 5 1
# 3 4
# 4 6