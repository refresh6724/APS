# 나이를 입력받아 20살 이상이면"An adult."라고 출력하고 '
# 그렇지 않으면 몇 년후에 성인이 되는지"○ years"라는 메시지를 출력하는 프로그램을 작성하시오.​

old = int(input())
if old >= 20:
    print("An adult.")
else:
    print(f'{20-old} years')
