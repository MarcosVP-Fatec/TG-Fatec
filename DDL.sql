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
      id            car(1)      not null
    , descr         varchar(20) not null
    , istamanho     boolean
    , isdecimal     boolean
    , constraint mer_coluna_tipo_pk primary key (id)
    , constraint mer_coluna_tipo_descr_uk unique (id)
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

/*

-- ------------------------------------------------------------------------
-- USUARIO
-- ------------------------------------------------------------------------
create table usu_usuario (
      usu_id                bigint unsigned primary key auto_increment
    , usu_apelido           varchar(30)     not null
    , usu_email             varchar(255)    not null
    , usu_senha             varchar(100)    not null
    , usu_senha_validade    date
    , usu_pj_ou_pf          varchar(1)     
    , usu_nome              varchar(80)     not null
    , usu_dt_nascimento     date            not null
    , usu_cpf_cnpj          varchar(14)     not null
    , usu_nivel             bigint unsigned not null
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , usu_cod_nova_senha    bigint  
    , constraint usu_apelido_uk unique (usu_apelido)
    , constraint usu_email_uk unique (usu_email)
    , constraint usu_nivel_pk foreign key (usu_nivel)
        references niv_usuario (niv_id)
);

-- ------------------------------------------------------------------------
-- PROPRIETARIO 
-- ------------------------------------------------------------------------
create table pro_proprietario (
      pro_usu_id            bigint unsigned
    , pro_dt_inicio         datetime
    , pro_dt_limite         date
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint pro_usu_id_fk foreign key (pro_usu_id)
         references usu_usuario (usu_id)
);

-- ------------------------------------------------------------------------
-- PARCEIRO
-- ------------------------------------------------------------------------
create table par_parceiro (
      par_usu_id            bigint unsigned
    , par_dt_inicio         datetime
    , par_inativo           bit
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint par_usu_id_fk foreign key (par_usu_id)
         references usu_usuario (usu_id)
);

-- ------------------------------------------------------------------------
-- ALUGAVEL_TIPO - Tipo do local que será alugado
-- ------------------------------------------------------------------------
-- 1-Salão de Festas
-- 2-Salão de Palestras
-- 3-Salão de Reuniões
-- 4-Sala de Aula
-- 5-Terreno Vazio
-- ------------------------------------------------------------------------
create table alt_alugavel_tipo (
      alt_id                bigint unsigned primary key auto_increment
    , alt_descr             varchar(20)     not null
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
);

-- ------------------------------------------------------------------------
-- ALUGAVEL - Objeto da locação
-- ------------------------------------------------------------------------
create table alu_alugavel(
      alu_id                bigint unsigned primary key auto_increment
    , alu_pro_id            bigint unsigned not null
    , alu_alt_id            bigint unsigned not null
    , alu_descr             varchar(50)
    , alu_endereco          varchar(500)
    , alu_capacidade        int unsigned
    , alu_valor             decimal(10,2) unsigned
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint alu_pro_id_fk foreign key (alu_pro_id)
         references pro_proprietario (pro_usu_id)
    , constraint alu_alt_id_fk foreign key (alu_alt_id)
         references alt_alugavel_tipo (alt_id)
    , constraint alu_descr_uk unique (alu_descr)
);

-- ------------------------------------------------------------------------
-- ALUGAVEL - Objeto da locação
-- ------------------------------------------------------------------------
create table cli_cliente (
      cli_id                bigint unsigned primary key auto_increment
    , cli_cpf_cnpj          varchar(14) not null
    , cli_nome              varchar(80) not null
    , cli_tel_ddd           varchar(2)   
    , cli_tel_numero        varchar(10) 
    , cli_pco_id            bigint unsigned
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint cli_cpf_cnpj_uk unique (cli_cpf_cnpj)
    , constraint cli_nome_uk unique (cli_nome)
);

create table ctm_contrato_motivo (
      ctm_id                bigint unsigned primary key auto_increment
    , ctm_descr             varchar(30)
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint ctm_descr_uk unique (ctm_descr)
);

create table ctt_contrato (
      ctt_id                bigint unsigned primary key auto_increment
    , ctt_cli_id            bigint unsigned not null
    , ctt_alu_id            bigint unsigned not null
    , ctt_data              date            not null
    , ctt_reserva_paga      decimal(10,2)   not null
    , ctt_ctm_id            bigint unsigned not null
    , ctt_festejo_nomes     varchar(4000)
    , ctt_festejo_mes_id    bigint unsigned 
    , ctt_festejo_dia       int unsigned
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint ctt_ctm_id_fk foreign key (ctt_ctm_id) 
        references ctm_contrato_motivo (ctm_id)
    , constraint ctt_alu_id_fk foreign key (ctt_alu_id)    
        references alu_alugavel (alu_id)
    , constraint ctt_festejo_mes_id_fk foreign key (ctt_festejo_mes_id)
        references mes_ano (mes_id)
);

create table pxc_parceiro_x_cliente (
      pxc_par_usu_id        bigint unsigned 
    , pxc_cli_id            bigint unsigned 
    , primary key pxc_parceiro_x_cliente_pk (pxc_par_usu_id, pxc_cli_id)
    , constraint pxc_par_id_fk foreign key (pxc_par_usu_id) 
        references par_parceiro (par_usu_id)
    , constraint pxc_cli_id_fk foreign key (pxc_cli_id) 
        references cli_cliente (cli_id)
);

create table par_parametro (
      par_id                bigint unsigned primary key auto_increment
    , par_cod               varchar(30)    not null
    , par_descr             varchar(100)
    , par_tipo              char(1)        not null -- int, String, Date
    , par_val_num           double
    , par_val_str           varchar(4000)
    , par_val_dat           Date
    , par_val_bol           boolean
    , _inc_usua             bigint          
    , _inc_data             datetime            
    , _alt_usua             bigint          
    , _alt_data             datetime            
    , constraint par_cod_uk unique (par_cod) 
);
*/