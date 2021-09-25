# 한 줄에 두 문자를 입력받아서, 
# 앞에 문자의 아스키코드부터 
# 뒤의 문자의 아스키코드까지 
# 순서대로 순회하면서 모든 문자를 출력하는 프로그램을 작성하시오. 
# 앞 문자의 아스키코드가 뒤 문자의 아스키코드보다 클 수도 있음에 주의하시오.​

aa, bb = input().split()
a = ord(aa)
b = ord(bb)
step = 1
if a > b:
    step = -1

for x in range(a, b + step, step) :
    print(chr(x), end=" ")
