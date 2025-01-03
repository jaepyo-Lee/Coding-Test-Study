import sys

n, m = map(int, input().split()) # 정점 개수, 주어지는 문자열 길이
S = input().split() # 평소 좋아하는 산책길 종류 순서

wiki = [[""] * (n+1) for _ in range(n+1)] # 한 노드에서 다른 노드로 이동할 때 알파벳이 뭔지 알려주는 애
tree = {} # 지도 이진 트리
for _ in range(m): #
    u, v, c = list(input().split()) # wiki 만들기
    u, v = int(u), int(v)
    wiki[u][v] = wiki[v][u] = c

    if u not in tree: # tree 만들기
        tree[u] = []
    if v not in tree:
        tree[v] = []
    tree[u].append(v)
    tree[v].append(u)

# 이제 내려갈 수 있는 모든 경로를 찾는다.
routes = []
def dfs(cur, route):
    if len(tree[cur]) == 1:
        routes.append(route)
        return
    for st in tree[cur]:
        if st not in route:
            route.append(st)
            dfs(st, route[:])
            route.pop()
for st in tree[1]:
    dfs(st, [1, st])

# 이제 경로를 알파벳으로 변환한다.
lcs_list = []
for route in routes:
    lcs = []
    for i in range(len(route)-1):
        
        lcs.append(wiki[route[i]][route[i+1]])
    lcs_list.append(lcs)

# 이제 가장 긴 공통 부분 수열을 찾는다.
answer = 0
def get_lcs(lst):
    # 여기서 S랑 lst랑 비교해야함

    prev, cur = [0] * (len(lst) + 1), [0] * (len(lst) + 1)# 이전꺼 리스트, 지금 리스트
    
    for c in S:
        for i in range(1, len(lst) + 1):
            if c == lst[i]:
                
    
for lst in lcs_list:
    answer = max(answer, lcs(lst))

