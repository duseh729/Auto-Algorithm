function solution(s) {
    var answer = '';
    
    const strArr = s.split(" ")
    // console.log(strArr)
    for(let i=0; i<strArr.length; i++){
        if(strArr[i]==''){
            answer+=" "
            continue;
        }
        answer+=strArr[i][0].toUpperCase()
        answer+=strArr[i].substring(1).toLowerCase()
        answer+=" "
    }
    
    return answer.substring(0, answer.length-1);
}