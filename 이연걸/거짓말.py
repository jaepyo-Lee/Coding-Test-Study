answer = 0
n, m = map(int, input().split())
knows = list(map(int, input().split()))
knows.pop(0)

party_list = []
for _ in range(m):
    party = list(map(int, input().split()))
    party.pop(0)
    party_list.append(party)

for _ in range(m):
    

