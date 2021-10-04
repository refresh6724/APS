# 리스트의 크기와 정수를 입력 받아 다음 규칙을 만족하는 리스트를 리스트 내포를 이용하여 만들어 출력하시오.
# 규칙: 인덱스가 입력받은 정수의 배수이면 True, 아니면 False

aa, bb = input().split()
a = int(aa)
b = int(bb)
number = [True if i%b==0 else False for i in range(a)]
print(number)