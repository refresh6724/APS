# 10개의 단어를 입력받고, 
# 문자 하나를 더 입력 받은 후 마지막으로 입력받은 문자를 포함하는 단어를 모두 찾아 사전 순으로 출력하시오. 

words = []
for i in range(10):
    words.append(input())

find = input()
flist = []
for i in words:
    if str(i).find(find) != -1:
        flist.append(i)
    
flist.sort()
print(*flist, sep="\n")