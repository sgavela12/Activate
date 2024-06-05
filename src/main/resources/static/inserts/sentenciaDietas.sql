-- Insertar dietas en la tabla 'dieta'
INSERT INTO dieta (objetivo, calorias_totales, tipo_alimento, descripcion) VALUES
(1, 2000, 'VEGANO', 'Energía Vegana'),
(2, 1800, 'VEGANO', 'Vitalidad Verde'),
(3, 2200, 'VEGANO', 'Fuerza Plant-Based'),
(1, 2100, 'VEGETARIANO', 'Rendimiento Vegetariano'),
(2, 1900, 'VEGETARIANO', 'Salud Vegetariana'),
(3, 2300, 'VEGETARIANO', 'Nutrición Verdadera'),
(1, 2500, 'CARNIVORO', 'Potencia Proteica'),
(2, 2400, 'CARNIVORO', 'Energía Carnívora'),
(3, 2600, 'CARNIVORO', 'Fuerza Animal'),
(1, 2000, 'VEGANO', 'Equilibrio Vegano'),
(2, 1800, 'VEGANO', 'Esencia Vegana'),
(3, 2200, 'VEGANO', 'Poder Plant-Based'),
(1, 2100, 'VEGETARIANO', 'Bienestar Vegetariano'),
(2, 1900, 'VEGETARIANO', 'Equilibrio Vegetariano'),
(3, 2300, 'VEGETARIANO', 'Frescura Vegetariana');

-- Insertar las relaciones entre dietas y alimentos en la tabla 'dieta_alimento'
-- Dieta 1: Energía Vegana
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(1, 1), (1, 2), (1, 3);

-- Dieta 2: Vitalidad Verde
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(2, 4), (2, 5), (2, 6);

-- Dieta 3: Fuerza Plant-Based
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(3, 7), (3, 8), (3, 9);

-- Dieta 4: Rendimiento Vegetariano
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(4, 37), (4, 38), (4, 39);

-- Dieta 5: Salud Vegetariana
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(5, 40), (5, 41), (5, 42);

-- Dieta 6: Nutrición Verdadera
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(6, 43), (6, 44), (6, 45);

-- Dieta 7: Potencia Proteica
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(7, 61), (7, 62), (7, 63);

-- Dieta 8: Energía Carnívora
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(8, 64), (8, 65), (8, 66);

-- Dieta 9: Fuerza Animal
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(9, 67), (9, 68), (9, 69);

-- Dieta 10: Equilibrio Vegano
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(10, 10), (10, 11), (10, 12);

-- Dieta 11: Esencia Vegana
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(11, 13), (11, 14), (11, 15);

-- Dieta 12: Poder Plant-Based
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(12, 16), (12, 17), (12, 18);

-- Dieta 13: Bienestar Vegetariano
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(13, 46), (13, 47), (13, 48);

-- Dieta 14: Equilibrio Vegetariano
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(14, 49), (14, 50), (14, 51);

-- Dieta 15: Frescura Vegetariana
INSERT INTO dieta_alimento (id_dieta, id_alimento) VALUES
(15, 52), (15, 53), (15, 54);
