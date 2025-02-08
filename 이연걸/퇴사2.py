n = int(input())
work = [[0, 0]]
for _ in range(n): work.append(list(map(int, input().split())))

dp = [0 for _ in range(n + 1)]
for i in range(1, n + 1):
    dp[i] = max(dp[i], dp[i-1])
    fin_date = i + work[i][0] - 1
    if fin_date <= n:
        dp[fin_date] = max(dp[fin_date], dp[i-1] + work[i][1])
print(dp[n])
'''
0    1   2   3   4   5   6   7
0    3   5   1   1   2   4   2
    10  20  10  20  15  40  200
'''
