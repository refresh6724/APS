# 공백을 포함한 문자열을 입력받아 문자열 '(space)'를 기준으로 분리하여 역순으로 출력하는 프로그램을 작성하시오.​

a = input()
b = '(space)'
a = a.replace(b, '\n')
a = a.split()
a.reverse()
for x in a:
    print(x)