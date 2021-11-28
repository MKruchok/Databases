SELECT ship, 
	(SELECT classes.country FROM ships JOIN classes ON outcomes.ship = ships.name AND ships.class = classes.class)  AS country
FROM outcomes
WHERE result="sunk" AND (SELECT ships.name FROM ships WHERE outcomes.ship = ships.name) IS NOT NULL;