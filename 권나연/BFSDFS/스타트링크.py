from collections import deque

def bfs(start):
    queue = deque()
    queue.append(start)

    matrix[start] = 0

    while queue:
        location = queue.popleft()

        if location == g:
            return matrix[location]

        for i in range(2):
            new_location = location + dx[i]
            if (0<new_location<=f) and (matrix[new_location] == -1):
                matrix[new_location] = matrix[location] + 1
                queue.append(new_location)
    return "use the stairs"      

f, s, g, u, d = map(int, input().split())
matrix = [-1] * (f+1)
dx = [u, -d]

print(bfs(s))


