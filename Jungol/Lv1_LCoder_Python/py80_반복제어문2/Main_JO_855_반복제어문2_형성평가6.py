# 두 개의 정수를 입력받아 
# 작은 수부터 큰 수까지 
# 3의 배수이거나 5의 배수인 수들의 합과 평균을 출력하는 프로그램을 작성하시오. 
# (평균은 반올림하여 소수 첫째자리까지 출력한다.)​

aa, bb = input().split()
a = int(aa)
b = int(bb)
if a > b:
    tmp = a;
    a = b;
    b = tmp;

list = []
for x in range(a, b+1):
    if x%3==0 or x%5==0:
        list.append(x)

print(f'sum : %d' % sum(list))
print(f'avg : %.1f' % (sum(list)/len(list))) 

