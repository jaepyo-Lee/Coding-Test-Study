import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

M, N = map(int, (input().split()))

graph = [list(map(int, input().rstrip())) for _ in range(N)]
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
dist = [[INF] * M for _ in range(N)]

def dijkstra(x, y):
    dist[x][y] = 0

    q = []
    heapq.heappush(q, (0 , x, y))

    while q:
        weight, node_x, node_y = heapq.heappop(q)

        if node_x == N -1 and node_y == M-1:
            return weight

        if weight > dist[node_x][node_y]:
            continue

        for i in range(4):
            node_nx = node_x+dx[i]
            node_ny = node_y+dy[i]

            if (0<=node_nx<N and 0<=node_ny<M):
                cal_weight = weight + graph[node_nx][node_ny]
                if dist[node_nx][node_ny] > cal_weight:
                    dist[node_nx][node_ny] = cal_weight
                    heapq.heappush(q, (cal_weight, node_nx, node_ny))
                
print(dijkstra(0, 0))
