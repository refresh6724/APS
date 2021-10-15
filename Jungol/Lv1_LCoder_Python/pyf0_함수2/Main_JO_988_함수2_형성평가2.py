# 두 개의 양의 실수를 입력받아 각각의 제곱근을 구하고 
# 구해진 두 수를 포함하여 그 사이에 존재하는 정수의 개수를 출력하는 프로그램을 작성하시오.  

def between(a,b):
    if a > b:
        tmp = a
        a = b
        b = tmp
    ra = a**(1/2)
    rb = b**(1/2)
    na = int(ra)
    nb = int(rb)
    cnt = nb - na
    if float(na) == ra:
        cnt += 1
    print(cnt)

a, b = map(float, input().split())
between(a,b)