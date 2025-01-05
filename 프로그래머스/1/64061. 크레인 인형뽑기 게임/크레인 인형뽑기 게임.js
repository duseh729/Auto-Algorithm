function solution(board, moves) {
    var answer = 0;
    const storage = [];
    
    for(let m of moves){
        const temp = m-1;
        
        for(let b of board){
            // console.log(b);
            if(b[temp]==0){
                continue;
            }else{
                storage.push(b[temp]);
                b[temp]=0;
                break;
            }
        }
        // console.log(storage);
        let flag = true;
        
        while(storage.length>=2 && storage[storage.length-2]===storage[storage.length-1]){
                    storage.pop();
                    storage.pop();
                    answer+=2;
        }
    }
    
    return answer;
}