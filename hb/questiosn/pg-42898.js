function solution(m, n, puddles) {
  var answer = 0;
  const dir = [
    [1, 0],
    [0, 1],
  ];
  const map = Array.from({ length: n }, () => Array(m).fill(0));
  const visit = Array.from({ length: n }, () => Array(m).fill(-1));
  visit[n - 1][m - 1] = 1;

  for (let i = 0; i < puddles.length; i++) {
    const py = puddles[i][1];
    const px = puddles[i][0];
    map[py - 1][px - 1] = 1;
  }
  const dfs = (row, col) => {
    if (visit[row][col] !== -1) {
      return visit[row][col];
    }
    let count = 0;
    dir.map((e) => {
      const ny = row + e[0];
      const nx = col + e[1];
      if (ny < n && nx < m && map[ny][nx] === 0) {
        count = (count + dfs(ny, nx)) % 1000000007;
      }
    });
    visit[row][col] = count;
    return count;
  };
  return dfs(0, 0);
}
