INSERT INTO regions (id, name) VALUES (1, 'Sudamérica');
INSERT INTO regions (id, name) VALUES (2, 'Centroamérica');
INSERT INTO regions (id, name) VALUES (3, 'Norteamérica');
INSERT INTO regions (id, name) VALUES (4, 'Europa');
INSERT INTO regions (id, name) VALUES (5, 'Asia');
INSERT INTO regions (id, name) VALUES (6, 'Africa');
INSERT INTO regions (id, name) VALUES (7, 'Oceanía');
INSERT INTO regions (id, name) VALUES (8, 'Antártida');




INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Espada laser', 'Evaluar la fabricacion de una espada laser ', '2018-01-02','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Funciones lineales', 'Introduccion a las funciones lineales', '2020-6-24','Matematicas','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(2,'Mini prusa', 'Puesta en marcha impresora 3d mini prusa', '2020-03-21','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(3,'Molde para maceta octogeo', 'Diseño Cad', '2020-10-4','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(4,'Mascarilla Covid-19', 'Desarrollo y produccion de mascarillas',  '2020-4-6','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(5,'Clon chino prusa', 'Armado del clon chino prusa', '2021-3-1','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(6,'Reconocimiento de imagenes', 'Evaluar el uso del procesador K210 con AI', '2020-12-18','Inteligencia artificial','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(7,'Repuesto para piano', 'Prueba del prototipo del repuesto para piano',  '2021-3-4','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(8,'Software y App', 'Uso de lenguajes python, java, Js(react, Vue)',  '2022-3-22','Programacion','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Viga simplemente apoyada', 'Proyecto final universitario',  '2021-11-13','Integrador','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Remote Lab Lib', 'Practica profesional supervisada universitaria',  '2022-4-3','Electronica-Software','educacion.ta@gmail.com');


/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO `roles` (nombre) VALUES ('ROLE_USER');
INSERT INTO `roles` (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `usuarios_roles` (usuario_id, role_id) VALUES (2, 1);

/* Populate tabla productos */
INSERT INTO products (name, price, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO products (name, price, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());
INSERT INTO products (name, price, create_at) VALUES('Filamento 3d Grillon', 2132, NOW());
INSERT INTO products (name, price, create_at) VALUES('Arduino micro pro', 1957, NOW());
INSERT INTO products (name, price, create_at) VALUES('Ender 3 pro', 60000, NOW());
INSERT INTO products (name, price, create_at) VALUES('Calculadora cientifica', 4000, NOW());



/* Creamos algunos videos */
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Primera prueba de concepto, actuadores', null,'HFA5eG5oFfI', 1, NOW());
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Factor de forma', null,'6TN32ScyAdM', 1, NOW());
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Espada laser manual simple', null,'gCHAfXRa3KY', 1, NOW());

INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 1, 8);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(2, 2, 9);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 3, 10);


INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Funciones Lineales primera parte', null,'7yoWHXHcRhE', 2, NOW());
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Funciones Lineales segunda parte', null,'A43oZ4I5HF0', 2, NOW());

INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 4, 11);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 5, 11);

