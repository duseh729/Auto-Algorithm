function solution(prices) {
    const n = prices.length;
    const answer = new Array(n).fill(0);
    const stack = [];  // (인덱스)만 저장

    for (let i = 0; i < n; i++) {
        while (stack.length > 0 && prices[i] < prices[stack[stack.length - 1]]) {
            let j = stack.pop();
            answer[j] = i - j;  // 현재 인덱스에서 이전 가격이 유지된 기간
        }
        stack.push(i);
    }

    // 끝까지 가격이 떨어지지 않은 요소 처리
    while (stack.length > 0) {
        let j = stack.pop();
        answer[j] = n - 1 - j;
    }

    return answer;
}
