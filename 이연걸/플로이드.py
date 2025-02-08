n = int(input())
m = int(input())
path = [[1e11] * (n+1) for _ in range(n+1)]
for i in range(n + 1): path[i][i] = 0
for _ in range(m):
    a, b, c = map(int, input().split())
    path[a][b] = min(path[a][b], c)

for k in range(1, n+1): # 경유노드
    for i in range(1, n+1): # 출발노드
        for j in range(1, n+1): # 도착노드
            if path[i][j] > path[i][k] + path[k][j]:
                path[i][j] = path[i][k] + path[k][j]

for i in range(1, n+1):
    for j in range(1, n+1):
        if path[i][j] == 1e11: print(0, end=' ')
        else: print(path[i][j], end=' ')
    print()
