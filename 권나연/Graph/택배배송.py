"""
graph = [
    [], # 0번 노드 (사용되지 않음)
    [(2, 1), (4, 4)], # 1번 노드
    [(4, 0), (1, 1), (3, 6)], # 2번 노드
    [(6, 2), (2, 6), (4, 4)], # 3번 노드
    [(5, 3), (2, 0), (1, 4), (3, 4)], # 4번 노드
    [(6, 1), (4, 3)], # 5번 노드
    [(5, 1), (3, 2)], # 6번 노드
]

q = [(0, 1)]
"""

import sys
import heapq
input = sys.stdin.readline

N, M = map(int, input().split())

INF = sys.maxsize

#최단 거리 테이블 
D = [INF] * (N+1)

graph = [[] for _ in range(N+1)]

# a와 b는 연결된 노드, c는 비용
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

def dijkstra(start):
    D[start] = 0

    #우선순위 큐 힙힙
    q = []
    heapq.heappush(q, (D[start], start))

    while q:
        weight, node = heapq.heappop(q)

        for adjacency_node, next_weight in graph[node]:
            cal_weight = next_weight + weight

            if (cal_weight < D[adjacency_node]):
                D[adjacency_node] = cal_weight
                heapq.heappush(q, (D[adjacency_node], adjacency_node))

    return D[N]

print(dijkstra(1))
