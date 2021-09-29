# 두 개의 문자열 A와 B, 한 개의 정수 n을 입력받아서 A에 B를 연결하여 새로운 A를 만들고,
#  A에서 n개의 문자를 B의 앞부분에 복사한 후  A와 B를 출력하는 프로그램을 작성하시오.
# (A와 B의 문자열의 길이는 50자 이하이고, n은 A와 B의 문자열 길이의 합보다 작다.) 

a, b, nn = input().split()
n = int(nn)
a = a + b
b = a[:n]+ b[n:]
print(a)
print(b)