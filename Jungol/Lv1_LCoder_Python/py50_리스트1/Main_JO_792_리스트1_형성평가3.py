# 4 마리의 동물에 대한 정보를 입력 받아,
# 동물의 색상과 동물 이름으로 이루어진 리스트를 구성하여 
# 각각 출력하는 프로그램을 작성하시오. 
# 각 색상과 동물 이름은 띄어쓰기로 구분되어 있다.

Color = []
Animal = []
for x in range(4):
    print("Input?", end=' ')
    a, b = input().split()
    Color.append(a)
    Animal.append(b)

print("Color:", Color)
print("Animal:", Animal)