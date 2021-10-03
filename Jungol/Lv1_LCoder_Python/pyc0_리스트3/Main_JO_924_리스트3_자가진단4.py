# 100 이하의 자연수를 입력받아 
# 첫 번째 항은 100으로 두 번째 항은 입력받은 수로 초기화하고
# 다음 항부터는 전전항에서 전항을 뺀 수로 채워나가는 수열을 작성하여
# 그 수가 음수가 나올 때까지 출력하는 프로그램을 작성하시오. 


a = 100
b = int(input())
list = [a, b]
c = a - b
while c >= 0:
    list.append(c)
    a = b
    b = c
    c = a - b
list.append(c)
print(*list, sep=" ")
