from collections import deque

m, n, h = map(int, input().split())

remain_cnt = 0 # 익어야 하는 토마토 개수

tmts = [] # 보관된 토마토
ripes = [] # 익은 토마토 위치
for i in range(h):
    rec = []
    for j in range(n):
        line = list(map(int, input().split()))
        for k in range(m):# 익은 토마토의 위치 정보
            if line[k] == 1: ripes.append([i, j, k])
        remain_cnt += line.count(0)
        rec.append(line)
    tmts.append(rec)

# 이제 익은 토마토 위치에서 BFS로 퍼져나가야함.
# 방문한 익은 토마토는 필요 없음
dir = [[1, 0, 0], [-1, 0, 0], [0, 1, 0], [0, -1, 0], [0, 0, 1], [0, 0, -1]]
vis = [[[0] * m for _ in range(n)] for _ in range(h)]

q = deque()
for i, j, k in ripes:
    q.append([i, j, k])
    vis[i][j][k] = 1

spread_cnt = 0
nq = deque()
while q:
    if remain_cnt == 0: break

    while q: #여기서 한번 다 털고
        ci, cj, ck = q.popleft()

        for di, dj, dk in dir:
            ni, nj, nk = ci + di, cj + dj, ck + dk
            if 0 <= ni < h and 0 <= nj < n and 0 <= nk < m:
                if tmts[ni][nj][nk] == 0 and vis[ni][nj][nk] == 0:
                    nq.append([ni, nj, nk])
                    vis[ni][nj][nk] = 1
                    remain_cnt -= 1
    q = deque.copy(nq)
    nq.clear()
    spread_cnt += 1

if remain_cnt != 0: print(-1)
else: print(spread_cnt)
