DROP TABLE IF EXISTS Currencies;

CREATE TABLE Currencies(
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(3) not null,
                          currency VARCHAR(10) not null);