import sys

input = sys.stdin.readline
INF = sys.maxsize

N =  int(input())
M = int(input())

graph = [[INF] * (N+1) for _ in range(N+1)]

for i in range(M):
    a, b, c = map(int, input().split())
    #이미 있는 값과 비교해 더 작은 비용을 저장장
    graph[a][b] = min(graph[a][b], c)

#자기 자신으로 가는 비용은 0으로 초기화화
for i in range(1, N+1):
    graph[i][i] = 0

for k in range(1, (N+1)):
    for i in range(1, (N+1)):
        for j in range(1, (N+1)):
            if (graph[i][k] != INF) and (graph[k][j] != INF):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
            

for i in range(1, N+1):
    for j in range(1, N+1):
        if graph[i][j] == INF:
            print(0, end = " ")
        else:
            print(graph[i][j], end=" ")
    print()
