# "flower", "rose", "lily", "daffodil", "azalea" 
# 5개의 단어를 초기화한 후 
# 한 개의 문자를 입력받아서 
# 입력받은 문자가 두 번째나 세 번째에 포함된 단어를 모두 출력하고 
# 마지막 줄에 출력한 단어의 개수를 출력하는 프로그램을 작성하시오. 
# (해당되는 단어가 없으면 첫 줄에 0만 출력한다.)

a = ["flower", "rose", "lily", "daffodil", "azalea"]
f = input()
sum = 0
for x in a:
    if x[1] == f or x[2] == f:
        print(x)
        sum += 1

print(sum)
