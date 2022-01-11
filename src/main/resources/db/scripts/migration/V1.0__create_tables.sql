CREATE TABLE IF NOT EXISTS PUBLIC.`superhero` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nickname` varchar(80),
    `fullname` varchar(80),
    `gender` varchar(35),
    `height` NUMERIC(6,2),
    `weight` NUMERIC(6,2),
    `occupation` varchar(80),
    `creation_date` timestamp,
    `modification_date` timestamp,
    `power_id` int
);

CREATE TABLE IF NOT EXISTS PUBLIC.`power` (
    `id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `strength` NUMERIC(5,2),
    `speed` NUMERIC(5,2),
    `endurance` NUMERIC(5,2),
    `attack` NUMERIC(5,2),
    `superhero_id` int,
    foreign key (superhero_id) references superhero(id)
);

ALTER TABLE PUBLIC.`superhero` add foreign key (power_id) references power(id);