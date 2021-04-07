# 보호 시작일보다 입양일이 빠른 동물 아이디와 이름
select o.animal_id, o.name
from animal_ins i
join animal_outs o
on (i.animal_id = o.animal_id)
where i.datetime > o.datetime
order by i.datetime