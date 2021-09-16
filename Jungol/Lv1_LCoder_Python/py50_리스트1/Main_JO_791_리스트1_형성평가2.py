# 두 줄에 걸쳐 숫자 두 개씩을 입력받아,
# 1 2
# 3 4
#  각 줄의 앞의 숫자를 원소로 하며,
#  원소의 개수는 뒤의 숫자만큼인 리스트를 만든다.
# 그 이후 두 리스트를 합하여 출력 예와 같이 출력하는 프로그램을 작성하시오.

a, b = input().split()
c, d = input().split()

list1 = []
for x in range(int(b)):
    list1.append(int(a))
list2 = []
for y in range(int(d)):
    list2.append(int(c))
print(list1 + list2)