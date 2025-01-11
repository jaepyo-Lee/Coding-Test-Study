def solution(n, computers):
    count = 0
    visited = [False] * n

    # 앞서 인접 리스트의 시작점에 대한 dfs 수행
    def dfs(cur):
        visited[cur] = True
        #모든 노드에 대해서 시작점과의 연결 여부 확인 
        for i in range(n):
            #시작점이 아니고, 연결된 부분이 있으면 / 해당 조건 만족하지 못하면 빠져나옴.
            if not visited[i] and computers[cur][i]:
                #연결된 부분에 대해서도 dfs 수행  
                dfs(i)

    # 모든 노드에 대해서 인접 리스트 탐구
    for node_idx in range(n):
        if not visited[node_idx]:
            #방문하지 않은 노드에 대해서 dfs 수행 (1부터 차례대로)
            dfs(node_idx)
            #빠져나오면 count+1 
            count += 1

    return count