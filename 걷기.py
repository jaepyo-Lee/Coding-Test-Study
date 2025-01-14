def min_time():
    diagonal = min(x, y)
    left_straight = max(x, y) - diagonal
    if 2*w < s:
        return (x+y)*w
    else:
        return (diagonal*s + left_straight*w)
x, y, w, s = map(int, input().split())
print(min_time())
