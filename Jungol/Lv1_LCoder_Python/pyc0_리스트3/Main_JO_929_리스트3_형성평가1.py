# 리스트 내포를 이용하여 1번부터 입력받은 숫자까지의 숫자에 "No."를 붙인 문자열을 원소로 하는 리스트를 만들어 출력하시오.

n = int(input())
number = [f'No.%d' % x for x in range(1, n+1)]
print(number)
