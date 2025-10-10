INSERT INTO category (price, type, distance)
SELECT 100, 'FIVE_KM', 5
    WHERE NOT EXISTS (SELECT 1 FROM category WHERE type = 'FIVE_KM');

INSERT INTO category (price, type, distance)
SELECT 200, 'TEN_KM', 10
    WHERE NOT EXISTS (SELECT 1 FROM category WHERE type = 'TEN_KM');

INSERT INTO category (price, type, distance)
SELECT 300, 'HALF_MARATHON', 21
    WHERE NOT EXISTS (SELECT 1 FROM category WHERE type = 'HALF_MARATHON');

INSERT INTO category (price, type, distance)
SELECT 500, 'MARATHON', 42
    WHERE NOT EXISTS (SELECT 1 FROM category WHERE type = 'MARATHON');
