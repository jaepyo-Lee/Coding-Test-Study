n = int(input())
graph = [[0] * n for _ in range(n)]
visited = [False] * n

# 두 사람의 번호
target1, target2 = map(int, input().split())

# 부모-자식 관계 수
relationship_num = int(input())

# 관계 입력
for _ in range(relationship_num):
    x, y = map(int, input().split())
    graph[x-1][y-1] = graph[y-1][x-1] = 1

# DFS로 탐색하면서 촌수를 계산
result = -1  # 결과 초기화 (찾지 못하면 -1 반환)


def dfs(node, cnt):
    global result
    visited[node-1] = True

    if node == target2:  # 목표 노드 도달
        result = cnt
        return

    for i in range(1, n+1):
        if not visited[i-1] and graph[node-1][i-1] == 1:
            dfs(i, cnt + 1)  # 다음 노드로 이동


# 탐색 시작
dfs(target1, 0)
print(result)
