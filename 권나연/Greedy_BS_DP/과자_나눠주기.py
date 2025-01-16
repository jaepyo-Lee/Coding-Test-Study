M, N = map(int, input().split())

snacks = list(map(int, input().split(' ')))

start = 1
end = max(snacks)
result = 0

while start <= end:
    mid = (start + end) //2

    count = 0

    for i in snacks:
        if i >= mid:
            count += i // mid
        
    if count >= M:
        result = mid
        start = mid +1
    else:
        end = mid - 1

print(result)

