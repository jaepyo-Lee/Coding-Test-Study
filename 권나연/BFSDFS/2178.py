from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, input().strip())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs(x, y):
    queue = deque()
    queue.append([x, y])

    while queue:
        #현재 위치
        x, y = queue.popleft()

        #현재 위치에서 상하좌우 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == False and graph[nx][ny] == 1:
                    graph[nx][ny] = graph[x][y] + 1
                    visited[nx][ny] = True
                    queue.append([nx, ny])

    # for graphs in graph:
    #     print(graphs)
    return graph[n-1][m-1]

print(bfs(0, 0))