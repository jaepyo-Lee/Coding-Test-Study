# 가장 많은 양의 포도주를 마실 수 있어야함.
# 연속으로 놓여 있는 3잔을 모두 마실 수 없다는 조건이 있으므로 이전의 선택이 현재의 선택에 영향을 줌
# DP 문제

n = int(input())
wines = []
for _ in range(n):
    wines.append(int(input()))

if n <= 2:
    print(sum(wines))
else:
    dp = [0] * n
    dp[0], dp[1] = wines[0], wines[0] + wines[1]
    dp[2] = max(wines[0] + wines[2], wines[0] + wines[1], wines[1] + wines[2])
    for i in range(3, n):
        dp[i] = max(
            dp[i-3] + wines[i-1] + wines[i],
            dp[i-2] + wines[i],
            dp[i-1])
    
    print(dp[n-1])



# 6, 10, 13, 9, 8, 1

# dp[n] = n번째 잔으로 갔을 때 마실 수 있는 최대 포도주양
# dp[0] = 6
# dp[1] = 6 + 10
# dp[2] = 10 + 13
# dp[3] = dp[0] + wines[2] + wines[3]
# dp[4] = dp[2] + wines[4]
# dp[5] = dp
