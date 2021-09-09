# 두 학생의 이름과 나이를 입력 예와 같이 입력 받은 후에, 출력 예와 같은 형식으로 두 학생의 나이의 합을 출력하는 프로그램을 작성하시오.

a = input()
aa = a.split()
b = input()
bb = b.split()
print(f'{aa[0]} age + {bb[0]} age = {int(aa[1]) + int(bb[1])}')
