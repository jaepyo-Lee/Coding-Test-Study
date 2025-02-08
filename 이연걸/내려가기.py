n = int(input())
board = []
for _ in range(n): board.append(list(map(int, input().split())))

max_d = [[0] * 3 for _ in range(n)]
for i in range(3): max_d[0][i] = board[0][i]

for i in range(1, n):
    max_d[i][0] = board[i][0] + max(max_d[i-1][0], max_d[i-1][1])
    max_d[i][1] = board[i][1] + max(max_d[i-1][0], max_d[i-1][1], max_d[i-1][2])
    max_d[i][2] = board[i][2] + max(max_d[i-1][1], max_d[i-1][2])
print(max(max_d[n-1]), end=' ')

for i in range(1, n):
    max_d[i][0] = board[i][0] + min(max_d[i-1][0], max_d[i-1][1])
    max_d[i][1] = board[i][1] + min(max_d[i-1][0], max_d[i-1][1], max_d[i-1][2])
    max_d[i][2] = board[i][2] + min(max_d[i-1][1], max_d[i-1][2])

print(min(max_d[n-1]), end='')
