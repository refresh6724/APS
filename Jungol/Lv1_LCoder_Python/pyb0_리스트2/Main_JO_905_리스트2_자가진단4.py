# 10개의 정수를 입력받아 그 중 가장 작은 수를 출력하는 프로그램을 작성하시오.
# (입력으로 주어지는 정수는 1000을 넘지 않는다.)
list = list(map(int, input().split()))
print(min(list))