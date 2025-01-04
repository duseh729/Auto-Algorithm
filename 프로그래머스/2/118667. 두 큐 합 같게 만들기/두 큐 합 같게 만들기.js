function solution(queue1, queue2) {
    var answer = 0;
    const qLength = queue1.length;
    
    let q1Index=0;
    let q2Index=0;
    
    let q1Sum = queue1.reduce((a, b)=>a+b);
    let q2Sum = queue2.reduce((a, b)=>a+b);
    
    for(let i=0; i<qLength*4; i++){
        if(queue1.length-1<q1Index||queue2.length-1<q2Index) {
            return -1;
        }
        
        
        if(q1Sum>q2Sum){
            queue2.push(queue1[q1Index]);
            
            q1Sum-=queue1[q1Index];
            q2Sum+=queue1[q1Index];
            
            q1Index++;
            
            answer++;
        }else if(q2Sum>q1Sum){
            queue1.push(queue2[q2Index]);
            
            q1Sum+=queue2[q2Index];
            q2Sum-=queue2[q2Index];
            
            q2Index++;
            
            answer++;
        }else{
            return answer;
        }
        // if()
    }
    
    return -1;
}