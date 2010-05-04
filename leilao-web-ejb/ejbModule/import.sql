-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
INSERT INTO Categoria (id, version, nome) VALUES (1, 1, 'Automóveis');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (1,1,1,'VolksWagen');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (2,1,1,'Fiat');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (3,1,1,'Chevrolet');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (4,1,1,'Ford');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (5,1,1,'Peugeot');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (6,1,1,'Citroen');

INSERT INTO Categoria (id, version, nome) VALUES (2, 1, 'Eletrônicos');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (7,1,2,'Celular');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (8,1,2,'Filmadora');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (9,1,2,'MP3');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (10,1,2,'Dvd');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (11,1,2,'Home-Theater');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (12,1,2,'Bluray');

INSERT INTO Categoria (id, version, nome) VALUES (3, 1, 'Eletrodomésticos');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (13,1,3,'Máquina de lavar');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (14,1,3,'Batedeira');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (15,1,3,'Lavadora');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (16,1,3,'Lava-louças');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (17,1,3,'Ferro de Passar');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (18,1,3,'Televisão');

INSERT INTO Categoria (id, version, nome) VALUES (4, 1, 'Informática');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (19,1,4,'CPU');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (20,1,4,'Memória');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (21,1,4,'Impressora');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (22,1,4,'HD');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (23,1,4,'Monitor');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (24,1,4,'Teclado');

INSERT INTO Categoria (id, version, nome) VALUES (5, 1, 'Animais');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (25,1,5,'Cachorro');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (26,1,5,'Gato');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (27,1,5,'Papagaio');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (28,1,5,'Tartagura');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (29,1,5,'Cavalo');

INSERT INTO Categoria (id, version, nome) VALUES (6, 1, 'Filme');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (30,1,6,'Rock');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (31,1,6,'Pop');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (32,1,6,'New age');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (33,1,6,'Sertaneja');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (34,1,6,'Pagode');

INSERT INTO Direito (id, nome, descricao) VALUES (1, 'administrador', 'Administrador de todo o sistema');
INSERT INTO Direito (id, nome, descricao) VALUES (2, 'comprador', 'Pode comprar produtos em leilao');
INSERT INTO Direito (id, nome, descricao) VALUES (3, 'vendedor', 'Pode vender produtos no leilao');
