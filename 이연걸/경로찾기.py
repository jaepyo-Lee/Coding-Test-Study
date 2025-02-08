n = int(input())
graph = []
for _ in range(n): graph.append(list(map(int, input().split())))


def fs():
    for k in range(n): # 경유 노드
        for i in range(n): # 출발 노드
            for j in range(n): # 도착 노드
                if graph[i][k] and graph[k][j]:
                    graph[i][j] = 1
fs()
for i in range(n):
    for j in range(n):
        print(graph[i][j], end=' ')
    print()
