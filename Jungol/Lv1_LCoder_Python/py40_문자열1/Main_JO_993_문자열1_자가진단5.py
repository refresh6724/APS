# 이름, 번호, 중간고사 평균을 입력받아 다음 서식에 맞게 출력하는 프로그램을 작성하시오.
# 'I am □(IDNo. □). I got □ in my midterm exam.‘

name = input()
num = input()
avg = float(input())
# IDNo 가 아니라 IdNo 가 정답이었다
print(f'I am {name}(IdNo. {num}). I got {avg:f} in my midterm exam.')

