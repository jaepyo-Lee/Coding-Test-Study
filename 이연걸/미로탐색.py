from collections import deque

n, m = map(int, input().split())

maze = []
for _ in range(n): maze.append(list(map(int, input())))
vis = [[0] * m for _ in range(n)]

q = deque()
q.append([0, 0])
vis[0][0] = 1
while q:
    x, y = q.popleft()
    for dx, dy in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
        nx, ny = x + dx, y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if maze[nx][ny] == 1 and vis[nx][ny] == 0:
                q.append([nx, ny])
                vis[nx][ny] = vis[x][y] + 1

print(vis[n-1][m-1])
