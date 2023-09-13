//한 개의 입력(띄어쓰기x)
function solution(input) {
  let cnt = 0;
  let res = 0;
  while (true) {
    if (input % 5 === 0) {
      res = cnt + parseInt(input / 5);
      console.log(res);
      break;
    } else {
      input -= 3;
      cnt++;
    }
    if (input == 0) {
      console.log(cnt);
      break;
    }
    if (input < 0) {
      console.log(-1);
      break;
    }
  }
}

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input;
rl.on("line", function (line) {
  input = line;
  input = parseInt(line); // 입력 값이 정수라면 parseInt로 형변환
  rl.close();
}).on("close", function () {
  solution(input);
  process.exit();
});
