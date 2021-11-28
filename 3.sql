SELECT maker
FROM product JOIN pc ON pc.model = product.model
GROUP BY maker 
	HAVING MIN(speed)>=600;