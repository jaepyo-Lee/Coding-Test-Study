const dir = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
];
const bfs = (n, m, map) => {
  const q = [[0, 0]];
  map[0][0] = 2;
  while (q.length) {
    const cur = q.shift();
    dir.map((e) => {
      const ny = cur[0] + e[0];
      const nx = cur[1] + e[1];
      if (ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] === 1) {
        q.push([ny, nx]);
        map[ny][nx] = map[cur[0]][cur[1]] + 1;
      }
    });
  }
  return map[n - 1][m - 1] - 1;
  console.log(map[n - 1][m - 1] - 1);
};

function solution(maps) {
  var answer = 0;
  const n = maps.length;
  const m = maps[0].length;
  const ans = bfs(n, m, maps);
  return ans === 0 ? -1 : ans;
}
