function solution(n, lost, reserve) {
    var answer = n-lost.length;
    lost.sort((a,b)=>a-b)
    for (i of lost){
        if (reserve.includes(i)){
            reserve = reserve.filter(element => element!==i)
            lost = lost.filter(element => element!==i)
            answer+=1
            continue;
        }
    }
    
    for (i of lost){
        if (reserve.includes(i-1)){
            reserve = reserve.filter(element=> element!==i-1)
            answer+=1;
            continue;
        }else if (reserve.includes(i+1)){
            reserve = reserve.filter(element => element!==i+1)
            answer+=1
            continue;
        }
    }
    return answer;
}