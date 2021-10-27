# 공백을 포함한 100자 이하의 문자열을 두 번 입력받아 
# 길이가 작은 문자열과 긴 문자열의 순으로 출력하는 프로그램을 작성하시오.  

# f = open("io_444.txt", "r") # VS Code에서 열려있는 편집기 위치에 따라 상대경로가 결정된다
# a = f.readline()

a = input()
b = input()
if len(a) > len(b):
    print(b)
    print(a)
else:
    print(a)
    print(b) 

# f.close()