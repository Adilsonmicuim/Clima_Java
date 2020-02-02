
--DELETE FROM TB_pluviometria WHERE id_pluviometria >= 1;

SELECT AVG(qtidade_chuva) FROM TB_pluviometria;
SELECT SUM(qtidade_chuva) FROM  TB_pluviometria;


---********** RETORNA O "ANO SOLICITADO" E CONCATENA MÊS(PT-BR) COM ANO E A COLUNA id_cliente **********
SELECT
extract(month FROM data_pluviometria) AS mes_num,
to_char(data_pluviometria, 'TMMonth "/" YYYY') AS mes, id_cliente,
count(qtidade_chuva) AS  dias_com_chuva
--avg (qtidade_chuva) AS  media_de_chuva
--sum(qtidade_chuva) AS  total_de_chuva
FROM TB_pluviometria
WHERE extract(year FROM data_pluviometria) = 2018 AND id_cliente = 1
GROUP BY mes_num, mes, id_cliente
ORDER BY mes_num;

---**************************** RESULTADO POR ANO (dias com chuva, média ou total mm *****************************************
SELECT 
extract(YEAR from data_pluviometria) AS ano,
count(qtidade_chuva) AS  dias_com_chuva
--avg (qtidade_chuva) AS  media_de_chuva
--sum(qtidade_chuva) AS  totam_de_chuva
FROM TB_pluviometria
WHERE extract(year from data_pluviometria) = 2018 AND id_cliente = 1
GROUP BY ano
ORDER BY ano DESC;

---*************************** RESULTADO POR MÊS (dias com chuva, média ou total mm *****************************************
SELECT 
extract(YEAR from data_pluviometria) AS ano,
count(qtidade_chuva) AS  dias_com_chuva
--avg (qtidade_chuva) AS  media_de_chuva
--sum(qtidade_chuva) AS  totam_de_chuva
FROM TB_pluviometria
WHERE extract(month from data_pluviometria) = 02 /*definir mês*/  and id_cliente = 01 /*definir ID da empresa*/
GROUP BY ano
ORDER BY ano DESC;

---************** RETORNA DATA, QTIDADE CHUVA, id_cliente, "MÊS SOLICITADO" E ANO ****************
SELECT
    data_pluviometria, qtidade_chuva, id_cliente,
    Extract (Month from data_pluviometria) mes,
    Extract (Year from data_pluviometria) ano
from TB_pluviometria
WHERE 
    extract(year FROM data_pluviometria) = 2018 AND
    extract(month from data_pluviometria) = 01 /*definir mês*/ AND id_cliente = 01  /*definir ID da empresa*/
ORDER BY data_pluviometria DESC;
--ORDER BY data_pluviometria ASC;


---*************************** Maior e Menor do mês solicitado *******************************************
SELECT 
extract(MONTH from data_pluviometria) AS mes, 
Max(qtidade_chuva) AS maior_chuva,
Min(qtidade_chuva) AS menor_chuva
FROM TB_pluviometria
WHERE extract(month from data_pluviometria) = 02 /*definir mês*/  and id_cliente = 01 /*definir ID da empresa*/
GROUP BY mes
ORDER BY mes DESC;

