const input1 = ['3', '1 2 3', '4 5 6', '4 9 0']
const input2 = ['3', '0 0 0', '0 0 0', '0 0 0']
const input = input2

const n = Number(input[0])
const arr = input.slice(1).map(el => el.split(' ').map(Number)).reverse()
let max = 0
let min = Infinity;

function solution(depth, result, indexs) {
  if (depth === n) {
    const sum = result.reduce((a, b) => a + b)
    max = Math.max(max, sum)
    min = Math.min(min, sum)
    return;
  }

  for (let i = 0; i < n; i++) {
    if (indexs[indexs.length - 1] === 0 && i === 2) continue
    if (indexs[indexs.length - 1] === 2 && i === 0) continue
    solution(depth + 1, [...result, arr[result.length][i]], [...indexs, i]);
  }
}

solution(0, [], [])
console.log(max, min);