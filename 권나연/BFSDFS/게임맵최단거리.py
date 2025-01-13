from collections import deque

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]

    queue = deque()
    queue.append(0, 0)

    while queue:
        x, y = queue.popleft()

        for i in range(4):

            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == False and maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] + 1
                    visited[nx][ny] = True
                    queue.append([nx, ny])
    answer = maps[n-1][m-1]
    if answer == 1:
        answer = -1
    return answer
