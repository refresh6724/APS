select animal_type, count(animal_type)
from animal_ins
where 1=1
group by animal_type
order by animal_type
