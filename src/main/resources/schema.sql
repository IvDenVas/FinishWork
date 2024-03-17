CREATE TABLE IF NOT EXISTS notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description varchar(50) NOT NULL,
    date varchar(50) NOT NULL
    );

INSERT INTO notes (title, description,date)
VALUES ('Первая', 'Тело первой заметки','2019-01-10T12:18:25.927109200');

INSERT INTO notes (title, description,date)
VALUES ('Вторая', 'Тело второй заметки','2019-01-10T12:18:25.927109200');

INSERT INTO notes (title, description,date)
VALUES ('Третья', 'Тело третьей заметки','2019-01-10T12:18:25.927109200');

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    tel_number varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    user_role varchar(50) NOT NULL
    );

INSERT INTO users (name, password, tel_number, email, user_role)
VALUES ('Den','$2a$05$DgEuwa7iEQlZhnO2xEhKZeeJDiw0vCKTGcL.aqIwvti9OfG2su3ri','89037104628','ivdenvas@gmail.com','admin');

INSERT INTO users (name, password, tel_number, email, user_role)
VALUES ('User','$2a$05$H8rJg/3Zmt4uz9csiiX.j.jaNlNaEor0vSxcfddgM4AwgXKmFsE8y','89095632135','olgawer@gmail.com','user');

