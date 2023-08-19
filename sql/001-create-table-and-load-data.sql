DROP TABLE IF EXISTS guests;

CREATE TABLE guests (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  age int NOT NULL,
  address VARCHAR(50) NOT NULL,
  PRIMARY KEY(id)
);


INSERT INTO guests (name, age, address) VALUES ("yamada", 30, "東京都千代田区");
INSERT INTO guests (name, age, address) VALUES ("tanaka", 40, "大阪府大阪市");
INSERT INTO guests (name, age, address) VALUES ("okamoto", 50, "北海道札幌市");
INSERT INTO guests (name, age, address) VALUES ("murakami", 60, "沖縄県那覇市");

