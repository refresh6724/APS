# 보호소에 들어올 때는 중성화되지 않았지만, 나갈 때는 중성화된 동물
select i.animal_id, i.animal_type, i.name
from animal_ins i
join animal_outs o
on (i.animal_id = o.animal_id)
where i.sex_upon_intake like 'Intact%' 
	and o.sex_upon_outcome not like 'Intact%'
order by i.animal_id
