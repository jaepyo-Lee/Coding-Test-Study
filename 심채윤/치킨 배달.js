const input = ['5 3', '0 0 1 0 0', '0 0 2 0 1', '0 1 2 0 0', '0 0 1 0 0', '0 0 0 0 2']

const [n, m] = input[0].split(' ').map(Number)
const arr = input.slice(1).map(el => el.split(' ').map(Number))
const dp = new Array(n).fill([]).map(() => new Array(n).fill(0))

// 대각선 +2, 동서남북 +1

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    if (!arr[i][j]) continue;
    if (arr[i][j] === 1) {
      // ...
    }
  }
}


console.log(dp)