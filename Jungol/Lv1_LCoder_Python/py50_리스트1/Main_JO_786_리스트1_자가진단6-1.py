# 원소 6개짜리 리스트를 입력받아 생성한 후, 
# 인덱스를 입력 받아 입력받은 인덱스부터
# 맨 마지막까지의 부분 리스트를 출력하는 프로그램을 작성하라.​

list = []
for x in range(6):
    print("Element?", end = ' ')
    list.append(input())

print("Index?", end = ' ')
a = int(input())
print(list[a:])

