function solution(s) {
    var answer = 0;
    let sClone = s;
    let zeroAnswer = 0;
    
    while (sClone !== '1') {
        const len = sClone.length; // s.length -> sClone.length
        let zeroCount = 0;
        
        for (let i of sClone) {
            if (i === '0') {
                zeroCount++;
            }
        }

        sClone = (len-zeroCount).toString(2); // sClone을 업데이트
        answer++;
        zeroAnswer += zeroCount;
    }
    
    return [answer, zeroAnswer];
}
