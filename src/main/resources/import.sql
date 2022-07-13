INSERT INTO regions (id, name) VALUES (1, 'Sudamérica');
INSERT INTO regions (id, name) VALUES (2, 'Centroamérica');
INSERT INTO regions (id, name) VALUES (3, 'Norteamérica');
INSERT INTO regions (id, name) VALUES (4, 'Europa');
INSERT INTO regions (id, name) VALUES (5, 'Asia');
INSERT INTO regions (id, name) VALUES (6, 'Africa');
INSERT INTO regions (id, name) VALUES (7, 'Oceanía');
INSERT INTO regions (id, name) VALUES (8, 'Antártida');




INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Espada laser', 'Evaluar la fabricacion de una espada laser ', '2018-01-02','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(8,'Software y App', 'Uso de lenguajes python, java, Js(react, Vue)',  '2022-3-22','Programacion','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Viga simplemente apoyada', 'Proyecto final universitario',  '2021-11-13','Electronnica-Sistemas-Mecanica','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Remote Lab Lib', 'Practica profesional supervisada universitaria',  '2022-4-3','Electronica-Sistemas','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(1,'Funciones lineales', 'Introduccion a las funciones lineales', '2020-6-24','Matematicas','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(2,'Mini prusa', 'Puesta en marcha impresora 3d mini prusa', '2020-03-21','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(3,'Molde para maceta octogeo', 'Diseño Cad', '2020-10-4','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(4,'Mascarilla Covid-19', 'Desarrollo y produccion de mascarillas',  '2020-4-6','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(5,'Clon chino prusa', 'Armado del clon chino prusa', '2021-3-1','Impresion 3d','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(6,'Reconocimiento de imagenes', 'Evaluar el uso del procesador K210 con AI', '2020-12-18','Inteligencia artificial','educacion.ta@gmail.com');
INSERT INTO proyects (region_id, name, intention,  create_at, technology, email ) VALUES(7,'Repuesto para piano', 'Prueba del prototipo del repuesto para piano',  '2021-3-4','Impresion 3d','educacion.ta@gmail.com');



/* Creamos algunos usuarios con sus roles */
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('user','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1, 'Pablo', 'tis','pablo@gmail.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1, 'German', 'Yaku','german@gmail.com');

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
/* A partir de aca Id=8  */
INSERT INTO products (name, price, create_at) VALUES('Filamento 3d Grillon', 2132, NOW());
INSERT INTO products (name, price, create_at) VALUES('Arduino micro pro', 1957, NOW());
INSERT INTO products (name, price, create_at) VALUES('Ender 3 pro', 60000, NOW());
/*Id=11*/
INSERT INTO products (name, price, create_at) VALUES('Calculadora cientifica', 4000, NOW());
INSERT INTO products (name, price, create_at) VALUES('Led High Power 5w Blanco', 261, NOW());
INSERT INTO products (name, price, create_at) VALUES('Protoboard Breadboard 830', 1186, NOW());
INSERT INTO products (name, price, create_at) VALUES('Original Prusa mini', 210000, NOW());
INSERT INTO products (name, price, create_at) VALUES('China clon Prusa', 150000, NOW());
/*Id=16*/
INSERT INTO products (name, price, create_at) VALUES('yahboom k210', 10000, NOW());
INSERT INTO products (name, price, create_at) VALUES('Filamento flexible Printalot', 2525, NOW());
INSERT INTO products (name, price, create_at) VALUES('Arduino Mega ', 2600, NOW());



/* Video 1 2 a 5 asignado al proyecto 1*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Primera prueba de concepto, actuadores', null,'HFA5eG5oFfI', 1, NOW()); /*video 1*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Factor de forma', null,'6TN32ScyAdM', 1, NOW());/*video 2*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Espada laser manual simple', null,'gCHAfXRa3KY', 1, NOW());/*video 3*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Muestra del manejo de la espada laser simple', 'Un niño de 6 años maneja el sable laser','1vjQE8cIPW8', 1, NOW());/*video 4*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Finalizacion de la primera etapa del prototipo', 'Revision del proyecto','uWwBc_w20BU', 1, NOW());/*video 5*/
/* Productos asignados a los videos 1 2 y 5 del proyecto 1*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 1, 8);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(2, 2, 9); 
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 3, 10);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 4, 12);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 5, 13);

/* Video 6 a 10 asignado al proyecto 2*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Aplicación web: Visualización de clima por ciudades.', 'JS-Java','cpZJHLjwSWA', 2, NOW());/*video 6*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Herramientas de educacion, aplicacion para Android.', 'Java','CWIGXTgUmb8', 2, NOW());/*video 7*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Investigación sobre el uso de Argon2 y Jwt', null,'GJMszumuEZE', 2, NOW());/*video 8*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Uso de xml_datetime.', 'python','m4iIyVHxlkk', 2, NOW());/*video 9*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Uso de Redux en React para un sistema de login', 'Documentacion','MulHLe16pbk', 2, NOW());/*video 10*/ 
/* Productos asignados a los videos 6 a 10 del proyecto 2*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 6, 4);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 7, 4);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 8, 4);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 9, 4);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 10, 4);




/* Video 11 asignado al proyecto 3*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Laboratorio remoto: Ensayo viga simplemente apoyada', 'demostracion de uso','5dQEUtAvH4g', 3, NOW());/*video 12*/
/* Productos asignados a los videos 11 del proyecto 3*/
/*no hay*/



/* Video 12 a 16 asignado al proyecto 4*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Intencion del proyecto RemoteLab-LIb Arduino', null,'-bFDZmKrt8A', 4, NOW());/*video 12*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Instalación remote-lab-lib-server', null,'1yOAjkrFG60', 4, NOW());/*video 13*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Instalación remote-lab-lib cliente', null,'YBdZcPlF0k8', 4, NOW());/*video 14*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Remote-lab-lib experimento del usuario', null,'U23sJfh_hjU', 4, NOW());/*video 15*/
INSERT INTO videos (description,observation, video_url,proyect_id, create_at) VALUES('Mui-Mensajes de información', null,'sl_B5fnXQtA', 4, NOW());/*video 16*/ 
/* Productos asignados a los videos 12 a 16 del proyecto 4*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 12, 18);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 13, 18);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 14, 18);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 15, 18);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 16, 18);

/* Video  17 y 18 asignado al proyecto 5*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Funciones Lineales primera parte', null,'7yoWHXHcRhE', 5, NOW());/*video 17*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Funciones Lineales segunda parte', null,'A43oZ4I5HF0', 5, NOW());/*video 18*/
/* Productos asignados a los videos 19 y 20 del proyecto 2*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 17, 11);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 18, 11);


/* Video 19 a 21  asignado al proyecto 6 MINI PRUSA*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Puesta en marcha primera parte', null,'Yyq28T_-ID4', 6, NOW());/*video 19*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Puesta en marcha segunda parte', null,'eBrTooS_cO4', 6, NOW());/*video 20*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Puesta en marcha tercera parte', null,'VwcmZQJGKG8', 6, NOW());/*video 21*/
/* Productos asignados a los videos 19 y 21 del proyecto 3*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 19, 14);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 20, 14);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 21, 14);

/* Video 22 asignado al proyecto 7 Macetas Anana*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Macetas con forma de anana', null,'UHHe3CmBKT8', 7, NOW());/*video 22*/
/* Productos asignados al video 22 proyecto 7*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 22, 10);

/* Video 23 y 24 asignado al proyecto 8 Mascarilla covid*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Mascarillas covid-19', 'desarrollo-produccion-donacion','jBSjKzFEWL4', 8, NOW());/*video 23*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Armado de mascara covid19 con acetato', 'colocacion del acetato en la mascara','vlImfIExfr4', 8, NOW());/*video 24*/

/* Productos asignados al video 23 y 24  del proyecto 8*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 23, 8);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 24, 8);

/* Video 25 y 26 asignado al proyecto 9 Clon chino prusa*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Impresion de catana con pla', null,'0O3lzNnxY6A', 9, NOW());/*video 25*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Armado de clon', 'Se compro piezas por separado en china','QiOtYJUb-Jw', 9, NOW());/*video 26*/

/* Productos asignados al video 25 y 26  del proyecto 9*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 25, 15);
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 26, 15);

/* Video 27 asignado al proyecto 10 Inteligencia artificial*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Inteligencia artificial, implementación en el K210', 'Programado en C','f_KuYfBTmys', 10, NOW());/*video 27*/

/* Productos asignados al video 27 del proyecto 10*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 27, 16);

/* Video 28 asignado al proyecto 11 privia-120*/
INSERT INTO videos (description,observation, video_url, proyect_id, create_at) VALUES('Repuesto para  de teclas del privia120',null,'GYdw3DLLYdA', 11, NOW());/*video 28*/

/* Productos asignados al video 28 del proyecto 11*/
INSERT INTO videos_items (quantity, video_id, product_id) VALUES(1, 28, 17);

