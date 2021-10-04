# 반복문을 이용하여 리스트에 아래와 같이 저장한 후 출력하는 프로그램을 작성하시오 

# 1 1 1 1 1
# 1 2 3 4 5
# 1 3 6 10 15
# 1 4 10 20 35
# 1 5 15 35 70

# list = [[1] * 5] * 5 
# # 이 경우 1 행이 연결되어 5번 복사되고 문제가 발생한다
# print(list)
# for row in range(1,5):
#     for col in range(1,5):          
#         list[row][col] = list[row-1][col] + list[row][col-1]
#     print(list)  

list = [[1] * 5 for i in range(5)]
print(*list[0], sep=" ")
for row in range(1,5):
    for col in range(1,5):          
        list[row][col] = list[row-1][col] + list[row][col-1]
    print(*list[row], sep=" ")
