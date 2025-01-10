#자꾸 틀림...

from collections import deque

n, k = map(int, input().split())
limit = 10**5
cnt = [0] * (limit+1)

def bfs(start, target):
    queue = deque()
    queue.append(start)

    while queue:
        x = queue.popleft()

        if x == target:
            return cnt[x]
        
        for nx in (2*x, x-1, x+1):
            if 0<= nx < limit:
                if nx == 2 * x:
                    cnt[2*x] = cnt[x]
                else:
                    cnt[nx] = cnt[x] + 1
                queue.append(nx)

bfs(n, k)
print(cnt[k-1]-1)