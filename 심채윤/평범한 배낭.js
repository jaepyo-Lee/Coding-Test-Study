const input1 = ['4 7', '6 13', '4 8', '3 6', '5 12'] // 14
const input3 = ['3 5', '2 3', '3 2', '5 4'] // 5

const input = input3;

const [n, k]  = input[0].split(' ').map(Number)
const arr = input.slice(1).map(el => el.split(' ').map(Number))
const dp = new Array(k + 1).fill(0)

arr.sort((a, b) => a[0] - b[0]);

for (let i = 0; i < arr.length; i++) {
  const [weight, value] = arr[i]
  for (let j = k; j >= weight; j--) {
    dp[j] = Math.max(dp[j], dp[j - weight] + value);
	}
}

console.log(dp[k])