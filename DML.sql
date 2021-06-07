-- cria dados iniciais

-- ------------------------------------------------------------------------
-- USUÁRIO
-- ------------------------------------------------------------------------
insert into sec_usuario (nome, email, validhash) values ('MVP','marcos.pereira47@fatec.sp.gov.br','?');
commit;
update sec_usuario set _inc_usua = 1 
                     , _alt_usua = 1
                     , _inc_data = '2021-04-01'
                     , _alt_data = '2021-04-01'
        where nome = 'MVP';

-- ------------------------------------------------------------------------
-- AUTORIZAÇÕES BÁSICAS
-- ------------------------------------------------------------------------
insert into sec_autorizacao (chave, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('ROLE_OWNER'    ,'Proprietário do sistema' ,1,'2021-04-01',1,'2021-04-01');
insert into sec_autorizacao (chave, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('ROLE_ADMIN'    ,'Administrador do sistema',1,'2021-04-01',1,'2021-04-01');
insert into sec_autorizacao (chave, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('ROLE_MODELADOR','Modelador de tabelas'    ,1,'2021-04-01',1,'2021-04-01');
insert into sec_autorizacao (chave, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('ROLE_CONSULTAR','Consultar sem alterações',1,'2021-04-01',1,'2021-04-01');

-- ------------------------------------------------------------------------
-- AUTORIZAÇÕES DO USUÁRIO OWNER
-- ------------------------------------------------------------------------
insert into sec_aut_usuario (idaut, idusu, _inc_usua, _inc_data, _alt_usua, _alt_data) 
       values (1,1,1,'2021-04-01',1,'2021-04-01');
insert into sec_aut_usuario (idaut, idusu, _inc_usua, _inc_data, _alt_usua, _alt_data) 
       values (2,1,1,'2021-04-01',1,'2021-04-01');

-- ------------------------------------------------------------------------
-- MESES
-- ------------------------------------------------------------------------
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('01','Janeiro'  ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('02','Fevereiro',1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('03','Março'    ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('04','Abril'    ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('05','Maio'     ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('06','Junho'    ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('07','Julho'    ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('08','Agosto'   ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('09','Setembro' ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('10','Outubro'  ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('11','Novembro' ,1,'2021-04-01',1,'2021-04-01');
insert into est_mes (id, descr, _inc_usua, _inc_data, _alt_usua, _alt_data) values ('12','Dezembro' ,1,'2021-04-01',1,'2021-04-01');
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