-- Insert de Features
INSERT INTO features (id, name) VALUES (null,'Cocina');
INSERT INTO features (id, name) VALUES (null,'Televisor');
INSERT INTO features (id, name) VALUES (null,'Aire acondicionado');
INSERT INTO features (id, name) VALUES (null,'Apto mascotas');
INSERT INTO features (id, name) VALUES (null,'Estacionamiento gratuito');
INSERT INTO features (id, name) VALUES (null,'Pileta');
INSERT INTO features (id, name) VALUES (null,'Wifi');

-- Insert de Categorys
INSERT INTO categories (id, title, description, url_img) VALUES (null, 'Hotel', '2 Hoteles', 'https://images.unsplash.com/photo-1566073771259-6a8506099945?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470');
INSERT INTO categories (id, title, description, url_img) VALUES (null, 'Apart-Hotel', '2 Apart-Hotels', 'https://images.unsplash.com/photo-1515263487990-61b07816b324?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470');
INSERT INTO categories (id, title, description, url_img) VALUES (null, 'Bed and Breakfast', '2 Bed and Breakfasts', 'https://images.unsplash.com/photo-1596394516093-501ba68a0ba6?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470');
INSERT INTO categories (id, title, description, url_img) VALUES (null, 'Casa o Chalet', '2 Casas o Chalets','https://images.unsplash.com/photo-1591825729269-caeb344f6df2?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070');

-- Insert de Cities
INSERT INTO cities (id, name, country_name) VALUES (null, 'Buenos Aires', 'Argentina');
INSERT INTO cities (id, name, country_name) VALUES (null, 'Bogota', 'Colombia');
INSERT INTO cities (id, name, country_name) VALUES (null, 'Mendoza', 'Argentina');
INSERT INTO cities (id, name, country_name) VALUES (null, 'Medellin', 'Colombia');

-- Insert de Policys
INSERT INTO policies_house_rules (id, description) VALUES (null, "Check-out: 10:00");
INSERT INTO policies_house_rules (id, description) VALUES (null, "No se permiten fiestas");
INSERT INTO policies_house_rules (id, description) VALUES (null, "No fumar");
INSERT INTO policies_house_rules (id, description) VALUES (null, "La limpieza de las habitaciones se realizan únicamente por la mañana hasta las 11:00");
INSERT INTO policies_house_rules (id, description) VALUES (null, "Los clientes deben minimizar el ruido de 22:00 a 09:00");
INSERT INTO policies_house_rules (id, description) VALUES (null, "Edad mínima para el check-in: 18");

INSERT INTO policies_health_security (id, description) VALUES (null, "Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus");
INSERT INTO policies_health_security (id, description) VALUES (null, "Detector de humo");
INSERT INTO policies_health_security (id, description) VALUES (null, "Depósito de seguridad");
INSERT INTO policies_health_security (id, description) VALUES (null, "Se han eliminado objetos compartidos como cartas, revistas, bolígrafos y papeles");
INSERT INTO policies_health_security (id, description) VALUES (null, "Hay kit de primeros auxilios");
INSERT INTO policies_health_security (id, description) VALUES (null, "Desinfectante de manos en el alojamiento y zonas importantes");

INSERT INTO policies_cancellation (id, description) VALUES (null, "Las condiciones de cancelación y de pago por adelantado pueden variar según el tipo de alojamiento.");
INSERT INTO policies_cancellation (id, description) VALUES (null, "Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.");
INSERT INTO policies_cancellation (id, description) VALUES (null, "Se deberán cancelar con más de 72 horas de antelación a la fecha de arribo al hotel para no tener penalidad.");
INSERT INTO policies_cancellation (id, description) VALUES (null, "Los cargos serán debitados de la tarjeta de crédito.");
INSERT INTO policies_cancellation (id, description) VALUES (null, "Las notificaciones de cancelación deberán ser efectuadas vía e-mail.");


