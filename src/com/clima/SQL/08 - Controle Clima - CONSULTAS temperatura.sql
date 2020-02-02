

--DELETE FROM TB_temperatura WHERE id_temperatura >= 1;



---#######################  Média da temp_maxima e temp_minima  " CONCATENA MÊS E ANO" ######################
SELECT
extract(month FROM data_temperatura) AS mes_num,
to_char(data_temperatura, 'TMMonth "/" YYYY') AS mes, 
trunc(AVG(temp_maxima),3) AS media_temp_maxima,  --trunc não faz arredondamento, retornando 40.16
round(AVG(temp_minima),3) AS media_temp_minima   --round retorna 40.17
FROM tb_temperatura
WHERE extract(year FROM data_temperatura) = 2018 AND id_cliente = 1
GROUP BY mes_num, mes
ORDER BY mes_num;



---#######################  Ver registros de determinado mês e ano  ############################
SELECT
    id_temperatura, data_temperatura, temp_maxima, temp_minima, id_cliente,
    Extract (Month FROM data_temperatura) mes,
    Extract (Year FROM data_temperatura) ano
from TB_temperatura
WHERE extract(year FROM data_temperatura) = 2018 AND
      extract(month FROM data_temperatura) = 01 AND id_cliente = 1
--WHERE date_trunc('month', data_temperatura) = '2018-1-01'
ORDER BY data_temperatura ASC;


---#######################  Média da temp_maxima e temp_minima  ############################
SELECT 
date_part('month', data_temperatura) AS mes,
AVG(temp_maxima) AS media_temp_maxima,
AVG(temp_minima) AS media_temp_minima
FROM tb_temperatura
WHERE date_part('year', data_temperatura) = 2018 AND id_cliente = 1
GROUP BY mes
ORDER BY mes;



---#######################    Média da temp_maxima e temp_minima  " CONCATENA MÊS E ANO"  + id_cliente  #################
SELECT
extract(month FROM data_temperatura) AS mes_num,
to_char(data_temperatura, 'TMMonth "/" YYYY') AS mes, id_cliente,
AVG(temp_maxima) AS media_temp_maxima,
AVG(temp_minima) AS media_temp_minima
FROM tb_temperatura
WHERE extract(year FROM data_temperatura) = 2018 AND id_cliente = 1
GROUP BY mes_num, mes, id_cliente
ORDER BY mes_num;


---#######################    Temperatura maxima e a minima de cada mês  " CONCATENA MÊS E ANO"  + id_cliente  #################
SELECT
extract(month FROM data_temperatura) AS mes_num,
to_char(data_temperatura, 'TMMonth "/" YYYY') AS mes, id_cliente,
Max(temp_maxima) AS temp_maxima,
Min(temp_minima) AS temp_minima
FROM tb_temperatura
WHERE extract(year FROM data_temperatura) = 2018 AND id_cliente = 1
GROUP BY mes_num, mes, id_cliente 
ORDER BY mes_num;


---*************************** Máxima e Minima do mês solicitado *******************************************
SELECT 
extract(MONTH from data_temperatura) AS mes, 
Max(temp_maxima) AS temp_maxima,
Min(temp_minima) AS temp_minima
FROM tb_temperatura
WHERE extract(month from data_temperatura) = 02 /*definir mês*/  and id_cliente = 01 /*definir ID da empresa*/
GROUP BY mes
ORDER BY mes DESC;

