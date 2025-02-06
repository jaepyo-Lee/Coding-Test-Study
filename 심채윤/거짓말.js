const input1 = ['4 3', '0', '2 1 2', '1 3', '3 2 3 4']
const input2 = ['4 1', '1 1', '4 1 2 3 4']
const input3 = ['4 1', '0', '4 1 2 3 4']
const input4 = ['4 5', '1 1', '1 1', '1 2', '1 3', '1 4', '2 4 1']
const input5 = ['10 9', '4 1 2 3 4', '2 1 5', '2 2 6', '1 7', '1 8', '2 7 8', '1 9', '1 10', '2 3 10', '1 4']
const input6 = ['8 5', '3 1 2 7', '2 3 4', '1 5', '2 5 6', '2 6 8', '1 8']
const input7 = ['3 4', '1 3', '1 1', '1 2', '2 1 2', '3 1 2 3']
const input8 = ['10 3', '1 1', '2 1 2', '2 2 3', '2 3 4']

const input = input3

const [n, m] = input[0].split(' ').map(Number)  // 사람 수 n, 파티 수 m
const [k, ...p] = input[1].split(' ').map(Number) // 진실 수 k, 진실 사람 p
const arr = input.slice(2).map(el => el.split(' ').map(Number))
const dp = new Array(n + 1).fill(false) // true 진실 false 거짓

arr.sort((a, b) => b.length - a.length)

if (k === 0) {
  console.log(m)
  return;
}

for (let i = 0; i < k; i++) {
  dp[p[i]] = true;
}

let time = 0
let shouldUpdate = false

while (shouldUpdate) {
  shouldUpdate = false
	for (let i = 0; i < m; i++) {
		const people = arr[i].slice(1); // 파티 별 사람 목록 가져오기
		if (people.some((el) => dp[el])) {
			// 그 중 진실을 아는 사람이 있으면
			for (let j = 0; j < people.length; j++) {
				// 모든 사람에게 진실을 알리기
				if (!dp[people[j]]) {
          console.log(dp[people[j]])
					dp[people[j]] = true;
					shouldUpdate = true;
				}
			}
		}
	}
}

let cnt = 0

for (let i = 0; i < m; i++) {
	const people = arr[i].slice(1); 
	if (!people.every((el) => dp[el])) {
		cnt++
	}
}
console.log(cnt)