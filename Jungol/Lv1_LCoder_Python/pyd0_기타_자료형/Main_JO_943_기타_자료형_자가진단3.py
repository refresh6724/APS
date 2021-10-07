# 인터넷 게임 계정의 수를 입력 받은 후, 각 계정의 아이디, 승률, 계급을 입력 받아, 계급이 'Bronze'가
# 아니면서 승률이 60.0 이상이거나, 계급이 'Platinum' 인 아이디를 입력 받은 순서대로 출력 예와 같은
# 형식으로 "[Gosu]"를 붙여 출력하는 프로그램을 작성하시오 

n = int(input())
for i in range(n):
    a, b, c = input().split()
    bb = float(b)
    if bb >= 60.0 and c != "Bronze":
        print(f'[Gosu] %s' % a)
    elif c == "Platinum":
        print(f'[Gosu] %s' % a)