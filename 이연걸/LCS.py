s1 = list(input())
s2 = list(input())

n1, n2 = len(s1), len(s2)
board = [[0] * (n2+1) for _ in range(n1+1)]
for i in range(1, n1+1):
    for j in range(1, n2+1):
        if s1[i-1] == s2[j-1]:
            board[i][j] = board[i-1][j-1] + 1
        else:
            board[i][j] = max(board[i-1][j], board[i][j-1])

print(max(board[n1]))
