n = int(input())

table = []
for _ in range(n):
    table.append(list(map(int, input().split())))

# dp[i][j] = i일차에
'''
dp[1][0] : 1일차에 1일차꺼를 집을 수 있을 때 최대 값
dp[1][1] : 1일차에 

특정 상담을 하기 위해서는 잔여 일수가 충분해야 하고, 현재 상담중인 사람이 없어야함.

dp[1] = 0
dp[2] = 0
dp[3] = 10
dp[4] = 10 + 10
dp[5] = 10 + 20
dp[6] = 10 + 20 + 15
dp[7] = 10 + 20 + 15
'''



print(table)
