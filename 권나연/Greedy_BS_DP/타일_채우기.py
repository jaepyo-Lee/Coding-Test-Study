N = int(input())

D = [0] * (N+1)
D[2] = 3

for i in range(3, (N+1)):
    if (i % 2 == 1):
        continue
    else:
        D[i] += D[i-2] * D[i-2]
        print(D[i])
        for j in range(i-4, 0, -2):
            D[i] += 2*D[j]
            print(D[i])
        D[i] += 2
    
print(D[N])

N = int(input())

D = [0] * (N + 1)

if N >= 2:
    D[0] = 1 
    D[2] = 3 

for i in range(4, N + 1, 2): 
    D[i] = D[i - 2] * D[2]  
    for j in range(i - 4, -1, -2):  
        D[i] += 2 * D[j]

print(D[N])
