
-- -----------------------------------------------------
-- Table cat_ingreso
-- -----------------------------------------------------

DROP TABLE  pasivo ;
DROP TABLE  activo ;
DROP TABLE  ingreso ;
DROP TABLE  egreso ;
DROP TABLE  AhorroUsuario ;
DROP TABLE  cat_ingreso ;
DROP TABLE  cat_egreso ;
DROP TABLE  meta ;
DROP TABLE  consejos ;
DROP TABLE  usuario ;


CREATE TABLE cat_ingreso (
  idcat_ingreso INT NOT NULL,
  cat_ingreso VARCHAR(45) NOT NULL,
  PRIMARY KEY (idcat_ingreso));
  
  INSERT INTO cat_ingreso VALUES(1, 'Fijo');
  INSERT INTO cat_ingreso VALUES(2,'Variable'); 

-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------

CREATE TABLE usuario (
  emailUsuario VARCHAR(45) NOT NULL,
  nombres VARCHAR(45) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  fecha_Nacimiento DATE NOT NULL,
  contraseña VARCHAR(45) NOT NULL,
  PRIMARY KEY (emailUsuario));

-- -----------------------------------------------------
-- Table ingreso
-- -----------------------------------------------------

CREATE TABLE ingreso (
  idIngreso SERIAL,
  nombreIngreso VARCHAR(45) NOT NULL,
  fechaIngreso DATE NOT NULL,
  valorIngreso FLOAT NOT NULL,
  descripcion VARCHAR(45) NOT NULL,
  estadoIngreso VARCHAR(45) NULL DEFAULT 'PENDIENTE',
  cat_ingreso_idcat_ingreso INT NOT NULL,
  usuario_emailUsuario VARCHAR(45) NOT NULL,
  PRIMARY KEY (idIngreso), 
  CONSTRAINT fk_ingreso_cat_ingreso FOREIGN KEY (cat_ingreso_idcat_ingreso) REFERENCES cat_ingreso (idcat_ingreso),
  CONSTRAINT fk_ingreso_usuario1 FOREIGN KEY (usuario_emailUsuario) REFERENCES usuario (emailUsuario));

-- -----------------------------------------------------
-- Table cat_egreso
-- -----------------------------------------------------

CREATE TABLE cat_egreso (
  idcat_egreso INT NOT NULL,
  cat_egreso VARCHAR(45) NOT NULL,
  PRIMARY KEY (idcat_egreso));
  
  INSERT INTO cat_egreso VALUES(1, 'Fijo');
  INSERT INTO cat_egreso VALUES(2,'Variable'); 

-- -----------------------------------------------------
-- Table egreso
-- -----------------------------------------------------

CREATE TABLE egreso (
  idEgreso SERIAL, 
  nombreEgreso VARCHAR(45) NOT NULL,
  fechaEgreso DATE NOT NULL,
  descripcion VARCHAR(45) NOT NULL,
  estadoEgreso VARCHAR(45) NULL DEFAULT 'PENDIENTE',
  valorEgreso FLOAT NOT NULL,
  idPrioridad INT NOT NULL,
  cat_egreso_idcat_egreso INT NOT NULL,
  usuario_emailUsuario VARCHAR(45) NOT NULL,
  PRIMARY KEY (idEgreso),
  CONSTRAINT fk_egreso_cat_egreso1 FOREIGN KEY (cat_egreso_idcat_egreso) REFERENCES cat_egreso (idcat_egreso),
  CONSTRAINT fk_egreso_usuario1 FOREIGN KEY (usuario_emailUsuario) REFERENCES usuario (emailUsuario));

-- -----------------------------------------------------
-- Table pasivo
-- -----------------------------------------------------

CREATE TABLE pasivo (
  idPasivo SERIAL, 
  nombrePasivo VARCHAR(45) NOT NULL,
  fechaPasivo DATE NOT NULL,
  usuario_emailUsuario VARCHAR(45) NOT NULL,
  descripcion VARCHAR(45) NOT NULL,
  valorpPasivo FLOAT NOT NULL,
  estadoPasivo VARCHAR(45) NULL DEFAULT 'ACTIVO',
  idEgreso INT NOT NULL, 
  PRIMARY KEY (idPasivo), 
  CONSTRAINT fk_pasivo_usuario1 FOREIGN KEY (usuario_emailUsuario) REFERENCES usuario (emailUsuario),
  CONSTRAINT fk_pasivo_egreso1 FOREIGN KEY (idEgreso) REFERENCES egreso (idEgreso));

