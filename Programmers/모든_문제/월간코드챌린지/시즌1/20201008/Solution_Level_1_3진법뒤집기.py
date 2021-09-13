def solution(n):
    a = ''
    while n>0:
        a += str(n%3)
        n = n//3
    
    answer = 0
    cnt = 1
    for b in range(len(a),0,-1):
        answer += (int)(a[b-1]) * cnt
        cnt *= 3        
    return answer

def solution1(n):   
    a = ''
    while n>0:
        a += str(n%3)
        n = n//3       
    return int(a, 3)
    
def solution2(n):
    from string import digits
    ls = list(digits)
    def f(n):        
        return ls[n] if n < 3 else f(n//3) + ls[n%3]        
    return int(str(f(n))[::-1], 3)

if __name__ == "__main__":
    n = 45
    result = 7
    print(result, solution(n), solution1(n), solution2(n))

    n, result = 125, 229
    print(result, solution(n), solution1(n), solution2(n))
    