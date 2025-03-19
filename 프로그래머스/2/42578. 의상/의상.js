function solution(clothes) {
    var answer = 1;
    const map = new Map();
    
    for(c of clothes){
        if(map.has(c[1])){
            map.set(c[1], map.get(c[1])+1)
        }else{
            map.set(c[1], 1)
        }
    }
    
    for(m of map.values()){
        answer*=(m+1)
    }
    
    return answer-1;
}