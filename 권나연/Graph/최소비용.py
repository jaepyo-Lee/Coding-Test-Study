import heapq
import sys

INF = sys.maxsize
input = sys.stdin.readline

N = int(input())
M = int(input())
graph = [[] for _ in range(N+1)]
D = [INF] * (N+1)

for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

departure, destination = map(int, input().split())

def djkistra(start, end):
    D[start] = 0
    q = []
    heapq.heappush(q, (D[start], start))

    while q:
        weight, node = heapq.heappop(q)

        if D[node] < weight:
            continue

        for adjacency_node, next_weight in graph[node]:
            cal_weight = next_weight + weight
            if cal_weight < D[adjacency_node]:
                D[adjacency_node] = cal_weight
                heapq.heappush(q, (cal_weight, adjacency_node))
    
    return D[end]


print(djkistra(departure, destination))