-- Insert de Products
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Hermitege Hotel', 'En el corazon de San Telmo', 'Disfruta de una albergue inspirado en las pasiones de Buenos Aires.', "latitude0", "longitude0", "A 940m del centro", "address0",5, 1, 1);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Grand King Hotel', 'A dos cuadras de las mejores tiendas de Florida', 'El Grand King Hotel está a 2 calles de la estación de metro de Florida y de la popular calle Florida, donde hay un numerosas tiendas de regalos y de artículos de piel.', "latitude1", "longitude1", "A 1.5Km del centro", "address1", 9, 1, 1);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Marriott Hotel', 'Alójate en el corazón de Bogotá', 'El Bogotá Marriott Hotel ofrece habitaciones modernas, centro de fitness con spa, piscina cubierta alargada y jacuzzi. El hotel se sitúa en el distrito financiero de Bogotá, a 10 minutos en coche del aeropuerto internacional El Dorado. Las habitaciones están insonorizadas y tienen camas deluxe con ropa de cama de 300 hilos y colchón de plumas, conexión a internet de alta velocidad, TV de pantalla plana, soporte para iPod y escritorio.', "latitude2", "longitude2", "A 500m del centro", "address2", 6, 2, 2);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Expo Suites', 'Alójate en el corazón de Bogotá', 'El Expo Suites Parque Central Bavaria se encuentra en el distrito financiero de Bogotá. Presenta interiores modernos de color púrpura, decorados con orquídeas blancas, y ofrece habitaciones con WiFi gratuita. Las habitaciones del Expo Suites Parque Central Bavaria están decoradas en madera de caoba e incluyen ropa de cama de colores. Todas tienen TV LCD por cable y baños tipo spa de estilo contemporáneo.', "latitude3", "longitude3", "A 200m del centro", "address3", 4, 2, 2);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Park Hyatt', 'Alójate en el corazón de Bogotá', 'El Park Hyatt Mendoza Hotel, Casino & Spa, situado en un impresionante edificio frente a la Plaza Independencia, ofrece alojamiento de lujo en el centro de Mendoza. El establecimiento alberga spa, centro de fitness, casino, piscina y varios restaurantes.', "latitude4", "longitude4", "A 2Km del centro", "address4", 5, 3, 3);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Sheraton', 'Sorprendete de las hermosas vistas', 'El Sheraton es un hotel nuevo de 5 estrellas situado a pocos pasos de la Avenida San Martín. Ofrece un restaurante con vistas de 360 grados al centro de Mendoza y la cordillera de Los Andes. También cuenta con piscina cubierta y WiFi gratuita.', "latitude5", "longitude5", "A 3Km del centro", "address5", 3, 3, 3);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Gachishouse', 'Alójate en el corazón de Medellin', 'El Central Plaza está situado a 2 calles de la estación de metro de Ayurá, que ofrece fácil acceso a otras partes de Itagüí. Ofrece habitaciones modernas, restaurante, bañera de hidromasaje panorámica y conexión WiFi gratuita.', "latitude6", "longitude6", "A 5Km del centro", "address6", 7, 4, 4);
INSERT INTO products (id, name, description_title, description, latitude, longitude, reference, address, rating, category_id, city_id) VALUES (null, 'Byblos', 'Para disfrutar del aire libre', 'Los huéspedes podrán visitar los lugares de interés cultural de la ciudad, como la catedral Metropolitana, situada a 10 km, o disfrutar de un paseo por el jardín botánico, a solo 12 km. El Hotel alberga sala de juegos con billar. Está situado a 5 minutos en coche del centro comercial, mientras que el barrio El Poblado está a 10 minutos en coche. El Alcaraván dispone de aparcamiento privado gratuito.', "latitude7", "longitude7", "A 8Km del centro", "address7", 8, 4, 4);

-- Insert de Images principales
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod1', 'https://images.unsplash.com/photo-1618773928121-c32242e63f39?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 1);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod2', 'https://images.unsplash.com/photo-1559841644-08984562005a?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074', 2);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod3', 'https://images.unsplash.com/photo-1512918728675-ed5a9ecdebfd?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 3);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod4', 'https://images.unsplash.com/photo-1444201983204-c43cbd584d93?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 4);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod5', 'https://images.unsplash.com/photo-1527853787696-f7be74f2e39a?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 5);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod6', 'https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?ixlib=rb-1.2.1&raw_url=true&q=80&fm=jpg&crop=entropy&cs=tinysrgb&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 6);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod7', 'https://images.unsplash.com/photo-1482867899247-e295efdd8c1a?ixlib=rb-1.2.1&raw_url=true&q=80&fm=jpg&crop=entropy&cs=tinysrgb&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 7);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img1_prod8', 'https://images.unsplash.com/photo-1493809842364-78817add7ffb?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170', 8);

