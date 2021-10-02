# 6개의 문자리스트를 ['J', 'U', 'N', 'G', 'O', 'L']이라고 초기화 한 후,
# 문자 한 개를 입력받아 리스트에서의 위치를 출력하는 프로그램을 작성하시오. 
# 첫 번째 위치는 0번이며 배열에 없는 문자가 입력되면 "none"이라는 메시지를 출력한다.

word = list("JUNGOL")
wordMap = {v:k for k,v in enumerate(word)}
print(wordMap.get(input(), "none"))

# aa = ['AA', 'BB', 'CC']

# bb = {k:v for k,v in enumerate(aa)} #// {0: 'AA', 1: 'BB', 2: 'CC'}
# bb.get(2)    #// 결과: 'CC'

# cc = {v:k for k,v in enumerate(aa)} #// {'AA': 0, 'BB': 1, 'CC': 2}
# cc.get('CC') #// 결과: 2