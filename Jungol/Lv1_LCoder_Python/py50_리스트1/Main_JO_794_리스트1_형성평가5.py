# 한 줄에 리스트를 입력 받아, 
# 3의 배수(3, 6, 9...)번째 원소들만 골라서 리스트로 출력하는 프로그램을 작성하라.​

list = []
for x in input().split():
    list.append(x)
print(list[2::3])