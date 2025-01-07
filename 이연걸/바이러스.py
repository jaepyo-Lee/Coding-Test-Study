from collections import deque

comp_cnt = int(input())
conn_comp_cnt = int(input())

graph = {}
for _ in range(conn_comp_cnt):
    n1, n2 = map(int, input().split())
    if n1 not in graph:
        graph[n1] = []
    if n2 not in graph:
        graph[n2] = []
    graph[n1].append(n2)
    graph[n2].append(n1)

q = deque()
q.append(1)
vis = [1]
while q:
    cur = q.popleft()
    for new in graph[cur]:
        if new not in vis:
            q.append(new)
            vis.append(new)

print(len(vis)-1)
