from collections import deque

# 왼쪽, 오른쪽, 앞, 뒤  위, 아래,  
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

m, n, h = map(int, input().split())
graph = [[list(map(int,input().split())) for i in range(n)] for depth in range(h)]


def bfs():
     queue = deque()

     for x in range (h):
        for y in range (n):
            for z in range (m):
                    if graph[x][y][z] == 1:
                        queue.append([x, y, z])

     while queue:
          x, y, z = queue.popleft()

          for i in range(6):
               nx = x + dx[i]
               ny = y + dy[i]
               nz = z + dz[i]

               if 0 <= nx < h and 0 <= ny < n and 0 <= nz < m:
                    if graph[nx][ny][nz] == 0:
                         graph[nx][ny][nz] = graph[x][y][z] + 1
                         queue.append((nx, ny, nz))

def how_many_days():
    days = 0
    for x in range(h):
       for y in range(n):
            for z in range(m):
                 if graph[x][y][z] == 0:
                      return -1
                 days = max(days, graph[x][y][z])               
          
    return (days - 1)

bfs()
print(how_many_days())
