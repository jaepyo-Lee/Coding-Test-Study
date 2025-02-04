n, k = map(int, input().split())
stuff_list = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * (k+1)

for wei, val in stuff_list:
    for i in range(wei, k+1):
        # if wei > i:
        #     continue #지금 들고 있는 물건이 무게 i보다 크면 못넣음\
        # elif wei == i:
        #     dp[i] = max(val, dp[i])
        # else:
        dp[i] = max(val + dp[i-wei], dp[i])
    # print(dp)
print(dp[k])