-- Insert de Images secundarias
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod1', 'https://images.unsplash.com/photo-1596701062351-8c2c14d1fdd0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 1);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod1', 'https://images.unsplash.com/photo-1519690889869-e705e59f72e1?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 1);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod1', 'https://images.unsplash.com/photo-1507652313519-d4e9174996dd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 1);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod1', 'https://images.unsplash.com/photo-1573052905904-34ad8c27f0cc?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80', 1);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod2', 'https://images.unsplash.com/photo-1529551739587-e242c564f727?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1632&q=80', 2);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod2', 'https://images.unsplash.com/photo-1590381105924-c72589b9ef3f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1471&q=80', 2);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod2', 'https://images.unsplash.com/photo-1562778612-e1e0cda9915c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 2);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod2', 'https://images.unsplash.com/photo-1578774204375-826dc5d996ed?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 2);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod3', 'https://images.unsplash.com/photo-1564540583246-934409427776?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1453&q=80', 3);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod3', 'https://images.unsplash.com/photo-1484101403633-562f891dc89a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1474&q=80', 3);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod3', 'https://images.unsplash.com/photo-1484154218962-a197022b5858?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1474&q=80', 3);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod3', 'https://images.unsplash.com/photo-1459789034005-ba29c5783491?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=938&q=80', 3);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod4', 'https://images.unsplash.com/photo-1555244162-803834f70033?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 4);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod4', 'https://images.unsplash.com/photo-1586798271654-0471bb1b0517?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=685&q=80', 4);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod4', 'https://images.unsplash.com/photo-1541358800921-39f1c44bdde8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1427&q=80', 4);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod4', 'https://images.unsplash.com/photo-1610527003928-47afd5f470c6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1472&q=80', 4);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod5', 'https://images.unsplash.com/photo-1614519745773-1838dc87c367?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 5);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod5', 'https://images.unsplash.com/photo-1504754524776-8f4f37790ca0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80', 5);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod5', 'https://images.unsplash.com/photo-1521783593447-5702b9bfd267?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=904&q=80', 5);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod5', 'https://images.unsplash.com/photo-1601000785686-c45240e25f25?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 5);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod6', 'https://images.unsplash.com/photo-1596194815712-2975c42363a9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=735&q=80', 6);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod6', 'https://images.unsplash.com/photo-1606214306048-a148c5942180?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80', 6);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod6', 'https://images.unsplash.com/photo-1596194789619-e0ff3e3f310a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=674&q=80', 6);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod6', 'https://images.unsplash.com/photo-1515094193635-40722cc342b3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 6);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod7', 'https://images.unsplash.com/photo-1583847268964-b28dc8f51f92?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 7);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod7', 'https://images.unsplash.com/photo-1523772354886-34a1dc2f72e7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=736&q=80', 7);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod7', 'https://images.unsplash.com/photo-1609241506098-80fc37c6325f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80', 7);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod7', 'https://images.unsplash.com/photo-1616046229478-9901c5536a45?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2080&q=80', 7);

INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img2_prod8', 'https://images.unsplash.com/photo-1592240989300-8673561d04b8?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 8);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img3_prod8', 'https://images.unsplash.com/photo-1493770348161-369560ae357d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80', 8);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img4_prod8', 'https://images.unsplash.com/photo-1609879937493-56540300d8cc?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80', 8);
INSERT INTO images (id, title, url_img, product_id) VALUES (null, 'img5_prod8', 'https://images.unsplash.com/photo-1613618948931-efbc3e6f9775?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80', 8);


-- Insert de relacion entre Products - Features
INSERT INTO products_features (product_id, feature_id) VALUES (1, 2);
INSERT INTO products_features (product_id, feature_id) VALUES (1, 3);
INSERT INTO products_features (product_id, feature_id) VALUES (1, 4);
INSERT INTO products_features (product_id, feature_id) VALUES (1, 5);

INSERT INTO products_features (product_id, feature_id) VALUES (2, 7);
INSERT INTO products_features (product_id, feature_id) VALUES (2, 2);
INSERT INTO products_features (product_id, feature_id) VALUES (2, 5);

INSERT INTO products_features (product_id, feature_id) VALUES (3, 1);
INSERT INTO products_features (product_id, feature_id) VALUES (3, 4);
INSERT INTO products_features (product_id, feature_id) VALUES (3, 7);
INSERT INTO products_features (product_id, feature_id) VALUES (3, 3);

INSERT INTO products_features (product_id, feature_id) VALUES (4, 6);
INSERT INTO products_features (product_id, feature_id) VALUES (4, 3);
INSERT INTO products_features (product_id, feature_id) VALUES (4, 4);

