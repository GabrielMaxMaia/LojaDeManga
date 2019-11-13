#select * from  ;
create database if not exists MangaStore;
use MangaStore;

###################################
#   		 CRIANDO TABLES       #
###################################

create table Cliente(
cli_cpf varchar(11) not null unique,
cli_nome varchar(45) not null,
cli_email varchar(45)not null unique,
cli_cel varchar(15) not null,
cli_tel varchar(14)not null,
cli_cep varchar(8)not null,
cli_endereco varchar(45) not null,
cli_cidade varchar(25) not null,
cli_bairro varchar(20)not null,
cli_complemento varchar(20),
cli_status char not null,
primary key (cli_cpf)
);

create table funcionarios(
func_id smallint not null auto_increment,
func_nome varchar(45)not null,
primary key(func_id)
);

create table titulo(
ti_id int auto_increment not null,
ti_nome varchar(45)not null unique,
primary key (ti_id)
);
#create table estilo (
#et_id smallint not null auto_increment,
#et_nome varchar(45)not null,
#primary key (et_id)
#);

create table autor(
au_id smallint not null auto_increment,
au_nome varchar(45) not null,
primary key (au_id)
);

create table fornecedor(
for_id smallint not null auto_increment,
for_nome varchar(45) not null unique,
for_status char not null,
primary key (for_id)
);

#create table genero(
#gen_id tinyint not null auto_increment,
#gen_nome varchar(45)not null unique,
#primary key (gen_id)
#);

create table prateleira(
pt_id smallint not null auto_increment,
pt_letra varchar(1) not null,
primary key (pt_id)
);

create table estante(
es_id smallint not null auto_increment,
primary key (es_id)
);



create table produto (
pd_id int not null auto_increment unique,
pd_preco decimal(10,2) not null,
#pd_status char not null,
pd_titulo varchar(40) not null,
pd_autor varchar(40) not null,
#pd_fornecedor smallint not null,
#pd_genero tinyint not null,
#pd_estante smallint not null,
#pd_prateleira smallint not null,
#pd_estilo smallint not null,
pd_quantidade int not null,
#foreign key(pd_titulo) references titulo(ti_id),
#foreign key(pd_autor) references autor(au_id),
#foreign key(pd_fornecedor) references fornecedor(for_id),
#foreign key(pd_genero) references genero(gen_id),
#foreign key (pd_estante) references estante(es_id),
#foreign key (pd_prateleira) references prateleira(pt_id)
#foreign key (pd_estilo) references estilo(et_id)
primary key (pd_id)
);

create table venda (
ve_id int not null auto_increment unique,
ve_cliente varchar(11)not null,
ve_funcionario smallint not null,
foreign key (ve_cliente) references cliente(cli_cpf),
foreign key (ve_funcionario) references funcionarios(func_id)
);


create table itens (
cp_produto int not null,
cp_compras int not null,
foreign key (cp_produto) references produto(pd_id),
foreign key (cp_compras) references venda(ve_id)
);

create table estante_prateleira (
ep_estante smallint not null,
ep_prateleira smallint not null,
foreign key (ep_estante) references estante(es_id),
foreign key (ep_prateleira) references prateleira(pt_id)
);

################################################################
#                      POPULANDO TABLES                        #
################################################################

insert into cliente (cli_cpf,cli_nome,cli_email,cli_cel,cli_tel,cli_cep,cli_endereco,cli_cidade,cli_bairro,cli_complemento,cli_status)
values  (12345678910,'Ana Maria Praga','am.praga@disgracamail.com','999999999','54785236','21445855','Rua globo 666','Sao Paulo','Jardim iluminati','','A'),
		(56487512345,'Lohan K-pop','lkpop@cortedegiromail.com','856478598','52487525','85475625','Rua Uber Eats 24','Sao Paulo','Jardim do Grau','','P'),
        (15245875654,'Matheus Bareeeeeeeeeeto','Bareeeeeeeeeeeeto@crossfiremail.com','875498564','85475625','85478514','Rua Ruim de Mira 13','Sao Paulo','Jardim Bare Eeto','','A');

 #insert into titulo (ti_nome)
  #values ('Bleach');
  
#insert into autor (au_nome)
	#values ('Tite Kubo');
  
insert into produto (pd_preco,pd_titulo,pd_autor,pd_quantidade)
	values (10.00,'Bleach','Tite Kubo',100),
		   (10.00,'One Piece','Eichiro Oda',100),
		   (10.00,'Naruto','Masashi Kishimoto',100),
		   (10.00,'Samurai X','Nobuhiro Watsuki',100),
		   (10.00,'Belzebub','Ryuhei Tamura',100),
		   (10.00,'Kuroko no Basket','Tadatoshi Fujimaki',100),
		   (10.00,'Dragon Ball','Akira Toriyama',100),
		   (10.00,'Yu Yu Hakusho','Yoshihiro Togashi',100),
		   (10.00,'Yu-Gi-Oh','Kazuki Takahashi',100),
		   (10.00,'Death Note','Tsugumi Ohba',100);
		 
insert into funcionarios(func_nome)
 values ('Rubens Toreto'),
		('Raphaela Fitness Wagner'),
        ('Max Jesus Maia'),
        ('Rogerio POG Lucon'),
        ('Matheus AntiCristo Makoto');
        
 
#insert into fornecedor (for_nome,for_status)
	#values ('Panini','A');
 


