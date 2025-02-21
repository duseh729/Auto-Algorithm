let answer = 0;
function solution(A,B){
    const aClone = A.sort((a, b)=> a-b)
    const bClone = B.sort((a, b)=> b-a)
    
    for(let i=0; i<A.length; i++){
        answer+=(aClone[i]*bClone[i])
    }
    return answer;
}