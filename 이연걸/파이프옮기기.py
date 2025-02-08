from collections import deque
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]


hor_dir = [(0, 1, 1, 1), (0, 1, 0, 1)] # 0
ver_dir = [(1, 0, 1, 1), (1, 0, 1, 0)] # 1
dia_dir = [(1, 1, 1, 1), (1, 1, 0, 1), (1, 1, 1, 0)] # 2

answer = 0
cur = [[0, 0, 0, 1], 0]
while True:
    print(cur)
    stuck = True
    if cur[0][2] == n-1 and cur[0][3] == n-1:
        break
    
    if cur[1] == 0:
        for x1, y1, x2, y2 in hor_dir:
            nx1, ny1, nx2, ny2 = x1+cur[0][0], y1+cur[0][1], x2+cur[0][2], y2+cur[0][3]
            if 0 <= nx1 < n and 0 <= ny1 < n and 0 <= nx2 < n and 0 <= ny2 < n:
                if board[nx1][ny1] != 1 and board[nx2][ny2] != 1:
                    if hor_dir[0][2] == 1:
                        if board[nx2-1][ny2] == 1 or board[nx2][ny2-1] == 1:
                            continue
                        cur[1] = 2
                    cur[0][0] += x1
                    cur[0][1] += y1
                    cur[0][2] += x2
                    cur[0][3] += y2
                    stuck = False
                    break
    elif cur[1] == 1:
        for x1, y1, x2, y2 in ver_dir:
            nx1, ny1, nx2, ny2 = x1+cur[0][0], y1+cur[0][1], x2+cur[0][2], y2+cur[0][3]
            if 0 <= nx1 < n and 0 <= ny1 < n and 0 <= nx2 < n and 0 <= ny2 < n:
                if board[nx1][ny1] != 1 and board[nx2][ny2] != 1:
                    if ver_dir[0][3] == 1:
                        if board[nx2-1][ny2] == 1 or board[nx2][ny2-1] == 1:
                            continue
                        cur[1] = 2
                    cur[0][0] += x1
                    cur[0][1] += y1
                    cur[0][2] += x2
                    cur[0][3] += y2
                    stuck = False
                    break
    else:
        for x1, y1, x2, y2 in dia_dir:
            nx1, ny1, nx2, ny2 = x1+cur[0][0], y1+cur[0][1], x2+cur[0][2], y2+cur[0][3]
            if 0 <= nx1 < n and 0 <= ny1 < n and 0 <= nx2 < n and 0 <= ny2 < n:
                if board[nx1][ny1] != 1 and board[nx2][ny2] != 1:
                    if dia_dir[0][2] == 0:
                        cur[1] = 0
                    elif dia_dir[0][3] == 0:
                        cur[1] = 1
                    else:
                        if board[nx2-1][ny2] == 1 or board[nx2][ny2-1] == 1:
                            continue
                    cur[0][0] += x1
                    cur[0][1] += y1
                    cur[0][2] += x2
                    cur[0][3] += y2
                    stuck = False
                    break
    if stuck:
        answer = 0
        break
    answer += 1


print(answer)
