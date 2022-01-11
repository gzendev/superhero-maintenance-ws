
INSERT INTO PUBLIC.`power` (id, strength, speed, endurance, attack) 
VALUES (1, 100.00, 85.50, 87.75, 95.35);
INSERT INTO PUBLIC.`superhero` (id, nickname, fullname, gender, height, weight, occupation, creation_date, modification_date, power_id) 
VALUES (1, 'Superman', 'Clark Ken', 'Masculino', 1.85, 95.0, 'Periodista', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

INSERT INTO PUBLIC.`power` (id, strength, speed, endurance, attack) 
VALUES (2, 80.00, 90.50, 92.75, 88.35);
INSERT INTO PUBLIC.`superhero` (id, nickname, fullname, gender, height, weight, occupation, creation_date, modification_date, power_id) 
VALUES (2, 'Spider-Man', 'Peter Parker', 'Masculino', 1.70, 75.0, 'Periodista', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);

INSERT INTO PUBLIC.`power` (id, strength, speed, endurance, attack) 
VALUES (3, 100.00, 95.50, 100.00, 100.00);
INSERT INTO PUBLIC.`superhero` (id, nickname, fullname, gender, height, weight, occupation, creation_date, modification_date, power_id) 
VALUES (3, 'Hulk', 'Bruce Banner', 'Masculino', 1.65, 120.0, 'Cientifico', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2);