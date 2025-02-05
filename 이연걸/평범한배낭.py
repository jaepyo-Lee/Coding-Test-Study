n, k = map(int, input().split())
stuff_list = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * (k+1)

# for wei, val in stuff_list:
#     for i in range(wei, k+1):
#         dp[i] = max(val + dp[i-wei], dp[i])

for wei, val in stuff_list:
    for i in range(k, wei-1, -1):
        dp[i] = max(val + dp[i-wei], dp[i])

print(dp[k])
