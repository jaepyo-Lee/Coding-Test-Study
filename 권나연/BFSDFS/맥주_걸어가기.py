"""
출발 : 상근이네 집, 맥주 한 박스 (20개) 들고. 50미터에 한 병씩. (직전에 마십)
거리가 머므로 편의점에서 살 수 있음. but 박스에는 20병을 넘길 수 없음.

test 개수 t
for t:
n개
상근이네집
편의점
페스티벌 좌표.

"""
from collections import deque

def bfs():
    queue = deque()
    queue.append((home_x, home_y))

    while queue: 
        x, y = queue.popleft()

        if (festival_x - x) + (festival_y - y) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                stop_x, stop_y = convinie[i]
                if (stop_x - x) + (stop_y - y) <= 1000:
                    queue.append((stop_x, stop_y))
                    visited[i] = True
    print("sad")
    return

test = int(input())
for _ in range(test):
    n = int(input())
    home_x, home_y = map(int, input().split())
    convinie = []
    for i in range(n):
        x, y = map(int, input().split())
        convinie.append((x, y))
    festival_x, festival_y = map(int, input().split())
    visited = [False for _ in range(n+1)]
    bfs()