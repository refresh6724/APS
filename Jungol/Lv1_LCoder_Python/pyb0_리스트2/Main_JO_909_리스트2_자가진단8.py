# 20자 미만인 5개의 문자열을 입력받아 
# 문자열 크기(아스키코드) 역순으로 정렬하여 출력하는 프로그램을 작성하시오.

a = []
for x in range(5):
    a.append(input())
a.sort(reverse=True) 
for x in a:
    print(x)
