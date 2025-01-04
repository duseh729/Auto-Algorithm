function solution(s) {
    var answer = 0;
    
    let sClone = s;
    
    for(let i=0; i<s.length; i++){
        if(isCorrect(sClone)){
            answer++;
        }
        sClone=sClone.substring(1)+sClone.substring(0, 1);
    }
    
    return answer;
}

function isCorrect(bracket){
    const bracketStack = [];
    
    for(let b of bracket){
        if(b==='['){
            bracketStack.push(']')
        }else if(b==='{'){
            bracketStack.push('}')
        }else if(b==='('){
            bracketStack.push(')')
        }else{
            if(bracketStack.length>0){
                if(b===bracketStack[bracketStack.length-1]){
                    bracketStack.pop();
                }
            }else{
                return false;
            }
        }
    }
    if(bracketStack.length===0) {
        return true;
    }
    return false;
}