# 문자열을 입력 받아서 문자수만큼 오른쪽으로 한 바퀴 회전하여 출력하는 프로그램을 작성하시오. 입력받는 문자열의 길이는 100자 이하이다.

a = input()
b = len(a)
for x in range(b):
    print(a[b-1-x:] + a[:b-1-x])