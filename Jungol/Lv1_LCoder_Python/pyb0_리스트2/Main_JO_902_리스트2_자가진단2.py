# 5개의 단어를 입력받아 모든 단어를 입력받은 역순으로 출력하는 프로그램을 작성하시오.​

word = []
for x in range(5):
	word.append(input())

word.reverse()
for x in word:
	print(x)