n = int(input())
graph = [[0] * n for _ in range(n)]
visited = [False] * n

target1, target2 = map(int, input().split())

relationship_num = int(input())

for _ in range(relationship_num):
    x, y = map(int, input().split())
    graph[x-1][y-1] = graph[y-1][x-1] = 1

# 결과 초기화 (찾지 못하면 -1 반환)
result = -1  

def dfs(a, cnt):
    global result
    visited[a-1] = True

    if a == target2:  
        result = cnt
        return

    for i in range(1, n+1):
        if not visited[i-1] and graph[a-1][i-1] == 1:
            dfs(i, cnt + 1)  # 다음 노드로 이동

dfs(target1, 0)
print(result)
