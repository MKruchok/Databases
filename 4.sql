SELECT maker
FROM product LEFT JOIN pc ON  pc.model = product.model
WHERE type="PC" 
GROUP BY maker
	HAVING COUNT(pc.model) = 0;