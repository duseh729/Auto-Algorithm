function solution(n, computers) {
    var answer = 0;
    
    const visited = new Array(n).fill(false);
    // console.log(visited);
    
    for(let i=0; i<n; i++){
        if(!visited[i]){
            dfs(visited, computers, n, i);
            answer++;
        }
    }
    
    return answer;
}

function dfs(visited, computers, n, index){
    visited[index]=true;
    for(let i=0; i<n; i++){
        if(computers[index][i]==1 && !visited[i]){
            dfs(visited, computers, n, i);
        }
    }
}