""" 플로이드 워셜 - 시간초과
import sys

input = sys.stdin.readline
INF = sys.maxsize

V, E = map(int, input().split())

graph = [[INF] * (V+1) for _ in range(V+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c

for k in range(1, (V+1)):
    for i in range(1, (V+1)):
        for j in range(1, (V+1)):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

result = INF

for i in range(1, (V+1)):
    result = min(result, graph[i][i])

if result != INF:
    print(result)
else:
    print(-1)
"""

import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

V, E = map(int, input().split())

graph = [[] for _ in range(V+1)]
D = [[INF] * (V+1) for _ in range(V+1)]
q = []

for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    D[a][b] = min(D[a][b], c)
    heapq.heappush(q, (c, a, b))

while q:
    weight, previous, curr_node = heapq.heappop(q)

    if (previous == curr_node):
        print(weight)
        break

    for adjacency_node, next_weight in graph[curr_node]:
        if(D[previous][adjacency_node] > D[previous][curr_node] + next_weight):
            D[previous][adjacency_node] = D[previous][curr_node] + next_weight
            heapq.heappush(q, (D[previous][adjacency_node], previous, adjacency_node))

else:
    print(-1)
