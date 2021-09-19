--Remove corredor e cria a tabela novamente
DROP TABLE corredores IF EXISTS;
CREATE TABLE corredores(
    cpf VARCHAR(255), 
    nome VARCHAR(255), 
    genero VARCHAR(255), 
    diaDn int, 
    mesDn int, 
    anoDn int, 
    PRIMARY KEY(cpf)
);

--Inserindo corredores
INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) 
VALUES ('10001287','Luiz','masculino',22,5,1987);

--Remove tabela Eventos e Cria tabela Eventos
DROP TABLE eventos IF EXISTS;
CREATE TABLE eventos(
    id int, 
    nome VARCHAR(255), 
    dia int, 
    mes int, 
    ano int,
    distancia int, 
    horas int, 
    minutos int, 
    segundos int,
    PRIMARY KEY(id)
);

--Insere Eventos
INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (1,"Poa Day Run",22,5,2019,5,0,35,32);
INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (2,"Poa Night Run",12,6,2019,5,0,31,10);
INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (3,"Winter Day Run",9,7,2019,5,0,29,17);
INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (4,"Summer Night Run",18,12,2019,5,0,32,25);