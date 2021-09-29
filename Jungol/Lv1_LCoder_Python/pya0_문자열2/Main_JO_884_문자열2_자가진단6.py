# 문자열 'Pennsylvania'에 입력 받은 문자열이 포함되면 True, 아니면 False를 출력하는 프로그램을 작성하시오.​

origin = 'Pennsylvania'
a = input().strip()
if origin.find(a) != -1:
    print("True")
else:
    print("False")