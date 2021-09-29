# 한 개의 문자열을 입력받아 문자가 모두 대문자이면 'U', 모두 소문자이면 'L',
#  모두 숫자이면 'D', 어느 것에도 해당하지 않으면 'X'라고 출력하고,
# 소문자가 있으면 모두 대문자로 변환한 후 문자열을 출력하는 프로그램을 작성하시오.

a = input()
if a.isupper():
    print('U')
elif a.islower():
    print('L')
elif a.isnumeric():
    print('D')
else:
    print('X')

# if a.isalnum() and a != a.upper():
# 문제와 달리 조건 무관 출력
print(a.upper())