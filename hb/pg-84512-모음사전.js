function solution(word) {
  var answer = 0;
  const arr = ["A", "E", "I", "O", "U"];
  const cur = [];
  const ans = [];
  let isFound = false;

  const bk = (k) => {
    if (k <= 5) {
      const val = cur.slice(0, k).join("");
      if (val === word) {
        answer = ans.length + 1;
      } else {
        ans.push(cur.slice(0, k).join(""));
        for (let i = 0; i < 5; i++) {
          cur[k] = arr[i];
          bk(k + 1);
        }
      }
    }
  };

  for (let i = 0; i < 5; i++) {
    cur[0] = arr[i];
    bk(1);
  }
  console.log(ans.length);
  return answer;
}
