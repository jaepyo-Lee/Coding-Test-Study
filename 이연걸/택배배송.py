n, m = map(int, input().split())
graph = {}
for _ in range(m):
    a, b, c = map(int, input().split())
    if a not in graph: graph[a] = []
    if b not in graph: graph[b] = []
    graph[a].append([b, c])
    graph[b].append([a, c])


import heapq
def dijkstra(graph):
    distances =  {node: float('inf') for node in graph}
    distances[0] = 0
    distances[1] = 0
    queue = [(0, 1)]

    while queue:
        cur_distance, cur_node = heapq.heappop(queue)

        if cur_distance > distances[cur_node]: continue

        for neighbor, weight in graph[cur_node]:
            distance = cur_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))
    return distances

dists = dijkstra(graph)
print(dists[n])
