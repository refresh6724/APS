# 20개 이하의 문자로 이루어진
# 10개의 단어와 한 개의 문자를 입력받아서 
# 마지막으로 입력받은 문자로 끝나는 단어를 모두 출력하는 프로그램을 작성하시오.​

word = []
for x in range(10):
    word.append(input())

end = input()
for x in word:   
    if x.endswith(end):
        print(x)
