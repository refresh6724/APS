# mysql
select ANIMAL_ID, NAME
from ANIMAL_INS
where ANIMAL_TYPE = 'Dog'
and NAME like '%el%'
order by NAME;

# oracle
select ANIMAL_ID, NAME
from ANIMAL_INS
where ANIMAL_TYPE = 'Dog'
and UPPER(NAME) like '%EL%'
order by NAME;
