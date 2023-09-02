function solution(board, moves) {
    var answer = 0;
    let answerArr = []
    for (k of moves){
        const idx = k-1;
        for(let i = 0; i<board.length; i++){
            if (board[i][idx]!==0){
                answerArr.push(board[i][idx])
                board[i][idx]=0
                break;
            }
        }
        const temp1 = answerArr.length;
        if(temp1>=2 && answerArr[temp1-1] === answerArr[temp1-2]){
            answerArr.splice(temp1-2, 2)
            answer+=2
        }
    }
    return answer;
}