# 두 개의 정수를 입력받아 작은 수부터 큰 수까지 모든 정수의 합을 구하여 출력하는 프로그램을 작성하시오.  

# f = open("io_441.txt", "r") # VS Code에서 열려있는 편집기 위치에 따라 상대경로가 결정된다
 
# a, b = map(int, f.readline().split())
a, b = map(int, input().split())
 
if(a > b):
    tmp = a
    a = b
    b = tmp
 
sum = 0
for i in range(a, b+1):
    sum += i
print(sum)
 
# f.close()