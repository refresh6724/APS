# 세 개의 단어를 입력받아 아스키코드 순으로 가장 작은 단어를 출력하는 프로그램을 작성하시오.​

a, b, c = input().split()
min = ''
if a < b:
    min = a
else:
    min = b

if min < c:
    print(min)
else:
    print(c)
