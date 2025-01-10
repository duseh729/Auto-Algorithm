function solution(numbers, target) {
    let answer = 0;

    function backtrack(count, numbers, target, index, now) {
        if (index === count) {
            if (target === now) {
                answer++; 
            }
            return; 
        }
        
        backtrack(count, numbers, target, index + 1, now + numbers[index]);
        backtrack(count, numbers, target, index + 1, now - numbers[index]);
    }

    backtrack(numbers.length, numbers, target, 0, 0);
    return answer;
}
