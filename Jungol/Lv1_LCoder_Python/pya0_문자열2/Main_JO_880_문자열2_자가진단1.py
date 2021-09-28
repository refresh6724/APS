# ​문자열을 하나 입력받아, 문자 사이사이에 쉼표(,)를 넣어 출력하는 프로그램을 작성하시오.
# Jungbo Olympiad
# J,u,n,g,b,o, ,O,l,y,m,p,i,a,d
a = list(input()) 
# print(a) 
# ['J', 'u', 'n', 'g', 'b', 'o', ' ', 'O', 'l', 'y', 'm', 'p', 'i', 'a', 'd']
pp = ''
for x in a:
    pp += x + ','
print(pp[:-1])