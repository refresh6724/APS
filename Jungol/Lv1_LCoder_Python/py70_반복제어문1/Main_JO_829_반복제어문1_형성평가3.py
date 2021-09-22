# 0부터 100까지의 점수를 계속 입력받다가
# 범위를 벗어나는 수가 입력되면 
# 그 이전까지 입력된 자료 의 합계와 평균을 출력하는 프로그램을 작성하시오. 
# (평균은 반올림하여 소수 첫째자리까지 출력한다.)​

sum = 0
cnt = 0
while True:
    a = int(input())
    if a >= 0 and a <= 100:
        sum += a
        cnt += 1
    else:
        break;
print("sum :", sum)
print(f'avg : %.1f' % (sum/cnt))
