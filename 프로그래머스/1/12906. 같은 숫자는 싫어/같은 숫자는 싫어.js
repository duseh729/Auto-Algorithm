function solution(arr)
{
    var answer = [];

    let temp = null;
    for(let i of arr){
        if(i!=temp){
            answer.push(i);
            temp=i
        }
    }
    
    return answer
}