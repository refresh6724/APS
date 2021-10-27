# 0을 제외한 정수를 입력받아 
# 3의 배수이면서 5의 배수인 정수를 입력된 순서대로 모두 출력하고 
# 다음 줄에 그 개수를 출력하시오. 
# (한 개도 없을 경우에는 "0"만 출력한다. 입력되는 정수의 최대개수는 1000개이다.) 

list = []
for i in map(int, input().split()):
    if i != 0 and i%3 == 0 and i%5 == 0:
        list.append(i)

if len(list) != 0:
    print(*list, sep=" ")
print(len(list))