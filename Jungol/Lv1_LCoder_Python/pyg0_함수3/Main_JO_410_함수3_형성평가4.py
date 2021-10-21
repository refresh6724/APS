# 첫 번째는 1, 두 번째는 2, 세 번째 이후는 앞의 두 수의 곱을 100으로 나눈 나머지로 이루어진 수열이 있다. 
# 100 이하의 자연수 N을 입력받아 재귀함수를 이용하여 N번째 값을 출력하는 프로그램을 작성하시오.  

class Recursive():
    def __init__(self):
        self.prev = 1
        self.curr = 2

    def __iter__(self):
        return iter(self.curr)

    def __next__(self):
        next = (self.curr * self.prev)%100
        self.prev = self.curr
        self.curr = next
        return next

        

a = Recursive()
n = int(input())
if(n<3):
    print(n)
else:
    for i in range(n-3):
        next(a)
    print(next(a))
    