INSERT INTO products_features (product_id, feature_id) VALUES (5, 2);
INSERT INTO products_features (product_id, feature_id) VALUES (5, 3);
INSERT INTO products_features (product_id, feature_id) VALUES (5, 6);
INSERT INTO products_features (product_id, feature_id) VALUES (5, 4);

INSERT INTO products_features (product_id, feature_id) VALUES (6, 3);
INSERT INTO products_features (product_id, feature_id) VALUES (6, 4);
INSERT INTO products_features (product_id, feature_id) VALUES (6, 5);
INSERT INTO products_features (product_id, feature_id) VALUES (6, 2);

INSERT INTO products_features (product_id, feature_id) VALUES (7, 3);
INSERT INTO products_features (product_id, feature_id) VALUES (7, 2);
INSERT INTO products_features (product_id, feature_id) VALUES (7, 5);

INSERT INTO products_features (product_id, feature_id) VALUES (8, 4);
INSERT INTO products_features (product_id, feature_id) VALUES (8, 5);
INSERT INTO products_features (product_id, feature_id) VALUES (8, 7);


-- Insert relacion entre politicas policies_house_rules  y Porduct
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (1, 1);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (1, 3);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (1, 5);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (2, 2);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (2, 3);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (2, 4);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (3, 6);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (3, 1);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (3, 2);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (4, 3);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (4, 2);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (4, 5);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (5, 5);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (5, 2);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (5, 1);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (6, 6);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (6, 2);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (6, 4);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (7, 2);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (7, 3);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (7, 4);

INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (8, 3);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (8, 2);
INSERT INTO product_policies_house_rules (product_id, policies_house_rules_id) VALUES (8, 5);

-- Insert relacion entre politicas policies_health_security  y Porduct
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (1, 6);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (1, 3);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (1, 1);

INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (2, 1);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (2, 4);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (2, 3);

INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (3, 3);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (3, 4);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (3, 5);

INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (4, 3);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (4, 5);


INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (5, 1);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (5, 2);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (5, 3);

INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (6, 2);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (6, 3);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (6, 4);

INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (7, 3);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (7, 4);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (7, 6);

INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (8, 2);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (8, 4);
INSERT INTO product_policies_health_security (product_id, policies_health_security_id) VALUES (8, 3);

-- Insert relacion entre politicas policies_cancellation  y Porduct
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (1, 1);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (1, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (1, 5);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (2, 2);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (2, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (2, 5);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (3, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (3, 2);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (4, 5);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (4, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (4, 2);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (5, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (5, 1);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (5, 5);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (6, 4);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (6, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (6, 5);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (7, 4);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (7, 5);

INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (8, 2);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (8, 3);
INSERT INTO product_policies_cancellation (product_id, policies_cancellation_id) VALUES (8, 4);

-- Insert Roles
INSERT INTO roles (id, name) VALUES (null, "ADMIN");
INSERT INTO roles (id, name) VALUES (null, "USER");
INSERT INTO roles (id, name) VALUES (null, "CLIENT");

-- Insert Usuario
INSERT INTO users (id, name, last_name, mail, password, rol_id) VALUES (null, "admin", "admin", "admin@mail.com", "$2a$12$i.NB5/pkkCD/dPDQ9ce6g.i2xsjWVPI5H6EXLilZf8KDfDgQzRZlS", 1); -- password: Admin0621
-- INSERT INTO users (id, name, last_name, mail, password, rol_id) VALUES (null, "admin", "admin", "admin@mail.com", "$2a$12$vkPD9wtOxTpnKfF7ZxX90.6r/GX/n1LaQ/KpVN9Y.6vy0qEvFDZAm", 1); -- password: 9876

-- INSERT INTO users (id, name, last_name, mail, password, rol_id) VALUES (null, "user", "user", "user@mail.com", "$2a$12$QWW0qIUkkyxl4EXCJ0O.dOpI/bc2IOnM2e/JyykcgCSI3ow9V/Qqu", 2); -- password: 1234
INSERT INTO users (id, name, last_name, mail, password, rol_id) VALUES (null, "user", "user", "user@mail.com", "$2a$12$jqP5pnU7twrVjM/EVAfpkeoHnIUgDD4U3dLqMwUnvEV96pODtdhhG", 2); -- password: User0621
INSERT INTO users (id, name, last_name, mail, password, rol_id) VALUES (null, "client", "client", "client@mail.com", "$2a$12$fdA1y9qEygCeTyAhzmPymu9Si4jS6dZu7zlK3qld5LeKWP.seDKJ.", 3); -- password: 4567


