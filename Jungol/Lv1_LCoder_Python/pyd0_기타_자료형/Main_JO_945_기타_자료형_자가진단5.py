# 딕셔너리를 이용하여, 
# "Pokemon"을 입력하면 "Pikachu", 
# "Digimon"을 입력하면 "Agumon", 
# "Yugioh"를 입력하면 "Black Magician", 
# 그 외의 문자열이 입력되면 "I don't know"를 출력하는 프로그램을 작성하시오.

dict = {
    'Pokemon' : 'Pikachu'
    ,'Digimon' : 'Agumon'
    ,'Yugioh' : 'Black Magician'
}
print(dict.get(input(), "I don't know"))