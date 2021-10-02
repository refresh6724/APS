# 단어를 입력받다가 "0"을 입력받으면 입력을 종료하고 
# 그 때까지 입력받은 단어의 개수와 "mo"가 들어간 단어를 모두 출력하는 프로그램을 작성하시오.

cnt = 0
mo = []
while(True):
    word = input()
    if word == "0":
        break;
    elif word.find("mo") != -1:
        mo.append(word)
    cnt += 1
print(cnt)
print(*mo, sep="\n")
