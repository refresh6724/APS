# 문자열 두 개를 입력받아, 각 문자열 뒤에 보이지 않는 공백을 제거한 후, 두 문자열을 붙여서 출력하는 프로그램을 작성하라.​

a = []
for x in range(3):
    a.append(input())

for x in a:
    xx = x.split()
    print(f'{xx[0]} sounds {xx[1]}.')