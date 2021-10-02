# 5개의 단어를 입력받은 후 
# 문자와 문자열을 한 개씩 입력받아 
# 나중에 입력받은 문자나 문자열이 포함된 단어를 모두 출력하는 프로그램을 작성하시오. 
# (입력되는 단어나 문자열의 길이는 100자 이하이고, 찾는 단어가 없으면 "none"이라고 출력한다.)

word = []
for x in range(5):
    word.append(input())
a = input().strip()
b = input().strip()
cnt = 0
for x in word:    
    if x.find(a) != -1 or x.find(b) != -1:
        print(x)
        cnt += 1
if cnt == 0:
    print("none")


