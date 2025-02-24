function solution(phone_book) {
    var answer = true;
    
    const map = new Map();
    
    for(let phone of phone_book){
        map.set(phone, true);
    }
    
    for(let phone of map.keys()){
        for(let i=1; i<phone.length; i++){
            if(map.has(phone.substring(0, i))){
                return false;
            }
        }
    }
    
    return answer;
}