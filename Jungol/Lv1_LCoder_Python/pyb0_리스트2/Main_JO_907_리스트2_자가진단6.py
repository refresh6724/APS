# 10개의 정수 리스트를 입력받아 짝수 번째 입력된 값의 합과 홀수 번째 입력된 값의 평균을 출력하는 프로그램을 작성하시오. 평균은 반올림하여 소수 첫째자리까지 출력한다.

a = list(map(int, input().split()))
even = a[1::2]
odd = a[0::2]
print(f'sum : %d' % sum(even))
print(f'avg : %.1f' % (sum(odd)/len(odd)))