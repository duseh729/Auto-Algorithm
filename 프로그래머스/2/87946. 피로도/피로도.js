let answer = 0;
function solution(k, dungeons) {
    const visited = new Array(dungeons.length).fill(false);
    backtrack(k, dungeons, visited, 0, dungeons.length);
    return answer;
}
function backtrack(k, dungeons, visited, count, len){
    if(count>answer){
        answer = count;
    }
    
    for(let i=0; i<len; i++){
        if(!visited[i] && dungeons[i][0]<=k){
            visited[i]=true;
            backtrack(k-dungeons[i][1], dungeons, visited, count+1, len);
            visited[i]=false;
        }
    }
}