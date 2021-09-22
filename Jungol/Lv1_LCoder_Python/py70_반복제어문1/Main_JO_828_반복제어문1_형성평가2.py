# 정수를 입력받다가 0이 입력되면 
# 그 때까지 입력받은 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.​

even = 0
odd = 0

while True:
    a = int(input())
    if a==0:
        break;
    if a%2==0:
        even+=1
    else:
        odd+=1

print("odd :", odd)
print("even :", even)