function solution(n, lost, reserve) {
    var answer = n-lost.length;
    
    // lost[4,2] reserve[3,5] 같은 케이스를 위한 정렬
    lost.sort((a,b)=>a-b)
    reserve.sort((a,b)=>a-b)
    
    // 여벌은 가져왔는데 도난 당한 경우 처리
    for (i of lost){
        if (reserve.includes(i)){
            reserve = reserve.filter(element => element!==i)
            lost = lost.filter(element => element!==i)
            answer+=1
            continue;
        }
    }
    
    // 잃어버렸는데 여벌 빌릴 수 있는지, 아랫번호 학생 먼저 빌려야 최적의 해 구할 수 있음.
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