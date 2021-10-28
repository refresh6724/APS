# 공백을 포함한 한 문장을 입력받아서 
# 전체 길이와 가장 긴 단어를 출력하시오. 
# 단 최대 100자 이내이고, 
# 길이가 가장 긴 단어가 여러 개인 경우 
# 공백으로 분리하여 한 줄에 순서대로 모두 출력한다 

a = input()
print(len(a))
list = a.split()
max = 0
pout = []
for l in list:
    if len(l) > max:
        max = len(l)
        pout.clear()
        pout.append(l)
    elif len(l) == max:
        pout.append(l)

print(*pout, sep=" ")
