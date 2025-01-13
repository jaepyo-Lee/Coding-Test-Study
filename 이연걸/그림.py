from collections import deque

n, m = map(int, input().split())

board = []
for i in range(n):
    board.append(list(map(int, input().split())))

vis = [[0] * m for _ in range(n)]

pictures = [0]

for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and vis[i][j] == 0: # BFS 시작 지점
            size = 1
            q = deque()
            q.append([i, j])
            vis[i][j] = 1
            while q:
                x, y = q.popleft()
                for dx, dy in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < n and 0 <= ny < m:
                        if board[nx][ny] == 1 and vis[nx][ny] == 0:
                            q.append([nx, ny])
                            vis[nx][ny] = 1
                            size += 1
            
            pictures.append(size)

print(len(pictures)-1)
print(max(pictures))
