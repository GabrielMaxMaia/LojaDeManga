
create database MangaStore;
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
create table estilo (
et_id smallint not null auto_increment,
et_nome varchar(45)not null,
primary key (et_id)
);

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

create table genero(
gen_id tinyint not null auto_increment,
gen_nome varchar(45)not null unique,
primary key (gen_id)
);

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
pd_preco float not null,
pd_status char not null,
pd_titulo int not null,
pd_autor smallint not null,
pd_fornecedor smallint not null,
pd_genero tinyint not null,
pd_estante smallint not null,
pd_prateleira smallint not null,
pd_estilo smallint not null,
foreign key(pd_titulo) references titulo(ti_id),
foreign key(pd_autor) references autor(au_id),
foreign key(pd_fornecedor) references fornecedor(for_id),
foreign key(pd_genero) references genero(gen_id),
foreign key (pd_estante) references estante(es_id),
foreign key (pd_prateleira) references prateleira(pt_id),
foreign key (pd_estilo) references estilo(et_id)
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
values (12345678910,'Ana Maria Praga','am.praga@disgracamail.com','999999999','54785236','21445855','Rua globo 666','Sao Paulo','Jardim iluminati','','A');





