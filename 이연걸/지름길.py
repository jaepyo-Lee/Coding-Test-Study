import heapq

N, D = map(int, input().split())

sp_dict = {}
for _ in range(N):
    st, en, d = map(int, input().split())
    if st not in sp_dict: sp_dict[st] = []
    sp_dict[st].append((d, en))

dist = [i for i in range(D+2)]
def dij():
    dist[0] = 0
    queue = [(0, 0)] # 0에서 현재 노드까지 거리, 현재 노드
    while queue:
        d, cur = heapq.heappop(queue)
        if d > dist[cur]: continue
        
        if cur > D: continue
        dist[cur + 1] = min(d+1, dist[cur + 1])
        heapq.heappush(queue, (dist[cur+1], cur+1))
        if cur in sp_dict:
            for new_d, nxt in sp_dict[cur]:
                if nxt > D: continue
                dist[nxt] = min(dist[cur] + new_d, dist[nxt])
                heapq.heappush(queue, (dist[nxt], nxt))
    return dist

dij()
print(dist[D])
