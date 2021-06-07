-- Exclui tudo para recriar
drop schema if exists gedam;
drop user if exists 'gedam'@'localhost';

source DDL.sql

source DML.sql
