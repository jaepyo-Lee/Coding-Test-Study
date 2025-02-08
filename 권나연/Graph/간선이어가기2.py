import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
D = [INF] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

s, t = map(int, input().split())

def dijkstra(start, end):
    q = []
    D[start] = 0
    heapq.heappush(q, (D[start], start))
    answer = 0

    while q:
        weight, node = heapq.heappop(q)

        if node == end:
            answer = weight
            break
        
        if D[node] < weight:
            continue
        for adjacency_node, next_weight in graph[node]:
            cal_weight = next_weight + weight
            if (D[adjacency_node] > cal_weight):
                D[adjacency_node] = cal_weight
                heapq.heappush(q, (cal_weight, adjacency_node))

    return answer

print(dijkstra(s, t))
