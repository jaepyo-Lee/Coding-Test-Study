function solution(msg) {
  var answer = [];
  const map = new Map();
  for (let i = 1; i <= 26; i++) {
    map.set(String.fromCharCode(i + 64), i);
  }
  let count = 27;
  const arr = msg.split("");
  let i = 0;
  while (1) {
    if (i >= msg.length) {
      break;
    } else {
      let curVal = i + 1;
      let jump = 1;
      //step 1 find current letter
      let curLet = arr.slice(i, curVal).join("");
      if (map.has(curLet)) {
        while (1) {
          if (map.has(arr.slice(i, curVal + 1).join(""))) {
            curVal++;
            jump++;
            if (curVal > msg.length) break;
          } else {
            break;
          }
        }
      }
      curLet = arr.slice(i, curVal).join("");
      let nextLet = arr.slice(i, curVal + 1).join("");
      if (!map.has(nextLet)) {
        map.set(nextLet, count);
      }
      answer.push(map.get(curLet));
      count++;
      i += jump;
    }
  }
  return answer;
}
