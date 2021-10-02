# 100 이하의 정수를 한 줄로 입력받아
# 입력된 정수 중 5의 배수의 개수와 합계, 평균을 출력하는 프로그램을 작성하시오.
# (평균은 소수점 한자리까지 반올림)

a = list(map(int, input().split()))
five = list(filter(lambda x : x%5==0, a))
print(f'Multiples of 5 : %d' % len(five))
print(f'sum : %d' % sum(five))
print(f'avg : %.1f' % (sum(five)/len(five)))