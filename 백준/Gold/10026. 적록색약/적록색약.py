from collections import deque
import sys

input = sys.stdin.readline
n = int(input())

color_arr = []
color_visited = []
color_handicapped_visited = []

for _ in range(n):
    color_arr.append(list(input()))
    color_visited.append([False]*n)
    color_handicapped_visited.append([False]*n)

# print(arr, color_visited)
# print(color_handicapped_visited)
    
q = deque()

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

# 0번 index 색맹 아닌 사람, 1번 index 색맹인 사람
answer = [0, 0]

for x in range(n):
    for y in range(n):
        now_color = color_arr[x][y]

        if color_visited[x][y]==False:
            color_visited[x][y]=True

            q.append([x, y])
            while len(q)>0:
              temp = q.popleft()
              current_x = temp[0]
              current_y = temp[1]

              for z in range(4):
                  nx = dx[z] + current_x
                  ny = dy[z] + current_y

                  # print(nx, ny)

                  if nx>=0 and nx<n and ny>=0 and ny<n and color_visited[nx][ny]==False and color_arr[nx][ny]==now_color:
                      color_visited[nx][ny] = True
                      q.append([nx, ny])

            answer[0]+=1
            
        if color_handicapped_visited[x][y]==False:
            color_handicapped_visited[x][y]=True

            q.append([x, y])
            while len(q)>0:
              temp = q.popleft()
              current_x = temp[0]
              current_y = temp[1]

              for z in range(4):
                  nx = dx[z] + current_x
                  ny = dy[z] + current_y

                  if nx>=0 and nx<n and ny>=0 and ny<n and color_handicapped_visited[nx][ny]==False:
                      if now_color==color_arr[nx][ny] or (now_color=='R' and color_arr[nx][ny]=='G') or (now_color=='G' and color_arr[nx][ny]=='R'):
                        color_handicapped_visited[nx][ny] = True
                        q.append([nx, ny])

            answer[1]+=1

print(answer[0], answer[1])