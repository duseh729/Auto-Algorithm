function solution(code) {
    var answer = '';
    let mode=0
    for (let i = 0; i<code.length; i++){
        // '1'일 때 mode를 바꿔줘야 함
        if (code[i]==='1'){
            mode = (mode === 0)? 1 : 0  
        }else{
            // mode 값에 따라 실행할 코드가 다름
            if (mode === 0){
                if (i%2===0){
                    answer+=code[i]
                }
            }else{
                if (i%2!==0){
                    answer+=code[i]
                }
            }}
    }
    
    return answer.length===0 ? "EMPTY" : answer;
}