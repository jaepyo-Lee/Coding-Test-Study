// const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const input1 = ['4 2 0 0 8', '0 2', '3 4', '5 6', '7 8', '4 4 4 1 3 3 3 2'];

const input = input1;

let [n, m, x, y, k] = input[0].split(' ').map(Number); // 세로, 가로, x, y, k
const tc = input.slice(1, -1).map(el => el.split(' ').map(Number));
const commands = input[input.length - 1].split(' ').map(Number);

const arr = Array.from({ length: n }, () => Array(m).fill(0));
let dice = [0, 0, 0, 0, 0, 0]; // 동, 서, 위아래
let ground = 5;
const direction = [
  [0, 1],
  [0, -1],
  [-1, 0],
  [1, 0],
]; // 동서북남

tc.forEach((item, index) => {
  for (let i = 0; i < item.length; i++) {
    arr[index][i] = item[i];
  }
});

console.log(dice);

commands.forEach(command => {
  const nx = x + direction[command - 1][1];
  const ny = y + direction[command - 1][0];

  if (nx < 0 || nx >= m || ny < 0 || ny >= n) return;

  x = nx;
  y = ny;

  const [a, b, c, d, e, f] = dice;

  if (command === 1) {
    dice = [c, d, f, e, b, a];
  } else if (command === 2) {
    dice = [e, b, c, d, a, f];
  } else if (command === 3) {
    dice = [a, b, d, e, f, c];
  } else if (command === 4) {
    dice = [a, b, f, c, d, e];
  }

  if (arr[y][x] === 0) {
    arr[y][x] = dice[5];
  } else if (dice[5] === 0) {
    dice[5] = arr[y][x];
  }

  console.log(dice[3]);
});

// 4 3 2 1 5 6
// 북 4 3 6 1 2 5
// 남 4 3 6 2 1 5
// 서 1 4 2 3 5 6
// 동 1 6 2 4 5 3
