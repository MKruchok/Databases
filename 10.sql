SELECT type, product.model, MAX(price) AS max_price
FROM (SELECT model, price 
	FROM pc
    UNION SELECT model, price
    FROM printer
    UNION SELECT model, price
    FROM laptop) AS product_any JOIN product ON product_any.model = product.model
GROUP BY product.model