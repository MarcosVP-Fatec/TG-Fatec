-- cria dados iniciais

-- ------------------------------------------------------------------------
-- USUÁRIO
-- ------------------------------------------------------------------------
insert into sec_usuario (nome, email, validhash) values ('MVP','marcos.pereira47@fatec.sp.gov.br','?');
update sec_usuario set _inc_usua = 1, _alt_usua = 1, _inc_data = '2021-04-01', _alt_data = '2021-04-01' where _inc_usua is null;
commit;

-- ------------------------------------------------------------------------
-- AUTORIZAÇÕES BÁSICAS
-- ------------------------------------------------------------------------
insert into sec_autorizacao (chave, descr) values ('ROLE_OWNER'    ,'Proprietário do sistema' );
insert into sec_autorizacao (chave, descr) values ('ROLE_ADMIN'    ,'Administrador do sistema');
insert into sec_autorizacao (chave, descr) values ('ROLE_MODELADOR','Modelador de tabelas'    );
insert into sec_autorizacao (chave, descr) values ('ROLE_CONSULTAR','Consultar sem alterações');
update sec_autorizacao set _inc_usua = 1, _alt_usua = 1, _inc_data = '2021-04-01', _alt_data = '2021-04-01' where _inc_usua is null;
commit;

-- ------------------------------------------------------------------------
-- AUTORIZAÇÕES DO USUÁRIO OWNER
-- ------------------------------------------------------------------------
insert into sec_aut_usuario (idaut, idusu) values (1,1);
insert into sec_aut_usuario (idaut, idusu) values (2,1);
update sec_aut_usuario set _inc_usua = 1, _alt_usua = 1, _inc_data = '2021-04-01', _alt_data = '2021-04-01' where _inc_usua is null;
commit;

-- ------------------------------------------------------------------------
-- DRIVERS - Estática
-- ------------------------------------------------------------------------
insert into mer_driver (nome, versao, anomesvs) values ('Oracle'    , '' , 999999);
insert into mer_driver (nome, versao, anomesvs) values ('SQL Server', '' , 999999);
insert into mer_driver (nome, versao, anomesvs) values ('MySql'     , '' , 999999);
update mer_driver set _inc_usua = 1, _alt_usua = 1, _inc_data = '2021-04-01', _alt_data = '2021-04-01' where _inc_usua is null;       
commit;

-- ------------------------------------------------------------------------
-- MÓDULOS - Estática
-- ------------------------------------------------------------------------
insert into mer_modulo (nome,prefixo,prefixochk) values ('MER','MER','S');
update mer_modulo set _inc_usua = 1, _alt_usua = 1, _inc_data = '2021-04-01', _alt_data = '2021-04-01' where _inc_usua is null;       
commit;

-- ------------------------------------------------------------------------
-- MESES
-- ------------------------------------------------------------------------
insert into est_mes (id, descr) values ('01','Janeiro'  );
insert into est_mes (id, descr) values ('02','Fevereiro');
insert into est_mes (id, descr) values ('03','Março'    );
insert into est_mes (id, descr) values ('04','Abril'    );
insert into est_mes (id, descr) values ('05','Maio'     );
insert into est_mes (id, descr) values ('06','Junho'    );
insert into est_mes (id, descr) values ('07','Julho'    );
insert into est_mes (id, descr) values ('08','Agosto'   );
insert into est_mes (id, descr) values ('09','Setembro' );
insert into est_mes (id, descr) values ('10','Outubro'  );
insert into est_mes (id, descr) values ('11','Novembro' );
insert into est_mes (id, descr) values ('12','Dezembro' );
update est_mes set _inc_usua = 1, _alt_usua = 1, _inc_data = '2021-04-01', _alt_data = '2021-04-01' where _inc_usua is null;       
commit;

/*
-- ------------------------------------------------------------------------
-- Cadastra o usuário administrador inicial necessário para usar o sistema
-- ------------------------------------------------------------------------
insert into usu_usuario ( usu_apelido
                         , usu_email                   
                         , usu_senha
                         , usu_pj_ou_pf
                         , usu_nome       
                         , usu_dt_nascimento
                         , usu_cpf_cnpj
                         , usu_nivel) 
                 values ( "ADMIN"      
                         , "administrador@saloon.com.br"
                         , "$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C"   
                         , "J"          
                         , "Administrador"
                         , '1969-04-12'     
                         , '11111111111111'
                         , 1 );

update usu_usuario set _inc_usua = 1, _inc_data = now() where usu_id = 1;

*/

commit;