create table new_table(
id_funcionarios bigint(20) not null auto_increment,
nome varchar(100) not null ,
idade int not null,
cpf varchar(15) not null,
cargo varchar (100) not null,
primary key (id_funcionarios)
);
