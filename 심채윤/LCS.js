const input = ['ACAYKP', 'CAPCAK']

const str1 = input[0]
const str2 = input[1]
// let current = 0
let target = 0
// const result = []

// while (target < str1.length) {
// 	for (let i = target; i < str1.length; i++) {
// 		if (!str1.includes(str2[target])) continue;

// 		if (current - 1 === str1.length - 1) {
// 			current = 0;
// 			continue;
// 		}

// 		if (str1[target] === str2[i]) {
//       result.push(str1[target])
// 			target++;
// 			continue;
// 		}
// 	}

//   target++;
// 	current++;
// }

// console.log(result.join(''))

let current = 1
const result = []

for (let i = 0; i < str1.length; i++) {
  for (let j = current; j < str2.length; j++) {
    if (str1[i] === str2[j]) {
      result.push(str1[i])
      current = i + 1
      break;
    }
  }
}

console.log(result.join(''))