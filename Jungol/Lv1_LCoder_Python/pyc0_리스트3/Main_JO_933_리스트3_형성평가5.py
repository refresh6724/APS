# 10 미만의 자연수 두 개를 입력받아서 첫 번째 항과 두 번째 항을 입력받은 수로 초기화시킨 후 
# 세 번째 항부터는 전전항과 전항의 합을 구하여 그 합의 1의 자리로 채워서 차례로 10개를 출력하는
# 프로그램을 작성하시오. 

aa, bb = input().split()
num = []
a = int(aa)
num.append(a)
b = int(bb)
num.append(b)
c = (a+b)%10
num.append(c)
for x in range(7):
    a = b
    b = c
    c = (a+b)%10
    num.append(c)
# print(*num, sep=" ")
print(num)