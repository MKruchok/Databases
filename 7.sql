SELECT maker
FROM product LEFT JOIN pc ON pc.model = product.model
WHERE type="PC"
GROUP BY maker
	HAVING COUNT(DISTINCT pc.model) BETWEEN 1 AND COUNT(DISTINCT product.model) - 1; 