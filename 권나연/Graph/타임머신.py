"""
edges(에지 정보 저장을 위한 ㅇ ㅔ지 리스트)
dist(최단 거리 저장)
n(노드 개수)
m(에지 개수)
dist는 충분히 큰 수로 초기화

for (에지 개수) {
    에지 리스트 배열에 에지 정보를 저장
}

벨만 포드 알고리즘 수행하기

거리 배열에 출발 노드 0으로 초기화

for(노드 개수 만큼 반복) {
    for (에지 개수 만큼 반복) {
        현재 에지 데이터 가져오기
        if (출발 노드가 무한대가 아니라, 종료 노드값 < 출발 노드값 + 에지 가중치)
            업데이트 수행 -> 종료 노드값 = 출발 노드값 + 에지 가중치
            만약 n번쨰 라운드에서도 값이 갱신한다면,
                True return해서 사이클 존재함을 알림림
    }
}

return False
"""

import sys
input = sys.stdin.readline

INF = int(1e9) #무한을 의미하는 값으로 10억을 설정

#벨만 포드 알고리즘 구현 함수 
def bf(start):
    #시작 노드에 대하여 초기화
    dist[start]=0
    #전체 n번의 라운드를 반복
    for i in range(n):
        #매 반복마다 "모든 간선"을 확인하며
        for j in range(m):
            cur = edges[j][0]
            next_node = edges[j][1]
            cost = edges[j][2]

            #현재 간선을 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if dist[cur]!=INF and dist[next_node]>dist[cur]+cost:
                dist[next_node] = dist[cur]+cost
                #n번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                if i==n-1:
                    return True
    return False
            
#노드의 개수, 간선의 개수를 입력받기
n,m = map(int,input().split())
#모든 간선에 대한 정보를 담는 리스트
edges=[]
#최단 거리 테이블을 모두 무한으로 초기화
dist = [INF]*(n+1)

#모든 간선 정보를 입력받기
for i in range(m):
    a,b,c = map(int,input().split())
    #a번 노드에서 b번 노드로 가는 비용이 c라는 의미
    edges.append([a,b,c])

#벨만 포드 알고리즘을 수행
negative_cycle = bf(1) #1번 노드가 시작 노드

if negative_cycle: #음수 순환이 존재하면
    print("-1")
else:
    for i in range(2,n+1):
        #도달할 수 없는 경우 -1출력
        if dist[i]==INF:
            print("-1")
        #도달할 수 있는 경우 거리 출력  
        else:
            print(dist[i])
