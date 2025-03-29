function solution(progresses, speeds) {
    var answer = [];
    
    let now = 0;
    
    const process = progresses.map((value, index)=>{
        const temp = 100-value;
        const temp2 = temp / speeds[index]
        return Math.ceil(temp2)
    })
    
    let count = 1;
    for(let i=1; i<process.length; i++){
        if(process[now]>=process[i]){
            count+=1;
        }else{
            answer.push(count)
            count=1;
            now=i;
        }
    }
    
    answer.push(count)
    
    return answer;
}