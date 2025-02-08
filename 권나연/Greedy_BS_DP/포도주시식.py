N = int(input())
wine = [int(input()) for _ in range(N)]

def dp():
    if N == 1:
        return wine[0]
    elif N == 2:
        return wine[0] + wine[1]
    
    DP = [0] * (N+1)
    DP[0] = wine[0]
    DP[1] = wine[0] + wine[1]

    for i in range(2, N):
        DP[i] = max(DP[i-1], wine[i] + wine[i-1] + DP[i-3], DP[i-2] + wine[i])
    return max(DP)

print(dp())