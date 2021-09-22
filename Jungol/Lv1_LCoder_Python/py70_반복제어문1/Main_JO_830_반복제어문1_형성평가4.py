# 0이 입력될 때까지 정수를 계속 입력받아
# 3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.​

cnt = 0

while True:
    a = int(input())
    if a==0:
        break
    if a%3!=0 and a%5!=0:
        cnt+=1

print(cnt)