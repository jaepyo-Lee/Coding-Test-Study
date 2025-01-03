import sys
from itertools import permutations

n, m, k = map(int, input().split()) # 레일 개수, 택배 바구니 무게, 시행 횟수
weights = map(int, input().split()) # 택배 레일의 전용 무게

answer = 1e9
for case in permutations(weights, n): # 레일 배치를 여기서 정하고
    idx = 0
    total = 0
    for i in range(k): # k번 시행하게 함
        cur = 0
        while True: # 택배 바구니에 물건 채우기 시작
            if idx == n: idx = 0 # 인덱스가 끝으로 가게 되면 시작점으로 되돌아옴
            if cur + case[idx] > m: # 현 위치 택배 못담으면 여기서 정지
                break
            cur += case[idx]
            idx += 1
        total += cur 
    answer = min(answer, total) # 이번 시행때 담은 무게랑 지금까지 담았던 무게 중 최솟값이 정답.

print(answer)
