function solution(d, budget) {
    var answer = 0;
    d.sort((a, b)=>a-b)
    
    let bClone = budget;
    for(let i of d){
        if(i<=bClone){
            bClone-=i;
            answer++;
            continue;
        }
        break;
    }
    
    return answer;
}