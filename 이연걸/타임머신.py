n, m = map(int, input().split())
graph = []
for _ in range(m):
    a, b, c = map(int, input().split())
    graph.append([a, b, c])

def bmfd(st):
    dist = [1e9] * (n+1)
    dist[st] = 0
    
    for i in range(n): # n개의 노드 모두 확인
        for j in range(m): # m개의 간선 모두 확인
            cur, nxt, wei = graph[j][0], graph[j][1], graph[j][2]

            if dist[cur] != 1e9 and dist[cur] + wei < dist[nxt]:
                dist[nxt] = dist[cur] + wei
    
    for j in range(m):
        cur, nxt, wei = graph[j][0], graph[j][1], graph[j][2]
        if dist[cur] + wei < dist[nxt]:
            return [] # 음의 순환 존재
    return dist

dist = bmfd(1)
if len(dist) == 0: print(-1)
else:
    for i in range(2, n + 1):
        if dist[i] == 1e9:
            print(-1)
        else:
            print(dist[i])
