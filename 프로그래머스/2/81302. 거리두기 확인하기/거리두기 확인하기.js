const dx = [0, 0, -1, 1];
const dy = [-1, 1, 0, 0];

function solution(places) {
    var answer = [];

    for (let i = 0; i < 5; i++) {
        let trigger = 1;
        for (let j = 0; j < 5; j++) {
            for (let k = 0; k < 5; k++) {
                if (places[i][j][k] == 'P') {         
                    let visited = Array.from({ length: 5 }, () => Array(5).fill(false));
                    if (dfs(places[i], j, k, 0, visited)) {
                        trigger = 0;
                        break; // 현재 행 탐색 중단
                    }
                }
            }
            if (trigger == 0) break; // 현재 방 탐색 중단
        }
        answer.push(trigger);
    }

    return answer;
}

function dfs(place, x, y, count, visited) {
    if (count >= 2) return false; // 거리가 2 이상이면 안전함
    visited[x][y] = true; // 방문 체크

    for (let i = 0; i < 4; i++) {
        const nx = x + dx[i];
        const ny = y + dy[i];

        if (nx >= 5 || ny >= 5 || ny < 0 || nx < 0) continue; // 범위 초과 체크
        if (visited[nx][ny]) continue; // 이미 방문한 곳이면 패스
        if (place[nx][ny] === 'X') continue; // 파티션이면 탐색 중지

        if (place[nx][ny] === 'P') return true; // 거리 2 이내에 P가 있으면 거리두기 위반

        if (place[nx][ny] === 'O') {
            if (dfs(place, nx, ny, count + 1, visited)) return true;
        }
    }

    return false;
}
