SELECT pc.model, pc.speed, pc.hd FROM PC
INNER JOIN product
ON pc.model=product.model
WHERE pc.hd = 10 AND maker='A' OR pc.hd = 20 AND maker='A'
ORDER BY pc.speed;