SELECT maker
FROM product LEFT JOIN pc ON pc.model = product.model
WHERE pc.model is null and type="PC"
GROUP BY maker;
