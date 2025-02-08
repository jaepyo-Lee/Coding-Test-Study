import heapq

n, m = map(int, input().split())
maze = [list(input()) for _ in range(m)]

# 방 하나가 노드, 벽이 있으면 가중치1 없으면 가중치0

direction = [(1,0), (-1,0), (0,1), (0,-1)]
dist = [[1e9] * (n) for _ in range(m)]
def dij():
    dist[0][0] = 0
    queue = [(0, 0, 0)]
    while queue:
        d, cx, cy = heapq.heappop(queue)
        if d > dist[cx][cy]: continue

        for dx, dy in direction:
            nx, ny = cx + dx, cy + dy
            if 0 <= nx < m and 0 <= ny < n:
                if dist[nx][ny] != 1e9: continue
                weight = 0
                if maze[nx][ny] == '1': weight = 1
                dist[nx][ny] = min(dist[cx][cy] + weight, dist[nx][ny])
                heapq.heappush(queue, (dist[nx][ny], nx, ny))

dij()
print(dist[m-1][n-1])
        
