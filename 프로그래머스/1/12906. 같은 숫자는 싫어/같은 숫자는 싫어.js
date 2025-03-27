function solution(arr)
{
    var answer = [];

    let temp = null;
   arr.forEach((val, idx) => {
        if (idx === 0 || val !== arr[idx - 1]) answer.push(val);
    });
    
    return answer
}