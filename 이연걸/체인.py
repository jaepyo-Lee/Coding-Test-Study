# n개의 체인을 찾았는데, 각 체인은 몇개의 고리로 연결되어 있다.
# 필요한 고리의 최소 개수를 구해야함...
# 체인이 고리가 될 수 있는건가?

# ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ

# ㅇ, ㅇ, ㅇ

# ㅇ ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ

# 하나의 체인을 고리로 전부 바꾸는건가?

# 2, 4, 6, 8이면 정답은 2
# ㅇ ㅇ, ㅇ ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ, ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ ㅇ


# 2, 4, 6, 8, 10 이면 정답은 3


# 고리의 최소 사용 횟수...

n = int(input())
chains = sorted(list(map(int, input().split())))

# 체인을 이루는 고리를 전부 사용해야 하는건 아니다. 다만, 체인을 고리로 분해하면 체인이
# 없어지므로 모든 체인을 연결한 셈이 된다???

# 정렬하게 되면 고리의 개수가 가장 작은 체인부터 분해해서 사용하니까 그리디로 생각할 수 있나?
# 지금 선택이 다음 선택의 영향을 주지는 않는다. -> 그리디

# (1, 3, 5, 7, 9, 11, 13, 15, 17, 19)의 체인에서 1개의 체인을 분해한다고 했을때 

# (3, 5, 7, 9, 11, 13, 15, 36)의 체인에서 3개의 체인을 분해한다고 했을때

# (5, 16, 24, 51)의 체인에서 5개의 체인을 분해한다고 했을 때

# 다 연결하고도 2개가 남는다. 그런데 이건 최소한의 고리를 사용해야 하는거니까
# 분해하지 말고 각각 옆으로 고리를 걸면 + 3


# connChain = 1
# for chain in chains:
#     if connChain + chain >= n:
#         break
#     else:
#         connChain += chain
#         n -= 1


idx = 0
answer = 0

while len(chains) != 1:

    # 남은 체인
    if chains[0] == len(chains) - 2: # 가장 앞의 체인을 분해했을 때 완벽하게 떨어지는 경우
        answer += len(chains) - 2
        break
    elif chains[0] > len(chains) - 2: # 가장 앞의 체인을 분해했을 때 고리가 남는 경우
        answer += len(chains) - 1
        break
    else: # 가장 앞의 체인을 분해했을 때 모든 체인을 연결할 수 없는 경우
        cnt = chains.pop(0)
        append_list = []
        for _ in range(cnt):
            tmp = 0
            if chains:
                tmp += chains.pop()
            if chains:
                tmp += chains.pop()
            append_list.append(tmp)
        for i in range(len(append_list)-1, -1, -1):
            chains.append(append_list[i])
        
        answer += cnt

print(answer)
