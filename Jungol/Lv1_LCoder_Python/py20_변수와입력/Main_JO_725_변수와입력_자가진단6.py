print("Number 1?")
Number1 = int(input())
print("Number 2?")
Number2 = int(input())
mul = Number1*Number2
div = float(Number1)/Number2
print("%d * %d = %d" % (Number1, Number2, Number1 * Number2))
# 왜 다를까
# print("%d / %d = %f" % (Number1, Number2, Number1 / Number2)) 
# 79 / 74 = 1.067568
print(f"{Number1} / {Number2} = {div}") 
# 79 / 74 = 1.0675675675675675
