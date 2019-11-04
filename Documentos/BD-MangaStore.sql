create database MangaStore;
use MangaStore;
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
es_id smallint not null auto_increment,
es_nome varchar(45)not null,
primary key (es_id)
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
gen_id smallint not null auto_increment,
gen_nome varchar(45)not null unique,
primary key (gen_id)
);

create table prateleira(
pt_id smallint not null auto_increment,
pt_numero smallint not null auto_increment,
primary key (pt_id)
);








insert into cliente (cli_cpf,cli_nome,cli_email,cli_cel,cli_tel,cli_cep,cli_endereco,cli_cidade,cli_bairro,cli_complemento,cli_status)
values (12345678910,'Ana Maria Praga','am.praga@disgracamail.com','999999999','54785236','21445855','Rua globo 666','Sao Paulo','Jardim iluminati','','A');


