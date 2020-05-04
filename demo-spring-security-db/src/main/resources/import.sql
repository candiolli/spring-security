insert into Usuario (id, nome, login, senha, ativo) values (1, 'Silas Candiolli', 'silas', '$2a$10$DZdrxhWKE3Um9RY2tzHwOeEdG.A4wrLpVDIesfFq0hSadXrmuyNam', true);
insert into Usuario (id, nome, login, senha, ativo) values (2, 'Bruna Candiolli', 'bruna', '$2a$10$DZdrxhWKE3Um9RY2tzHwOeEdG.A4wrLpVDIesfFq0hSadXrmuyNam', true);

insert into GRUPO (id, nome, descricao) values (1, 'ANALISTA', 'Grupo de analistas');
insert into GRUPO (id, nome, descricao) values (2, 'SUPERVISOR', 'Grupo de supervisores');

insert into PERMISSAO (id, nome) values (1, 'ADMIN');
insert into PERMISSAO (id, nome) values (2, 'READER');
insert into PERMISSAO (id, nome) values (3, 'WRITER');

insert into USUARIO_GRUPOS (usuarios_id, grupos_id) values (1, 1);
insert into USUARIO_GRUPOS (usuarios_id, grupos_id) values (2, 2);

insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (2, 1);
insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (2, 2);
insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (2, 3);

insert into GRUPO_PERMISSOES (grupos_id, permissoes_id) values (1, 2);