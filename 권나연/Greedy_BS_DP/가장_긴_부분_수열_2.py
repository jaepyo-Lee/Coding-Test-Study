# 자꾸 시간 초과남!

N = int(input())
sequence = list(map(int,input().split()))
D = [1] * N
for i in range(1, N):
    for j in range(i):
        if sequence[i] > sequence[j]:
            D[i] = max(D[i], D[j] + 1)
print(max(D))
