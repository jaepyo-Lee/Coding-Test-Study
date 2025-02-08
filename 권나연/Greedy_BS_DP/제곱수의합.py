"""
int(n ** 0.5) * 2 == n
"""
N = int(input())
D = [x for x in range(N+1)]

for i in range(1, (N+1)):
    for j in range(1, i):
        if j*j > i:
            break
        if D[i] > D[i - j*j] + 1:
            D[i] = D[i - j*j] + 1

print(D[N])
