function solution(picture, k) {
    var answer = [];
    for (let i of picture){
        let idx=''
        for (let j of i){
            for (let i=0; i<k; i++){
                idx+=j
            }
        }
        for (let i=0; i<k; i++){
                answer.push(idx)
            }
    }
    return answer;
}