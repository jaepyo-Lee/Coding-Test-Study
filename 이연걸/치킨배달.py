from itertools import combinations
n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

kfc_list, house_list = [], []
for i in range(n):
    for j in range(n):
        if board[i][j] == 2: kfc_list.append([i, j])
        if board[i][j] == 1: house_list.append([i, j])

answer = 1e9
for kfc in combinations(kfc_list, m): # 어떤 지점을 살릴지
    tot_path = 0
    for hi, hj in house_list: # 각 집에서
        path = 1e9
        for ki, kj in kfc: # 살아남은 지점들까지의 최소 거리를 찾는다.
            path = min(path, abs(ki-hi) + abs(kj-hj))
        tot_path += path # 전체 치킨거리에 더한다.

    answer = min(answer, tot_path)

print(answer)
