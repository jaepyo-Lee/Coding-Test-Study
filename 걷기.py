def min_time():
    if 2*w < s:
        return (x+y)*w
    else:
        if ((x+y) % 2 == 0) :
            return (s * min(x, y)) + (min(w, s) * abs(x-y))
        else:
            return (s * min(x, y)) + (min(w, s) * (abs(x-y)-1)) + w
x, y, w, s = map(int, input().split())
print(min_time())
