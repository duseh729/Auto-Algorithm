function solution(participant, completion) {
    var answer = '';
    
    const map = new Map();
    
    for(let p of participant){
        if(!map.has(p)){
            map.set(p, 1)
        }else{
            map.set(p, map.get(p)+1)
        }
    }
    
    for(let c of completion){
        map.set(c, map.get(c)-1);
    }

    for(let k of map.keys()){
        if(map.get(k)==1) return k
    }
    
    return answer;
}