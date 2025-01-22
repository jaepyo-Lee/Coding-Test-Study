import sys
import heapq

INF = sys.maxsize
input = sys.stdin.readline

N, D = map(int, input().split())

graph = [[] for _ in range(D+1)]
dist = [INF] * (D+1)

for i in range(D):
    graph[i].append(((i+1), 1))

for _ in range(N):
    a, b, c = map(int, input().split())
    if b <= D:
        graph[a].append((b, c))

def dijkstra(start):
    dist[start] = 0

    q = []
    heapq.heappush(q, (dist[start], start))

    while q:
        weight, node = heapq.heappop(q)

        if(dist[node] > weight) :
            continue

        for adjacency_node, next_weight in graph[node]:
            cal_weight = weight + next_weight
            if dist[adjacency_node] > cal_weight:
                dist[adjacency_node] = cal_weight
                heapq.heappush(q, (cal_weight, adjacency_node))
    return dist[D]


print(dijkstra(0))

