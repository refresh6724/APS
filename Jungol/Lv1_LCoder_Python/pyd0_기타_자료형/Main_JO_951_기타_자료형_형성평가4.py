# 두 줄에 여러 개의 정수를 입력 받아,
# 첫 번째 줄에는 존재하면서 두 번째 줄에는 존재하지 않는 숫자를 
# 오름차순(크기가 작은 수부터 큰 수의 순서)으로 출력하는 프로그램을 작성하라. 
# (중복된 원소는 하나만 출력한다.) 

a = set(input().split())
b = set(input().split())
c = a.difference(b)
d = sorted(list(map(int, c)))
print(*d, sep=" ")