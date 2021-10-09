# 야구선수들의 파울 기록을 입력 받아, 
# 파울을 가장 적게 한 선수를 모두 출력하고, 
# 최소 파울 횟수를 마지막에 출력하는 프로그램을 작성하시오. 

d = {}
for i in input().split():
    d[i] = d.get(i, 0) + 1
foul = min(d.values())
for k, v in d.items():
    if v == foul:
        print(k)
print(foul)