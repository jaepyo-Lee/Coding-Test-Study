function solution(n, computers) {
  var answer = 0;
  const grap = Array.from({ length: n + 1 }, () => []);
  for (let i = 0; i < computers.length; i++) {
    for (let j = 0; j < computers.length; j++) {
      const par = i;
      const chi = j;
      if (computers[i][j] === 1) {
        grap[i + 1].push(j + 1);
      }
    }
  }

  const visit = Array(n + 1).fill(false);

  const dfs = (node) => {
    for (let i = 0; i < grap[node].length; i++) {
      const curChi = grap[node][i];
      if (visit[curChi] === false) {
        visit[curChi] = true;
        dfs(curChi);
      }
    }
  };
  for (let i = 1; i < n + 1; i++) {
    if (visit[i] === false) {
      visit[i] = true;
      dfs(i);
      answer++;
    }
  }

  return answer;
}
