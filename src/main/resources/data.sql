INSERT INTO public.persons
(id, age, birth_date, count_view, full_name, gender, height, id_number, weight)
VALUES(1, 26, '2020-09-03 19:00:00', 0, 'Albert Medina', 1, 1, 8816, 1);

INSERT INTO public.planet
(id, count_view, "name")
VALUES(1, 0, 'Tierra');

INSERT INTO public.planet_person_reg
(id, id_person_fk, id_planet_fk)
VALUES(1, 1, 1);



