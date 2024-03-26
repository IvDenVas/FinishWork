CREATE SCHEMA IF NOT EXISTS MySchema;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    password varchar(100) NOT NULL,
    tel_number varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    user_role varchar(50) NOT NULL
    );

INSERT INTO users (name, password, tel_number, email, user_role)
VALUES ('Admin','$2a$05$DgEuwa7iEQlZhnO2xEhKZeeJDiw0vCKTGcL.aqIwvti9OfG2su3ri','89257101623','admin@gmail.com','admin');

INSERT INTO users (name, password, tel_number, email, user_role)
VALUES ('User1','$2a$05$H8rJg/3Zmt4uz9csiiX.j.jaNlNaEor0vSxcfddgM4AwgXKmFsE8y','89095632135','user1.com','user');

INSERT INTO users (name, password, tel_number, email, user_role)
VALUES ('User2','$2a$05$H8rJg/3Zmt4uz9csiiX.j.jaNlNaEor0vSxcfddgM4AwgXKmFsE8y','89295634135','user2@gmail.com','user');

CREATE TABLE IF NOT EXISTS notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description varchar(200) NOT NULL,
    date varchar(50) NOT NULL,
    id_user INT NOT NULL,
    FOREIGN KEY (id_user)  REFERENCES users (id)
    );

INSERT INTO notes (title, description, date, id_user)
VALUES ('Первая', 'Тело первой заметки','2019-01-10T12:18:25.927109200', '2');

INSERT INTO notes (title, description, date, id_user)
VALUES ('Вторая', 'Тело второй заметки','2019-01-10T12:18:25.927109200', '2');

INSERT INTO notes (title, description, date, id_user)
VALUES ('Третья', 'Тело третьей заметки','2019-01-10T12:18:25.927109200', '2');

INSERT INTO notes (title, description, date, id_user)
VALUES ('Четвертая', 'Тело 4-ой заметки','2019-01-10T12:18:25.927109200', '3');

INSERT INTO notes (title, description, date, id_user)
VALUES ('Пятая', 'Тело 5-ой заметки','2019-01-10T12:18:25.927109200', '3');

INSERT INTO notes (title, description, date, id_user)
VALUES ('Шестая', 'Тело 6-ой заметки','2019-01-10T12:18:25.927109200', '3');


