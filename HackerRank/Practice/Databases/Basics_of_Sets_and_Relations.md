# Set A and B

Set A = {1,2,3,4,5,6}
Set B = {2,3,4,5,6,7,8}

## 1

Q : A ∪ B elements?
A : 8

## 2

Q : A ∩ B elements?
A : 5

## 3 

Q : A - B elements?
A : 1

## 4

Q : A X B elements?
A : 42


# Student

Student Name    Number  Sex  
Ben             3412    M  
Dan             1234    M  
Nel             2341    F  

## 5

Relational Algebra : σ(Number<3000)(Student)
ANSI SQL : SELECT COUNT(*) FROM Student WHERE Number < 3000
A : 2

# Student

Name                Number  Sex  
Nina                3412    F 
Mike                1234    M  
Nelson              2341    F  

## 6

Relational Algebra : π(Name, Number)(Student)
ANSI SQL : SELECT DISTINCT(Name, Number) FROM Student
row 3, column 1(name, number)
A : 2 (column count)

# Teaching Assistants

Subject     ID
Physics     3412
Chemistry   1111
Mathematics 2341  

## 7 

Relational Algebra : Student ▷◁ (Number=ID) Teaching Assistants
ANSI SQL : SELECT COUNT(*) FROM Student S, Teaching_Assistants T ON (S.Number = T.ID)
A : 2


