# 정수 n을 입력받아, 1부터 n까지의 제곱수를 리스트로 만들어 출력하는 프로그램을 작성하라.
# 리스트 내포를 이용한다.

n = int(input())
print(list(i**2 for i in range(1,n+1)))
