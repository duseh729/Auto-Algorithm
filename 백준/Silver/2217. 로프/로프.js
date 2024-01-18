const fs = require('fs');
// TODO: 제출 시 경로 변환 필수 ("/dev/stdin")
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// console.log(input)

input.splice(0,1)
// console.log(input)
// 풀이
function solution(arr) {
  const answer=[];
  for(let i of arr){
    answer.push(Number(i))
  }

  answer.sort((a,b)=>a-b)

  let maxLength = 0
  let arrLength = answer.length
  for(let i=0; i<=answer.length-1; i++){
    maxLength = Math.max(maxLength, answer[i]*arrLength)
    arrLength-=1
  }

  return maxLength;
}


console.log(solution(input));