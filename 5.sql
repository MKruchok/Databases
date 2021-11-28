SELECT DISTINCT maker
FROM product 
WHERE EXISTS (
	SELECT all_products.maker 
	FROM product AS all_products LEFT JOIN pc ON pc.model = all_products.model 
	WHERE type = "PC" AND product.maker = all_products.maker
	GROUP BY maker 
	 HAVING COUNT(DISTINCT all_products.model) = COUNT(DISTINCT pc.model))
ORDER BY maker;