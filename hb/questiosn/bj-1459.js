const input = require("fs")
  .readFileSync("./dev/stdin.txt")
  .toString()
  .trim()
  .split("\n")[0]
  .split(" ")
  .map((e) => Number(e));

const [n, m, s, c] = input;
// 대각으로 가는 시간의 2배를 해도 
// 
const ans = () => {
  const diff = Math.max(n, m) - Math.min(n, m);
  const same = Math.min(n, m);
  let diffCalc = 0;
  if (diff % 2 === 0) {
    diffCalc = Math.min(diff * s, diff * c);
  } else {
    diffCalc = Math.min(diff * s, (diff - 1) * c + s);
  }
  const sameCale = Math.min(same * 2 * s, same * c);
  console.log(diffCalc + sameCale);
};
ans();
