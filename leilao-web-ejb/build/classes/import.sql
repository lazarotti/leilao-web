-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
INSERT INTO Categoria (id, version, nome) VALUES (1, 1, 'Automóveis');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (1,1,1,'VolksWagen');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (2,1,1,'Fiat');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (3,1,1,'Chevrolet');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (4,1,1,'Ford');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (5,1,1,'Peugeot');
INSERT INTO SubCategoria (id, version, categoriaPai_id, nome) VALUES (6,1,1,'Citroen');

INSERT INTO Categoria (id, version, nome) VALUES (2, 1, 'Eletrônicos');
INSERT INTO Categoria (id, version, nome) VALUES (3, 1, 'Eletrodomésticos');
INSERT INTO Categoria (id, version, nome) VALUES (4, 1, 'Informática');
INSERT INTO Categoria (id, version, nome) VALUES (5, 1, 'Animais');
INSERT INTO Categoria (id, version, nome) VALUES (6, 1, 'Música');
INSERT INTO Categoria (id, version, nome) VALUES (7, 1, 'Filme');

INSERT INTO Direito (id, nome, descricao) VALUES (1, 'administrador', 'Administrador de todo o sistema');
INSERT INTO Direito (id, nome, descricao) VALUES (2, 'comprador', 'Pode comprar produtos em leilao');
INSERT INTO Direito (id, nome, descricao) VALUES (3, 'vendedor', 'Pode vender produtos no leilao');

INSERT INTO Usuario (id, version, login, nome, pontuacao, senha, endereco, email) VALUES (1, 1 , 'alazarot', 'Alessandro Lazarotti', 0, '1234','São Paulo - Brasil','alazarot@redhat.com' );
INSERT INTO Usuario (id, version, login, nome, pontuacao, senha, endereco, email) VALUES (2, 1 , 'rafabene', 'Rafael Benevides', 0, '1234', 'Brasilia - Brasil','rafabene@redhat.com');
INSERT INTO Usuario (id, version, login, nome, pontuacao, senha, endereco, email) VALUES (3, 1 , 'admin', 'Administrador', 0, 'admin', 'São Paulo - Brasil','admin@redhat.com' );


INSERT INTO UsuarioDireito (usuarioId, direitoId) VALUES (3, 1);
INSERT INTO UsuarioDireito (usuarioId, direitoId) VALUES (1, 2);
INSERT INTO UsuarioDireito (usuarioId, direitoId) VALUES (2, 3);