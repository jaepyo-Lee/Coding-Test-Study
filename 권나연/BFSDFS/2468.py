import sys
sys.setrecursionlimit(10**6)

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def dfs(x, y, h):
    for m in range(4):
        nx = x + dx[m]
        ny = y + dy[m]

        if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and graph[nx][ny] > h:
            visited[nx][ny] = True
            dfs(nx, ny, h)

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
answer = 1

for k in range (1, max(map(max, graph))):
    visited = [[False] * n for _ in range(n)]
    count = 0 
    for i in range(n):
        for j in range(n):
            if (graph[i][j] > k) and (not visited[i][j]):
                count += 1
                visited[i][j] = True
                dfs(i, j, k)
    answer = max(answer, count)

print(answer)