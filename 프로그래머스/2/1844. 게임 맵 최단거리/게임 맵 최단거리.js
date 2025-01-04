function solution(maps) {
    var answer = 1;
    
    const dr = [1, -1, 0, 0];
    const dc = [0, 0, 1, -1];
    const visited = Array.from(Array(maps.length), ()=>Array(maps[0].length).fill(true));
    visited[0][0]=false;
    
    const q = [[0, 0, 1]]
    
    while(true){
        if(q.length===0){
            break;
        }
        const next = q.shift();
        const r = next[0];
        const c = next[1];
        const count = next[2];
        
        if(r==maps.length-1&&c==maps[0].length-1){
            return count;
        }
        
        for(let i=0; i<4; i++){
            const nr = r+dr[i];
            const nc = c+dc[i];
            if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && maps[nr][nc]==1 && visited[nr][nc]){
                visited[nr][nc]=false;
                q.push([nr, nc, count+1])
            }
        }
    }
    
    return -1;
}