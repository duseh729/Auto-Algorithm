function solution(s){
    var answer = true;

    const stack = [];
    
    for(let i of s){
        if(i=='('){
            stack.push(')')
        }else{
            // if(stack.length>0 && stack[stack.length-1]){
            if(stack.length>0){
                stack.pop();
            }else{
                return false;
            }
        }
    }
    
    if(stack.length>0){
        return false;
    }
    
    return answer;
}