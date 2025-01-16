# 과자 나눠주기
m, n = map(int, input().split())
snacks = list(map(int, input().split()))
_max = max(snacks)

'''
6 3
10 10 15
정답: 5

10 3
3 3 3
정답: 0

1 1
100
정답: 100

10 10
100 100 100 100 100 100 100 100 100 100 100
정답: 100

10 10
1 1 1 1 1 1 1 1 1 1 1
정답: 1
'''

answer = 0
st, en = 1, _max
while st <= en:
    mid = (st + en) // 2
    if mid == 0: break

    snacks_cnt = 0
    for s in snacks: snacks_cnt += s // mid

    if snacks_cnt < m:
        en = mid - 1
    elif snacks_cnt >= m:
        answer = max(answer, mid)
        st = mid + 1
print(answer)
