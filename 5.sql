SELECT maker
FROM product 
WHERE EXISTS (
	SELECT maker
	FROM product AS all_products LEFT JOIN pc ON pc.model = all_products.model 
	WHERE type = "PC" AND product.maker = all_products.maker
	GROUP BY maker 
	 HAVING COUNT(all_products.model) = COUNT(pc.model))
GROUP BY maker;
