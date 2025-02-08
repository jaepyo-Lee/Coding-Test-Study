"""
N(인접 행렬 크기)
dist(노선 데이터를 저장하는 인접 행렬)

for (i -> N 만큼 반복) {
    for (j -> N만큼 반복) {
        인접 행렬 데이터를 dist 행렬에 그대로 저장장
        }
}

for (k -> N 만큼 반복) {
    for (i -> N 만큼 반복) {
        for (j -> N만큼 반복) {
            dist[i][k] == 1 이고, dist[k][j] == 1이면 dist[i][j] =1 로 저장장
        }
    }
}
"""

#입력
N = int(input())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))
    
    
#플로이드-워셜 알고리즘
for k in range(N): #경로 for문이 가장 상위 단계여야 누락되지 않는다
    for i in range(N):
        for j in range(N): 
            if graph[i][j] == 1 or (graph[i][k] == 1 and graph[k][j] == 1):
                graph[i][j] = 1


#출력
for row in graph:
    print(' '.join(map(str, row)))
