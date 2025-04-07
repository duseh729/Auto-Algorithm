from collections import deque

N, M, H = map(int ,input().split(" "))

tomato_arr = []
visited_arr = [[[False] *N ] * M ] * H

for _ in range(H):
    tomato = []
    for _ in range(M):
        tomato.append(list(map(int ,input().split(" "))))
    tomato_arr.append(tomato)

# print(visited_arr)
# print(tomato_arr)

q = deque([])

for i in range(N):
    for j in range(M):
        for k in range(H):
            # i = x, j = y, k = z
            if tomato_arr[k][j][i]==1:
                q.append([i, j, k, 0])
                visited_arr[k][j][i]=True

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

answer=0
trigger=False
while len(q)>0:

    current_x, current_y, current_z, day = q.popleft()
    # print(current_x, current_y, current_z, day)

    for i in range(4):
        nx = current_x + dx[i]
        ny = current_y + dy[i]

        if ny>=0 and ny<M and nx>=0 and nx<N and tomato_arr[current_z][ny][nx]==0:
            q.append([nx, ny, current_z, day+1])
            tomato_arr[current_z][ny][nx]=1
            trigger=True
    
    for i in range(1):
        up_z = current_z + 1
        down_z = current_z - 1

        if up_z<H and tomato_arr[up_z][current_y][current_x]==0:
            q.append([current_x, current_y, up_z, day+1])
            tomato_arr[up_z][current_y][current_x]=1
            trigger=True
            
        if down_z>=0 and tomato_arr[down_z][current_y][current_x]==0:
            q.append([current_x, current_y, down_z, day+1])
            tomato_arr[down_z][current_y][current_x]=1
            trigger=True

    if answer<day:
        answer=day

answer_trigger = False
for i in range(H):
    for j in range(M):
        for k in range(N):
            if tomato_arr[i][j][k]==0:
                answer_trigger=True

if answer_trigger:
    print(-1)
else:
    print(answer)