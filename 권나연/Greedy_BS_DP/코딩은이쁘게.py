N = int(input())
before = list(map(int, input().split))
after = list(map(int, input().split))
diff = []
for i in range(N):
    diff.append(after[i] - before[i])

for i in range(N):
    if diff[i] == 0:
        continue
    else:
        for j in range(i):
            
