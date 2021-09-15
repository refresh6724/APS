# 1부터 15까지의 정수가 들어있는 리스트를 생성하고,
# 정수 하나를 입력받아 그 배수들만으로 구성된 부분 리스트를 출력하는 프로그램을 작성하시오.

list = []
for x in range(1,16): list.append(x)
a = int(input())
print(list[a-1::a])

