# 정수를 입력받아 입력받은 정수만큼 반복하면서, 
# 각 줄에 나라의 이름과 그 나라의 수도를 공백을 사이에 두고 입력받는다. 
# 그 후에, 나라의 이름을 입력받아 그 나라의 수도를 출력하는 프로그램을 작성하라. 
# 만약 나라가 입력된 적이 없으면, Unknown Country을 출력한다. 

dict = {}
n = int(input())
for i in range(n):
    a, b = input().split()
    dict[a] = b
print(dict.get(input(), "Unknown Country"))