function solution(prices) {
    const n = prices.length;
    const answer = new Array(n).fill(0);
    const stack = [];  

    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && prices[i] < prices[stack[stack.length - 1]]) {
            let j = stack.pop();
            answer[j] = i - j; 
        }
        stack.push(i);
    }

    while (stack.length > 0) {
        let j = stack.pop();
        answer[j] = n - 1 - j;
    }

    return answer;
}
