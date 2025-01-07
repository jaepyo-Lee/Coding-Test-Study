from collections import deque

n, k = map(int, input().split())

road = [0] * (100001)
road[n], road[k] = -1, -10 # 수빈이와 동생을 직선 상에 둔다.

# 수빈이의 이동을 표현하면 [1, -1, 0]
q = deque()
q.append(n)
while q:
    cur = q.popleft()
    for d in [1, -1, 0]: # x+1, x-1, 2x
        if d == 0: cur *= 2
        else: cur += d

        if 0 <= cur <= 100000 and road[cur] >= 0:


# 진행중..
