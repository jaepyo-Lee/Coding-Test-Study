from collections import deque

n, k = map(int, input().split())

road = [0] * (100001)

q = deque()
q.append(n)
road[n] = 1
while q:
    cur = q.popleft()
    if cur == k:
        break
    for nxt in [cur * 2, cur - 1, cur + 1]:

        if 0 <= nxt <= 100000:
            if road[nxt] == 0:
                if nxt == cur * 2:
                    road[nxt] = road[cur]
                else:
                    road[nxt] = road[cur] + 1
                q.append(nxt)

print(road[k] - 1)
