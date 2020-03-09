
--- FISH_FAMILY ---

INSERT INTO FAMILY (id, name,water_type) VALUES (1,'Cichlidae',1);
INSERT INTO FAMILY (id, name,water_type) VALUES (2,'Cyprinidae',1);
INSERT INTO FAMILY (id, name,water_type) VALUES (3,'Characidae',1);
INSERT INTO FAMILY (id, name,water_type) VALUES (4,'Pomacentridae',2);
INSERT INTO FAMILY (id, name,water_type) VALUES (5,'Sphyrnidae',1);

--- FISH ---

INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (1,'Discus',24,25,1);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (2,'Scalaire',24,18,1);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (3,'Pelmato',25,8,1);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (4,'Neolamprologus',25,6,1);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (5,'Brème commune',15,2,2);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (6,'Spirlin',15,2,2);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (7,'Barbus raye',23,3.4,2);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (8,'Suceur de pierres ',21,1.90,2);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (9,'Carpe Koi',19,14.9,2);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (10,'Neon bleu',24,0.4,3);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (11,'Cardinalis',24,0.4,3);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (12,'Tetra argente',24,0.5,3);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (13,'Nez rouge',24,0.4,3);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (14,'Tetra joyau',24,2.6,3);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (15,'Fantome rouge',24,4.2,3);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (16,'Le demoiselle noire',24,18.6,4);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (17,'Poisson clown',22,8.2,4);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (18,'Sergent major',21,13,4);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (19,'Demoiselle bicolore',19,18,4);
INSERT INTO FISH (id, name, temperature, price, family_fk) VALUES (20,'Requin marteau',18,30000,5);
