function solution(a, b, n) {
    var answer = 0;
    
    while(n>=a){
        const temp = Math.floor(n/a)
        answer+=(temp*b)
        n-=(temp*a)
        n+=(temp*b)
    }
    console.log(answer)
    return answer;
}