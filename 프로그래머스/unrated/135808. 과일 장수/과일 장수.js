function solution(k, m, score) {
  var answer = 0;
  let appleContainer = [];
  score = score.sort((a, b) => b - a);
  for (i = 0; i < score.length - 1; i += m) {
    let appleBox = [];
    for (j = i; j < i + m; j++) {
      appleBox.push(score[j]);
    }
    appleContainer.push(appleBox);
  }
  for (i of appleContainer) {
    if (i.includes(undefined)) {
    } else {
      const result = Math.min(...i) * m;
      answer += result;
    }
  }
  return answer;
}
