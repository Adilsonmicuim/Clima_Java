--DELETE FROM TB_endereco WHERE id_endereco >= 3;
--DELETE FROM TB_cidade WHERE id_cidade >= 3;
--DELETE FROM TB_estado WHERE id_estado >= 3;




-- Table TB_estado
---------------------------------------------id_estado, nome_estado, mesorregiao, UF
INSERT INTO TB_estado VALUES (01, 'Santa Catarina', 'Oeste Catarinense', 'SC');
--INSERT INTO TB_estado VALUES (02, 'Paraná', 'Sudoeste', 'PR');



-- Table TB_cidade
---------------------------------------------id_cidade, nome_cidade, id_estado
 INSERT INTO TB_cidade VALUES (01, 'Dionísio Cerqueira', 01);
 INSERT INTO TB_cidade VALUES (02, 'Marema', 01);




-- Table TB_endereco
---------------------------------------------id_endereco, rua, numero, id_cidade
INSERT INTO TB_endereco VALUES (01, null, null, 01);
INSERT INTO TB_endereco VALUES (02, null, null, 02);




-- Table TB_cliente
---------------------------------------------id_cliente, nome, sobrenome, situacao, id_endereco, id_login, id_estado 
INSERT INTO TB_cliente VALUES(01, 'Ivan', 'Mallmann', 'Ativo', 01, 01, 01);
INSERT INTO TB_cliente VALUES(02, 'Claudecir', 'Antonio Lunardi', 'Ativo', 02, 01, 01);





