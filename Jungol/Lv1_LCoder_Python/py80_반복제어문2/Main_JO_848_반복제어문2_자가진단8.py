# 아래와 같이 출력되는 프로그램을 작성하시오.​
# 2 3 4 5 6
# 3 4 5 6 7 
# 4 5 6 7 8
# 5 6 7 8 9
# 6 7 8 9 10

str = ""
for i in range(2, 7):
	for j in range(5):
		str += f'%d ' % (i+j)
	str += "\n"
print(str)