# 원소 6개짜리 리스트를 입력받아 생성한 후, 
# 홀수 번째 원소가 앞으로 오고 짝수 번째 원소가 뒤로 오도록 리스트를 재구성하여 출력하는 프로그램을 작성하시오.​

list = []
for x in range(6):
    print("Element?", end = ' ')
    list.append(input())

print(list[0::2]+list[1::2])

