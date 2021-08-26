# mysql
select animal_id, name
from animal_ins
where intake_condition != "aged"
order by animal_id asc;

# oracle
SELECT ANIMAL_ID,NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION <> ('Aged') # 따옴표, 쌍따옴표에 민감 ORA-00904: "aged": invalid identifier
order by ANIMAL_ID asc;