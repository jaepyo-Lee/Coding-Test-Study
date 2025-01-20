// @ts-nocheck
const input = require("fs")
  .readFileSync("./dev/stdin.txt")
  .toString()
  .trim()
  .split("\n")
  .map((e) => e.split(" "))
  .map((e) => e.map((e2) => Number(e2)));
const ans = () => {
  const [n, m] = input.shift();
  const edges = input;
  const graph = Array.from({ length: n + 1 }, () => []);
  const dist = Array(n + 1).fill(Infinity);
  const visit = Array(n + 1).fill(false);
  for (let i = 0; i < edges.length; i++) {
    const [start, end, diff] = edges[i];
    graph[start].push([end, diff]);
    graph[end].push([start, diff]);
  }
  const dij = (start) => {
    const q = [[0, start]];
    dist[start] = 0;

    while (q.length > 0) {
      let minIdx = -1;
      let minDist = Infinity;

      for (let i = 0; i < q.length; i++) {
        if (q[i][0] < minDist) {
          minIdx = i;
          minDist = q[i][0];
        }
      }

      const [curDist, curNode] = q[minIdx];
      q.splice(minIdx, 1);
      if (visit[curNode]) continue;
      visit[curNode] = true;

      for (let i = 0; i < graph[curNode].length; i++) {
        const nextNode = graph[curNode][i][0];
        const weight = graph[curNode][i][1];
        const newDist = curDist + weight;
        if (newDist < dist[nextNode]) {
          dist[nextNode] = newDist;
          q.push([newDist, nextNode]);
        }
      }
    }
  };
  dij(1);
  console.log(dist);
  console.log(dist[n]);
};
ans();
