function solution(A, B) {
  var answer = 0;
  const arr = A.sort((a, b) => a - b);
  const brr = B.sort((a, b) => a - b);
  while (1) {
    if (arr.length <= 0) {
      break;
    }
    const lastA = arr[arr.length - 1];
    const lastB = brr[brr.length - 1];
    if (lastA < lastB) {
      arr.pop();
      brr.pop();
      answer++;
    } else {
      arr.pop();
    }
  }
  return answer;
}
