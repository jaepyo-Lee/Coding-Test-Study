import heapq
v, e = map(int, input().split())
k = int(input())
d = {}
for _ in range(e):
    a, b, wei = map(int, input().split())
    if a not in d: d[a] = []
    # for i in range(len(d[a])):
    #     if d[a][i][1] == b and d[a][i][0] > wei:
    #         d[a].pop(i)
    d[a].append((wei, b))

def dij(st):
    weights = [1e9] * (v + 1)
    heap = [(0, st)]
    weights[st] = 0

    while heap:
        cur_w, cur_v = heapq.heappop(heap)
        if cur_w > weights[cur_v]: continue
        if cur_v not in d: continue

        for nxt_w, nxt_v in d[cur_v]:
            if weights[nxt_v] > weights[cur_v] + nxt_w:
                weights[nxt_v] = weights[cur_v] + nxt_w
                heapq.heappush(heap, (weights[nxt_v], nxt_v))
    return weights

dist = dij(k)
for i in range(1, len(dist)):
    if dist[i] == 1e9: print("INF")
    else: print(dist[i])
