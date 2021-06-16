use encore;

select e.employee_id, e.last_name, e.manager_id, m.employee_id, m.last_name
from employees e join employees m
on e.manager_id = m.employee_id
where e.employee_id= 175;