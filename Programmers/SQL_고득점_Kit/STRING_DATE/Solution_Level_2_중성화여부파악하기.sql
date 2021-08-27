# mysql
select ANIMAL_ID, NAME,
    CASE 
    WHEN SEX_UPON_INTAKE LIKE 'Neutered%'
    OR SEX_UPON_INTAKE LIKE 'Spayed%'
    THEN 'O' ELSE 'X'
    END '중성화' -- (쌍)따옴표 사용 가능
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

# oracle 1
select ANIMAL_ID, NAME,
    CASE 
    WHEN SEX_UPON_INTAKE LIKE 'Neutered%'
    OR SEX_UPON_INTAKE LIKE 'Spayed%'
    THEN 'O' ELSE 'X'
    END 중성화 -- (쌍)따옴표 사용 불가
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;

# oracle 2
SELECT ANIMAL_ID,
       NAME,
       CASE WHEN REGEXP_LIKE(SEX_UPON_INTAKE, 'Neutered|Spayed') 
       THEN 'O'
       ELSE 'X'
       END AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
