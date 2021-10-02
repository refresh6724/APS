# 공백으로 구분하여 입력된 
# 세자리 이하의 정수를 
# 리스트로 받아서 입력된 최대값과 최소값을 출력하는 프로그램을 작성하시오.

a = list(map(int, input().split()))
print(f'max : %d' % max(a))
print(f'min : %d' % min(a))