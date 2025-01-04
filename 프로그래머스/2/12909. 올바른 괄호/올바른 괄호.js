function solution(s){
    var answer = true;
    
    const bracketStack = [];
    
    for(let i of s){
        if(i==='('){
            bracketStack.push(')');
        }else{
            if(bracketStack.length<=0){
                return false;
            }
            bracketStack.pop();
        }
    }
    if(bracketStack.length>0){
        return false;
    }

    return answer;
}