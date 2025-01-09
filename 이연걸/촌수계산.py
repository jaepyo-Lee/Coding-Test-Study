from collections import deque

n = int(input()) # 전체 사람 수
p1, p2 = map(int, input().split())
m = int(input()) # 부모 자식들 관계의 개수
fam = {}
for _ in range(m):
    parent, child = map(int, input().split())
    if parent not in fam:
        fam[parent] = []
    if child not in fam:
        fam[child] = []
    fam[parent].append(child)
    fam[child].append(parent)

vis = [-1] * (n + 1)
q = deque()
q.append(p1)
vis[p1] = 0
while q:
    cur = q.popleft()
    if cur == p2: break
    if cur not in fam: continue
    for nxt in fam[cur]:
        if vis[nxt] == -1:
            q.append(nxt)
            vis[nxt] = vis[cur] + 1

print(vis[p2])
