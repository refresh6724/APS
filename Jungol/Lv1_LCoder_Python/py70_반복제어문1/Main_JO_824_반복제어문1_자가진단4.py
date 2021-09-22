# 정수를 계속 입력받다가 100 이상의 수가 입력이 되면 
# 마지막 입력된 수를 포함하여 합계와 평균을 출력하는 프로그램을 작성하시오.
# (평균은 반올림하여 소수 첫째자리까지 출력한다.)​

sum = 0
cnt = 0
while True:
    a = int(input())
    sum += a
    cnt += 1
    if a >= 100:
        break;

print(sum)
print(f'%.1f' % (sum/cnt))