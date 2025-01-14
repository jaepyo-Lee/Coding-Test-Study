N = int(input())
chain = list(map(int, input().split()))
chain.sort()
ring = 0

if (len(chain) <= 2):
    ring = 1
else:
    # 3개가 남을때까지 반복하고,
    while len(chain) > 2:
        chain[0] -= 1
        #만약에 첫번쨰 체인의 고리를 다 소진하면
        if chain[0] < 0:
            chain.pop(0)
            chain[0] -= 1
        # 가장 긴 체인들들 연결
        end1 = chain.pop()
        end2 = chain.pop()
        chain.append(end1 + end2)
        ring += 1
    #가장 적은 것 뺴고 다 연결했는데 적은 것에 chain이 남아있으면면
    if chain[0] > 0:
        ring += 1
print(ring)