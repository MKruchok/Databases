SELECT maker,
       IF(product_pc=0, 'no', CONCAT('yes(', available_pc, ')')) AS creates_pc
FROM(SELECT maker, CASE WHEN product.type='PC' THEN 1 ELSE 0 END AS
    product_pc, COUNT(available_models.model) as available_pc
	FROM product 
	LEFT JOIN (SELECT model FROM pc) AS available_models ON
	    available_models.model = product.model
	GROUP BY maker) AS products_pc
ORDER BY maker;
