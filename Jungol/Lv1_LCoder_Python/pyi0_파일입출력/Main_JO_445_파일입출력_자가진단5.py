# 100 이하의 정수 N을 입력받은 후 
# 공백이 포함된 N행의 문장을 입력받아서 
# 역순으로 출력하는 프로그램을 작성하시오.
# 각 문장의 길이는 100이하이다.​

# f = open("io_445.txt", "r") # VS Code에서 열려있는 편집기 위치에 따라 상대경로가 결정된다
# a = f.readline() 

n = int(input())
lines = []
for i in range(n):
    lines.append(input())

lines.reverse()
for i in lines:
    print(i)
     
# f.close()