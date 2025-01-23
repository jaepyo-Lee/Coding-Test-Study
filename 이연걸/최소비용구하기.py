import heapq

n = int(input())
m = int(input())
buses = {}
for _ in range(m):
    a, b, c = map(int, input().split())
    if a not in buses: buses[a] = []
    buses[a].append((c, b))
st, en = map(int, input().split())

dist = [1e11] * (n + 1)
dist[st] = 0
queue = [(0, st)]

while queue:
    d, cur = heapq.heappop(queue)

    if d > dist[cur]: continue
    if cur not in buses: continue
    for nd, nxt in buses[cur]:
        if dist[nxt] > dist[cur] + nd:
            dist[nxt] = dist[cur] + nd
            heapq.heappush(queue, (dist[nxt], nxt))
print(dist[en])
