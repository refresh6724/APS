# 공백을 사이에 두고 리스트를 입력받아, 
# 역순으로 된 리스트를 구성하여 출력하는 프로그램을 작성하시오.​

list = []
for x in input().split(): list.append(x)
print(list[-1::-1])

