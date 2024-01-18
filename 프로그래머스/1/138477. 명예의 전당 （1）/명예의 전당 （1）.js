function solution(k, score) {
    var answer = [];
    
    const tempArr=[]
    for (let i of score){
        if(tempArr.length < k){
            tempArr.push(i)
            answer.push(Math.min(...tempArr))
        }else{
            if(Math.min(...tempArr)<i){
                tempArr.splice(tempArr.indexOf(Math.min(...tempArr)), 1, i)
                answer.push(Math.min(...tempArr))
            }else{
                answer.push(Math.min(...tempArr))
            }
        }
    }
    
    return answer;
}