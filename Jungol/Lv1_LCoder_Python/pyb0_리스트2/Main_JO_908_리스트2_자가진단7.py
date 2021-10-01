# 10개의 정수를 입력받아 내림차순으로 정렬하여 출력하시오.

a = list(map(int, input().split()))
a.sort(reverse=True)
# 2가지 방법
print(*a, sep=" ")
# print(" ".join(str(x) for x in a))