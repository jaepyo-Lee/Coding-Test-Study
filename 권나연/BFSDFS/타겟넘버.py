from collections import deque

def solution(numbers, target):
    answer = 0
    queue = deque()
    queue.append([numbers[0], 0])
    # 첫번째가 마이너스인 경우도 체크 ..!
    queue.append([-1*numbers[0], 0])

    while queue:
        temp, idx = queue.popleft()
        idx += 1
        if idx < len(numbers):
            queue.append([temp+numbers[idx], idx])
            queue.append([temp-numbers[idx], idx])
        else:
            if temp == target:
                answer += 1
    return answer

"""
numbers는 2개 이상 20개 이하
각 숫자는 1 이상 50 이하
타겟 넘버는 1 이상 1000 이하 가지치기기
"""