-- -----------------------------------------------------
-- Table activo
-- -----------------------------------------------------

CREATE TABLE activo (
  idActivo SERIAL, 
  nombreActivo VARCHAR(45) NOT NULL,
  fechaActivo DATE NOT NULL,
  descripcion VARCHAR(45) NOT NULL,
  valoractivo FLOAT NOT NULL,
  estadoActivo VARCHAR(45) NULL DEFAULT 'ACTIVO',
  usuario_emailUsuario VARCHAR(45) NOT NULL,
  idIngreso INT NOT NULL, 
  PRIMARY KEY (idActivo),
  CONSTRAINT fk_activo_usuario1 FOREIGN KEY (usuario_emailUsuario) REFERENCES usuario (emailUsuario),
  CONSTRAINT fk_activo_ingreso1 FOREIGN KEY (idIngreso) REFERENCES ingreso (idIngreso));

-- ----------------------------------------------------
-- Table meta
-- -----------------------------------------------------

CREATE TABLE meta (
  idMeta SERIAL, 
  nombreMeta VARCHAR(45) NOT NULL,
  fechaInicio DATE NOT NULL,
  fechFfin DATE NOT NULL,
  valorMeta FLOAT NOT NULL,
  descripcion VARCHAR(45) NOT NULL,
  estadoMeta VARCHAR(45) NULL DEFAULT 'PENDIENTE',
  priordad INT NOT NULL,
  usuario_emailUsuario VARCHAR(45) NOT NULL,
  PRIMARY KEY (idMeta),
  CONSTRAINT fk_objetivo_usuario1 FOREIGN KEY (usuario_emailUsuario) REFERENCES usuario (emailUsuario));

-- -----------------------------------------------------
-- Table consejos
-- -----------------------------------------------------

CREATE TABLE consejos (
  idconsejos SERIAL,
  consejo VARCHAR(500) NOT NULL,
  categoriaConsejo VARCHAR(45) NOT NULL,
  PRIMARY KEY (idconsejos));

INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Fíjese una meta. Una vez establecida esta prioridad, será necesario elegir a qué se le quita para ponerle recursos al objetivo.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Ahorrar. Aunque suene repetitivo, es el primer ingrediente necesario.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Haga un presupuesto. Anote los gastos frente a los ingresos que tiene, de manera que pueda ir suprimiendo lo innecesario.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Fondo de emergencias. Para evitar que un imprevisto le golpee la bolsa del ahorro, abra también otro bolsillo para emergencias.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Crédito responsable. La tarjeta de crédito es útil, pero manejada con responsabilidad. Efectue el pago antes de la fecha de corte para que este no le genere intereses.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Edúcate, tómate el tiempo para leer acerca de finanzas personales. Cuanto más sepas acerca de tus propias finanzas, mayor confianza tendrás al administrar tu dinero en el largo plazo.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Construye tu propio colchón, esto te permite usar el dinero para pagar gastos no planeados o emergencias, en lugar de incrementar tu deuda o invertir a largo plazo.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Es conveniente que tengas un colchón de seis a 12 meses de tus gastos fijos. Éste te permitirá pagar cuentas personales y no preocuparte si necesitas reducir tus ingresos.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Invierte, poner a producir lo que se ahorra es otra de las recomendaciones del experto en finanzas personales. ', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('No sobra generar ingresos extras. No solo para obtener más recursos que apalanquen su proyecto financiero en este año, sino también para tener un plan B por si en esta ola pierde su empleo o no le incrementan mucho el salario.', 'MEDIA');
INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('Sé constante, el secreto de las finanzas personales sanas es la constancia. Todos los puntos no se logran de un día para otro', 'MEDIA');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');
-- INSERT INTO consejos(consejo, categoriaConsejo) VALUES ('', '');

-- -----------------------------------------------------
-- Table AhorroUsuario
-- -----------------------------------------------------

CREATE TABLE AhorroUsuario (
  idAhorroUsuario SERIAL,
  valorAhorro FLOAT NOT NULL,
  usuario_emailUsuario VARCHAR(45) NOT NULL,
  PRIMARY KEY (idAhorroUsuario),
  CONSTRAINT fk_AhorroUsuario_usuario1 FOREIGN KEY (usuario_emailUsuario) REFERENCES usuario (emailUsuario));


