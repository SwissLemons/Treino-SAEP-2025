create table usuarios(
id int primary key auto_increment,
nome varchar(50) not null default '',
email varchar(70)not null unique default ''
);

create table tarefas(
id int primary key auto_increment,
id_usuario int not null,
descricao varchar(255) not null default '',
setor varchar(60) not null default '',
prioridade varchar(10) default 'baixa',
data_cadastro timestamp default(current_Timestamp),
estatus  varchar(10) default 'fazer',
foreign key(id_usuario) references usuarios(id)
);

select * from usuarios;
select * from tarefas;

drop table usuarios;
drop table tarefas;