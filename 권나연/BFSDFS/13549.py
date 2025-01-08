from collections import deque

n, k = map(int, input().split())
limit = 100001
cnt = [0] * limit
visited = [False] * (limit)

def bfs(start, target):
    queue = deque()
    queue.append(start)
    visited[start] = True

    while queue:
        x = queue.popleft()

        if x == target:
            return cnt[x]
        
        for nx in (2*x, x+1, x-1):
            if 0<= nx < limit and visited[nx] == False:
                visited[nx] = True
                if nx == 2 * x:
                    cnt[2*x] = cnt[x]
                    queue.appendleft(nx)
                else:
                    cnt[nx] = cnt[x] + 1
                    queue.append(nx)

print(bfs(n, k))