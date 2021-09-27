# 정수 n을 입력 받아, 알파벳 소문자 중 n의 배수 번째 알파벳만 출력하는 프로그램을 작성하시오.​
# 2 bdfhjlnprtvxz

n = int(input())
start = ord('a')-1
pp = ''
for x in range(n,26+1,n):
    pp += chr(start+x)
print(pp)