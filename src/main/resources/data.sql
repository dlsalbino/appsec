DROP TABLE IF EXISTS heroes;

CREATE TABLE heroes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  company VARCHAR(250) NOT NULL
);

INSERT INTO
    heroes (name, company)
VALUES
  ('Wolverine', 'Marvel'),
  ('Rogue', 'Marvel'),
  ('Dark Phoenix', 'Marvel'),
  ('Storm', 'Marvel'),
  ('Black Widow', 'Marvel'),
  ('Nick Fury', 'Marvel'),
  ('Cyclops', 'Marvel'),
  ('Magneto', 'Marvel'),
  ('Thor', 'Marvel'),
  ('Iron Man', 'Marvel'),
  ('Superman', 'DC Comics'),
  ('Batman', 'DC Comics'),
  ('Wonder Woman', 'DC Comics'),
  ('Aquaman', 'DC Comics'),
  ('Flash', 'DC Comics');
