n, m = map(int, input().split())
graph = []
for _ in range(m):
    a, b, c = map(int, input().split())
    graph.append([a, b, c])

dist = [1e12] * (n+1)
def bmfd(st):
    dist[st] = 0
    
    for i in range(n): # n개의 노드 모두 확인
        for j in range(m): # m개의 간선 모두 확인
            cur, nxt, wei = graph[j][0], graph[j][1], graph[j][2]

            if dist[cur] != 1e12 and dist[cur] + wei < dist[nxt]:
                dist[nxt] = dist[cur] + wei
                if i == n - 1:
                    return True
    return False

if bmfd(1): print(-1)
else:
    for i in range(2, n + 1):
        if dist[i] == 1e12:
            print(-1)
        else:
            print(dist[i])
