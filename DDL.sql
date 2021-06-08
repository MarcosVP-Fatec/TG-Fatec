-- ------------------------------------------------------------------------
-- cria schema e usuário
-- ------------------------------------------------------------------------
create schema if not exists gedam;
use gedam;
create user if not exists 'gedamsys'@'localhost' identified by 'g3daM';
grant select, insert, delete, update on gedam.* to gedamsys@'localhost';

-- ------------------------------------------------------------------------
-- USUARIO
-- ------------------------------------------------------------------------
create table sec_usuario (
      id            bigint auto_increment
    , nome          varchar(30)
    , email         varchar(500)
    , validhash     varchar(100)
    , constraint sec_usuario_pk primary key (id)
--  Padrão auditoria     
    , _inc_usua     bigint
    , _inc_data     datetime            
    , _alt_usua     bigint          
    , _alt_data     datetime            
    , constraint sec_usuario_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint sec_usuario_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);
create index sec_usuario_id    on sec_usuario(id);
create index sec_usuario_nome  on sec_usuario(nome);
create index sec_usuario_email on sec_usuario(email);

-- ------------------------------------------------------------------------
-- AUTORIZAÇÕES
-- ------------------------------------------------------------------------
create table sec_autorizacao (
      id            bigint auto_increment
    , chave         varchar(30)
    , descr         varchar(100)
    , constraint sec_autorizacao_pk primary key (id)
--  Padrão auditoria     
    , _inc_usua     bigint
    , _inc_data     datetime            
    , _alt_usua     bigint          
    , _alt_data     datetime            
    , constraint sec_autorizacao_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint sec_autorizacao_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);
create index sec_autorizacao_id     on sec_autorizacao(id);
create index sec_autorizacao_chave  on sec_autorizacao(chave);

-- ------------------------------------------------------------------------
-- AUTORIZAÇÕES DOS USUÁRIOS
-- ------------------------------------------------------------------------
create table sec_aut_usuario (
      id            bigint auto_increment
    , idaut         bigint
    , idusu         bigint
    , constraint sec_aut_usuario_pk primary key (id)
    , constraint sec_aut_usuario_idaut_fk foreign key (idaut)
                 references sec_autorizacao (id)
    , constraint sec_aut_usuario_idusu_fk foreign key (idusu)
                 references sec_usuario (id)
--  Padrão auditoria     
    , _inc_usua     bigint
    , _inc_data     datetime            
    , _alt_usua     bigint          
    , _alt_data     datetime            
    , constraint sec_aut_usuario_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint sec_aut_usuario_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);
create index sec_aut_usuario_id           on sec_aut_usuario(id);
create index sec_aut_usuario_idaut_idusu  on sec_aut_usuario(idaut,idusu);

-- ------------------------------------------------------------------------
-- DRIVERS - ESTÁTICA
-- ------------------------------------------------------------------------
create table mer_driver (
      id            bigint auto_increment
    , nome          varchar(30)  not null
    , versao        varchar(30)  not null
    , anomesvs      int
    , constraint mer_driver_pk primary key (id)
    , constraint mer_driver_nome_uk unique (nome)
--  Padrão auditoria     
    , _inc_usua     bigint
    , _inc_data     datetime            
    , _alt_usua     bigint          
    , _alt_data     datetime            
    , constraint mer_driver_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint mer_driver_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);
create index mer_driver_id    on mer_driver(id);
create index mer_driver_nome  on mer_driver(nome);

-- ------------------------------------------------------------------------
-- MÓDULOS - CADASTRO USUÁRIO
-- ------------------------------------------------------------------------
create table mer_modulo (
      id            bigint auto_increment
    , nome          varchar(30)  not null
    , prefixo       varchar(3)   not null
    , prefixonochk  varchar(1)   not null
    , constraint mer_modulo_pk primary key (id)
    , constraint mer_modulo_nome_uk unique (nome)
--  Padrão auditoria     
    , _inc_usua     bigint
    , _inc_data     datetime            
    , _alt_usua     bigint          
    , _alt_data     datetime            
    , constraint mer_modulo_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint mer_modulo_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);
create index mer_modulo_id    on mer_driver(id);
create index mer_modulo_nome  on mer_driver(nome);

-- ------------------------------------------------------------------------
-- TIPO DE DADO - Estática
-- ------------------------------------------------------------------------
create table mer_coluna_tipo (
      idtipocol     varchar(1)  not null
    , descr         varchar(20) not null
    , istamanho     boolean
    , isdecimal     boolean
    , constraint mer_coluna_tipo_pk primary key (idtipocol)
    , constraint mer_coluna_tipo_descr_uk unique (descr)
--  Padrão auditoria
    , _inc_usua     bigint
    , _inc_data     datetime
    , _alt_usua     bigint
    , _alt_data     datetime
    , constraint mer_coluna_tipo_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint mer_coluna_tipo_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);

-- ------------------------------------------------------------------------
-- DOMÍNIO - TIPO DE CAMPO - Cadastro usuário
-- ------------------------------------------------------------------------
create table mer_dominio_campo (
      iddomcampo    varchar(30)   not null
    , padrao        varchar(63)   not null
    , idtipocol     varchar(1)    not null
    , tamanho       int
    , decimais      int
    , constraint mer_dominio_tp_pk primary key (iddomcampo)
    , constraint mer_dominio_tp_tipo_fk foreign key (idtipocol)
                references mer_coluna_tipo(idtipocol)
--  Padrão auditoria
    , _inc_usua     bigint
    , _inc_data     datetime
    , _alt_usua     bigint
    , _alt_data     datetime
    , constraint mer_dominio_tp_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint mer_dominio_tp_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);

-- ------------------------------------------------------------------------
-- MESES
-- ------------------------------------------------------------------------
create table est_mes (
      id            varchar(2)
    , descr         varchar(9)
    , constraint est_mes_pk primary key (id)
    , constraint est_mes_descr_uk unique (descr)
--  Padrão auditoria     
    , _inc_usua     bigint
    , _inc_data     datetime            
    , _alt_usua     bigint          
    , _alt_data     datetime            
    , constraint est_mes_inc_usua_fk foreign key (_inc_usua)
                 references sec_usuario (id)
    , constraint est_mes_alt_usua_fk foreign key (_alt_usua)
                 references sec_usuario (id)
);

