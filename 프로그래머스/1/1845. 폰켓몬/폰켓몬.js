function solution(nums) {
    let answer = 0;
    const map = new Map();
    
    for(let n of nums){
        if(map.get(n)){
            continue;
        }else{
            map.set(n, true)
            answer++;
        }
    }
    
    return answer>(nums.length/2) ? nums.length/2 : answer;
}