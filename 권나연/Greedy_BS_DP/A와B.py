S = list(input().strip())
T = list(input().strip())
possible = False

while (len(T) > 0):
    if T[-1] == 'A':
        T = T[:-1]
    else:
        T = T[:-1]
        T = T[::-1]
    if S == T:
        possible = True
        break

print(1 if possible else 0)
