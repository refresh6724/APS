# "몸무게 + 100 - 키"를 비만수치 공식이라고 하자.

height = int(input())
weight = int(input())
bmi = weight + 100 - height
print(bmi)
if bmi > 0:
    print("Obesity")