-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
INSERT INTO Categoria (id, version, nome) VALUES (1, 1, 'Automóveis');
INSERT INTO SubCategoria (id, version, categoriaPai, nome) VALUES (1,1,1,'VolksWagen');
INSERT INTO SubCategoria (id, version, categoriaPai, nome) VALUES (1,1,1,'Fiat');
INSERT INTO SubCategoria (id, version, categoriaPai, nome) VALUES (1,1,1,'Chevrolet');
INSERT INTO SubCategoria (id, version, categoriaPai, nome) VALUES (1,1,1,'Ford');
INSERT INTO SubCategoria (id, version, categoriaPai, nome) VALUES (1,1,1,'Peugeot');
INSERT INTO SubCategoria (id, version, categoriaPai, nome) VALUES (1,1,1,'Citroen');

INSERT INTO Categoria (id, version, nome) VALUES (2, 1, 'Eletrônicos');
INSERT INTO Categoria (id, version, nome) VALUES (3, 1, 'Eletrodomésticos');
INSERT INTO Categoria (id, version, nome) VALUES (4, 1, 'Informática');
INSERT INTO Categoria (id, version, nome) VALUES (5, 1, 'Animais');
INSERT INTO Categoria (id, version, nome) VALUES (6, 1, 'Música');
INSERT INTO Categoria (id, version, nome) VALUES (7, 1, 'Filme');