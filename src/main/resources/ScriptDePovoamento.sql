--CREATE DATABASE dsweb_TF;

CREATE TABLE produtos(
  id serial NOT NULL,
  nome character varying(100),
  preco double precision,
  descricao character varying(300),
  qtd bigint,
  img_link character varying(150),
  classificacao character varying(50),
  CONSTRAINT produtos_pkey PRIMARY KEY (id)
);

CREATE TABLE servicos(
  id serial NOT NULL,
  nome character varying(100),
  preco double precision,
  descricao character varying(300),
  CONSTRAINT servicos_pkey PRIMARY KEY (id)
);

CREATE TABLE usuarios(
  id serial NOT NULL,
  nome character varying(100),
  endereco character varying(500),
  cpf character varying(15),
  email character varying(100),
  telefone character varying(15),
  senha character varying(50),
  role character varying(20),
  CONSTRAINT usuarios_pkey PRIMARY KEY (id),
  CONSTRAINT usuarios_cpf_email_key UNIQUE (cpf, email)
);

CREATE TABLE favoritos (
  usuario_id integer,
  produto_id integer,
  CONSTRAINT servico_fk FOREIGN KEY (produto_id)
      REFERENCES produtos (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_fk FOREIGN KEY (usuario_id)
      REFERENCES usuarios (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE servicos_solicitados (
id serial,
usuario_id int,
servico_id int,
data_solicitada varchar(10),
hora_solicitada varchar(8),
status varchar(15),
constraint pk primary key (id),
constraint usuario_fk foreign key (usuario_id) references usuarios(id),
constraint servico_fk foreign key (servico_id) references servicos(id)
);

CREATE TABLE historicos(
  usuario_id integer,
  produto_id integer,
  CONSTRAINT servico_fk FOREIGN KEY (produto_id)
      REFERENCES produtos (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_fk FOREIGN KEY (usuario_id)
      REFERENCES usuarios (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--Inserindo administrador
--Login:petshow@administrador Senha:petshow123
insert into usuarios (nome,email,senha,role) values ('Adiministrador','petshow@administrador.com','petshow123','admin');

--Povoando usuarios
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('joao','Rua Exemplo','999.999.999-99','joao@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('maria','Rua Exemplo','999.999.999-99','maria@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('pedro','Rua Exemplo','999.999.999-99','pedro@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('jose','Rua Exemplo','999.999.999-99','jose@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('lucas','Rua Exemplo','999.999.999-99','lucas@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('mateus','Rua Exemplo','999.999.999-99','mateus@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('lucivan','Rua Exemplo','999.999.999-99','lucivan@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('marcos','Rua Exemplo','999.999.999-99','marcos@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('bruno','Rua Exemplo','999.999.999-99','bruno@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('simão','Rua Exemplo','999.999.999-99','simao@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Vinicius Pereira Melo','Rua Exemplo','999.999.999-99','vinicius@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Vitória Lima Cardoso','Rua Exemplo','999.999.999-99','vitoria@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Diogo Fernandes Cunha','Rua Exemplo','999.999.999-99','diogo@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Thiago Gomes Cavalcanti','Rua Exemplo','999.999.999-99','thiago@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Antônio Alves Pinto','Rua Exemplo','999.999.999-99','antonio@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Julian Santos Rodrigues','Rua Exemplo','999.999.999-99','julian@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Isabelle Souza Lima','Rua Exemplo','999.999.999-99','isabelle@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Davi Dias Santos','Rua Exemplo','999.999.999-99','davi@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Larissa Ribeiro Rocha','Rua Exemplo','999.999.999-99','larissa@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Mariana Dias Castro','Rua Exemplo','999.999.999-99','mariana@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Kauã Melo Rodrigues','Rua Exemplo','999.999.999-99','kaua@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Otávio Lima Dias','Rua Exemplo','999.999.999-99','otavio@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Fábio Fernandes Pinto','Rua Exemplo','999.999.999-99','fabio@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Livia Sousa Rodrigues','Rua Exemplo','999.999.999-99','livia@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Matilde Rodrigues Barros','Rua Exemplo','999.999.999-99','matilde@gmail.com','(99)99999-9999','1234','usuario');
insert into usuarios (nome,endereco,cpf,email,telefone,senha,role) values ('Júlio Alves Carvalho','Rua Exemplo','999.999.999-99','julio@gmail.com','(99)99999-9999','1234','usuario');

--Povoando Serviços
INSERT INTO servicos(nome, preco, descricao) VALUES ('TOSA', 15.5, 'Tirar o excesso de pelo do seu PET');
INSERT INTO servicos(nome, preco, descricao) VALUES ('BANHO', 20, 'Dar banho no seu PET');
INSERT INTO servicos(nome, preco, descricao) VALUES ('VACINA', 10.5, 'Vacinar o seu PET');
INSERT INTO servicos(nome, preco, descricao) VALUES ('VETERINARIO', 10.5, 'Marcar consulta veterianaria para o seu PET');

--Povoando Produtos
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Whiskas Ração Sachê Atum Adultos',100,'Ração Para Gato de Atum',100,'/img/produtos/Whiskas_Ração_Sachê_Atum_Adultos.jpg','Gato');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Osso de Brinquedo de Plastico',10,'Briquedo para cachorros',200,'/img/produtos/3101617-2.jpg','Cachorro');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Alpiste para Calopsita',20,'Alpiste para Calopsitas',100,'/img/produtos/31019591-1.jpg','Aves');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Anti-Pulgas e Carrapatos',30.7999992370605,'Repelente para pulgas',100,'/img/produtos/Anti-Pulgas-e-Carrapatos-Merial-NexGard-28_3-mg---Cães-de-4_1-a-10-Kg.jpg','Cachorro');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Gaiola',10.1000003814697,'Gaiola para passaros',10,'/img/produtos/70299.jpg','Aves');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Jaula para Hamster',60.9900016784668,'Jaula para um roedor pequeno',12,'/img/produtos/0000000028662_1.jpg','Roedores');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Ração Pedigree Sache',19,'Ração Para Cachorro',100,'/img/produtos/Ração_Pedigree_Sachê_Cordeiro_ao_Molho_para_Cães_Adultos_de_Raças_Pequenas_3106425.jpg','Cachorro');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Ração de Frango',30,'Ração Para Cachorro sabor Frango',123,'/img/produtos/GOLDEN-SPECIAL-FRANGO---CARNE-ADULTOS.jpg','Cachorro');
INSERT INTO produtos(nome, preco, descricao, qtd, img_link, classificacao) VALUES ('Brinquedo de Arranhar',11.1000003814697,'Brinquedo de Arranhar para gatos',100,'/img/produtos/Brinquedo_Arranhador_para_Gatos_Elegance_Chalesco.jpg','Gato');