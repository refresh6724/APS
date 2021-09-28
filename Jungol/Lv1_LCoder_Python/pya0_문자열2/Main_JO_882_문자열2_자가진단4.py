# 세 문자열을 입력 받아서, 세 문자열이 사전순으로 정렬되어 있으면 'YES', 아니면 'NO'를 출력하는 프로그램을 작성하라.​

a = input()
b = input()
c = input()
if a > b:
    print("NO")
elif b > c:
    print("NO")
elif a > c:
    print("NO")
else:
    print("YES")