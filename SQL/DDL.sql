-- Zoológico de Hutziltepec: Definición de tablas.
-- Creación de Tablas del modelo relacional de la práctica 05. 
-- Equipo Los Excentos.

DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA public;

--------------------------------------------------------------------------------

CREATE TABLE Cliente (
    idCliente INT,
    nombre VARCHAR(50),
    aPaterno VARCHAR(50),
    aMaterno VARCHAR(50),
    nacimiento DATE,
    genero CHAR(1)
);

-- Restricciones Cliente

-- Dominio
ALTER TABLE Cliente ALTER COLUMN idCliente
SET NOT NULL;
ALTER TABLE Cliente ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Cliente ADD CONSTRAINT Cliente_d1
CHECK(nombre <> '');
ALTER TABLE Cliente ALTER COLUMN aPaterno
SET NOT NULL;
ALTER TABLE Cliente ADD CONSTRAINT Cliente_d2
CHECK(aPaterno <> '');
ALTER TABLE Cliente ALTER COLUMN aMaterno
SET NOT NULL;
ALTER TABLE Cliente ADD CONSTRAINT Cliente_d3
CHECK(aMaterno <> '');
ALTER TABLE Cliente ADD CONSTRAINT Cliente_d4
CHECK(nacimiento < CURRENT_DATE);
ALTER TABLE Cliente ADD CONSTRAINT Cliente_d5
CHECK(genero = 'M' OR genero  = 'F' OR genero = 'X');

-- Entidad
ALTER TABLE Cliente ADD CONSTRAINT Cliente_pkey
PRIMARY KEY (idCliente);

-- Comentarios
COMMENT ON TABLE Cliente IS 'Tabla para registrar a los clientes';
COMMENT ON COLUMN Cliente.idCliente IS 'Identificador del cliente';
COMMENT ON COLUMN Cliente.nombre IS 'Nombre del cliente';
COMMENT ON COLUMN Cliente.aPaterno IS 'Apellido paterno del cliente';
COMMENT ON COLUMN Cliente.aMaterno IS 'Apellido materno del cliente';
COMMENT ON COLUMN Cliente.nacimiento IS 'Fecha de nacimiento del cliente';
COMMENT ON COLUMN Cliente.genero IS 'Género del cliente';
COMMENT ON CONSTRAINT Cliente_pkey ON Cliente IS 'La llave primaria de la tabla Cliente va a ser su ID';
COMMENT ON CONSTRAINT Cliente_d1 ON Cliente IS 'Restricción para que nombre no sea la cadena vacia';
COMMENT ON CONSTRAINT Cliente_d2 ON Cliente IS 'Restricción para que el apellido paterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Cliente_d3 ON Cliente IS 'Restricción para que el apellido materno no sea la cadena vacia';
COMMENT ON CONSTRAINT Cliente_d4 ON Cliente IS 'Restricción para que nacimiento sea anterior de la fecha actual';
COMMENT ON CONSTRAINT Cliente_d5 ON Cliente IS 'Restricción para que genero sea un solo caracter M, F o X';

--------------------------------------------------------------------------------

CREATE TABLE EmailCliente (
    email VARCHAR(100),
    idCliente INT
);

-- Restricciones EmailCliente

-- Dominio
ALTER TABLE EmailCliente ALTER COLUMN email
SET NOT NULL;
ALTER TABLE EmailCliente ADD CONSTRAINT EmailCliente_d1
CHECK(email LIKE '%_@_%._%');

-- Entidad
ALTER TABLE EmailCliente ADD CONSTRAINT EmailCliente_pkey
PRIMARY KEY (email, idCliente);

-- Referencial
ALTER TABLE EmailCliente ADD CONSTRAINT EmailCliente_fkey
FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE EmailCliente IS 'Tabla que contiene a las direcciones de email de los clientes';
COMMENT ON COLUMN EmailCliente.idCliente IS 'Identificador del cliente';
COMMENT ON COLUMN EmailCliente.email IS 'Email del cliente';
COMMENT ON CONSTRAINT EmailCliente_d1 ON EmailCliente IS 'Restricción para que el email contenga al caracter @ y luego al .';
COMMENT ON CONSTRAINT EmailCliente_pkey ON EmailCliente IS 'La llave primaria se va a definir en términos del correo y el ID del cliente';
COMMENT ON CONSTRAINT EmailCliente_fkey ON EmailCliente IS 'La llave foránea de la tabla EmailCliente va a ser el ID del cliente';

--------------------------------------------------------------------------------

CREATE TABLE TelefonoCliente (
    telefono CHAR(10),
    idCliente INT
);

--Restricciones TelefonoCliente

-- Dominio
ALTER TABLE TelefonoCliente ALTER COLUMN telefono
SET NOT NULL;
ALTER TABLE TelefonoCliente ADD CONSTRAINT TelefonoCliente_d1
CHECK(telefono SIMILAR TO '[0-9]+');

-- Entidad
ALTER TABLE TelefonoCliente ADD CONSTRAINT TelefonoCliente_pkey
PRIMARY KEY (telefono, idCliente);

-- Referencial
ALTER TABLE TelefonoCliente ADD CONSTRAINT TelefonoCliente_fkey
FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON UPDATE CASCADE ON DELETE CASCADE;

---Comentarios
COMMENT ON TABLE TelefonoCliente IS 'Tabla que contiene a los telefonos de los clientes';
COMMENT ON COLUMN TelefonoCliente.idCliente IS 'Identificador del cliente';
COMMENT ON COLUMN TelefonoCliente.telefono IS 'Telefono del cliente';
COMMENT ON CONSTRAINT TelefonoCliente_d1 ON TelefonoCliente IS 'Restricción para que el teléfono solo tenga numeros';
COMMENT ON CONSTRAINT TelefonoCliente_pkey ON TelefonoCliente IS 'La llave primaria va a ser justamente el número de teléfono';
COMMENT ON CONSTRAINT TelefonoCliente_fkey ON TelefonoCliente IS 'La llave foránea de la tabla TelefonoCliente va a ser el ID  del cliente';

--------------------------------------------------------------------------------

CREATE TABLE Servicio (
    idServicio INT,
    tipo VARCHAR(50),
    costoUnitario FLOAT
);

--Restricciones Servicio

-- Dominio
ALTER TABLE Servicio ALTER COLUMN idServicio
SET NOT NULL;
ALTER TABLE Servicio ALTER COLUMN tipo
SET NOT NULL;
ALTER TABLE Servicio ALTER COLUMN costoUnitario
SET NOT NULL;
ALTER TABLE Servicio ADD CONSTRAINT Servicio_d1
CHECK(costoUnitario >= 0);
ALTER TABLE Servicio ADD CONSTRAINT Servicio_d2
CHECK(tipo = 'baño' OR tipo = 'tienda' OR tipo = 'comida');

-- Entidad
ALTER TABLE Servicio ADD CONSTRAINT Servicio_pkey
PRIMARY KEY (idServicio);

-- Comentarios
COMMENT ON TABLE Servicio IS 'Tabla de los servicios que se prestan en el zoológico';
COMMENT ON COLUMN Servicio.idServicio IS 'Identificador del servicio';
COMMENT ON COLUMN Servicio.tipo IS 'Tipo del servicio (Baño, tienda, comida)';
COMMENT ON COLUMN Servicio.costoUnitario IS 'Precio por unidad de prestación del servicio';
COMMENT ON CONSTRAINT Servicio_d1 ON Servicio IS 'Los precios deben estar en números positivos';
COMMENT ON CONSTRAINT Servicio_d2 ON Servicio IS 'Solo hay tres posibles valores para el tipo de servicio';
COMMENT ON CONSTRAINT Servicio_pkey ON Servicio IS 'La llave primaria va a ser el ID del servicio';

--------------------------------------------------------------------------------

CREATE TABLE Proveedor (
    RFCProveedor CHAR(13),
    nombre VARCHAR(50),
    aPaterno VARCHAR(50),
    aMaterno VARCHAR(50),
    nacimiento DATE,
    genero CHAR(1),
    calle VARCHAR (50),
    numExterior INT,
    numInterior INT,
    colonia VARCHAR(50),
    estado VARCHAR(50),
    inicioContrato DATE,
    finContrato DATE
);

-- Restricciones Proveedor

-- Dominio
ALTER TABLE Proveedor ALTER COLUMN RFCProveedor
SET NOT NULL;
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d1
CHECK(RFCProveedor SIMILAR TO '[A-Z]{4}[0-9]{6}([A-Z]|[0-9]){3}');
ALTER TABLE Proveedor ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d2
CHECK(nombre <> '');
ALTER TABLE Proveedor ALTER COLUMN aPaterno
SET NOT NULL;
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d3
CHECK(aPaterno <> '');
ALTER TABLE Proveedor ALTER COLUMN aMaterno
SET NOT NULL;
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d4
CHECK(aMaterno <> '');
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d5
CHECK(nacimiento < CURRENT_DATE);
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d6
CHECK(genero = 'M' OR genero  = 'F' OR genero = 'X');
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d7
CHECK(calle <> '');
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d8
CHECK(numExterior >= 1);
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d9
CHECK(numInterior > 0);
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d10
CHECK(colonia <> '');
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d11
CHECK(estado <> '');
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_d12
CHECK(inicioContrato <= CURRENT_DATE);

--Entidad
ALTER TABLE Proveedor ADD CONSTRAINT Proveedor_pkey
PRIMARY KEY (RFCProveedor);

-- Comentarios
COMMENT ON TABLE Proveedor IS 'Tabla que contiene a los proveedores';
COMMENT ON COLUMN Proveedor.RFCProveedor IS 'Identificador del proveedor';
COMMENT ON COLUMN Proveedor.nombre IS 'Nombre del proveedor';
COMMENT ON COLUMN Proveedor.aPaterno IS 'Apellido paterno del proveedor';
COMMENT ON COLUMN Proveedor.aMaterno IS 'Apellido materno del proveedor';
COMMENT ON COLUMN Proveedor.nacimiento IS 'Fecha de nacimiento del proveedor';
COMMENT ON COLUMN Proveedor.genero IS 'Genero del proveedor';
COMMENT ON COLUMN Proveedor.calle IS 'Calle de la direccion del proveedor';
COMMENT ON COLUMN Proveedor.numExterior IS 'Numero exterior de la direccion del proveedor';
COMMENT ON COLUMN Proveedor.numInterior IS 'Numero interior de la direccion del proveedor';
COMMENT ON COLUMN Proveedor.colonia IS 'Colonia de la direccion del proveedor';
COMMENT ON COLUMN Proveedor.estado IS 'Estado de la direccion del proveedor';
COMMENT ON COLUMN Proveedor.inicioContrato IS 'Fecha de inicio de contrato del proveedor';
COMMENT ON COLUMN Proveedor.finContrato IS 'Fecha de fin de contrato del proveedor';
COMMENT ON CONSTRAINT Proveedor_pkey ON Proveedor IS 'La llave primaria de la tabla Proveedor va a ser su RFC';
COMMENT ON CONSTRAINT Proveedor_d1 ON Proveedor IS 'Restricción para que RFCProveedor conste de 4 letras mayusculas al inicio, luego 6 numeros y por ultimo 3 letras o numeros';
COMMENT ON CONSTRAINT Proveedor_d2 ON Proveedor IS 'Restricción para que nombre no sea la cadena vacia';
COMMENT ON CONSTRAINT Proveedor_d3 ON Proveedor IS 'Restricción para que aPaterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Proveedor_d4 ON Proveedor IS 'Restricción para que aMaterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Proveedor_d5 ON Proveedor IS 'Restricción para que nacimiento sea anterior de la fecha actual';
COMMENT ON CONSTRAINT Proveedor_d6 ON Proveedor IS 'Restricción para que genero sea M, F o X';
COMMENT ON CONSTRAINT Proveedor_d7 ON Proveedor IS 'Restricción para que calle no sea la cadena vacia';
COMMENT ON CONSTRAINT Proveedor_d8 ON Proveedor IS 'Restricción para que numExterior sea mayor a cero';
COMMENT ON CONSTRAINT Proveedor_d9 ON Proveedor IS 'Restricción para que numInterior sea mayor a cero';
COMMENT ON CONSTRAINT Proveedor_d10 ON Proveedor IS 'Restricción para que colonia no sea la cadena vacia';
COMMENT ON CONSTRAINT Proveedor_d11 ON Proveedor IS 'Restricción para que estado no sea la cadena vacia';
COMMENT ON CONSTRAINT Proveedor_d12 ON Proveedor IS 'Restricción para que inicioContrato sea anterior o igual a la fecha actual';

--------------------------------------------------------------------------------

CREATE TABLE EmailProveedor(
    email VARCHAR(100),
    RFCProveedor CHAR(13)
);

-- Restricciones EmailProveedor

-- Dominio
ALTER TABLE EmailProveedor ALTER COLUMN email
SET NOT NULL;
ALTER TABLE EmailProveedor ADD CONSTRAINT EmailProveedor_d1
CHECK(email LIKE '%_@_%._%');

-- Entidad
ALTER TABLE EmailProveedor ADD CONSTRAINT EmailProveedor_pkey
PRIMARY KEY (email, RFCProveedor);

-- Referencial
ALTER TABLE EmailProveedor ADD CONSTRAINT EmailProveedor_fkey
FOREIGN KEY(RFCProveedor) REFERENCES Proveedor(RFCProveedor) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE EmailProveedor IS 'Tabla que contiene a los emails de los proveedores';
COMMENT ON COLUMN EmailProveedor.RFCProveedor IS 'Identificador del proveedor';
COMMENT ON COLUMN EmailProveedor.email IS 'Email del proveedor';
COMMENT ON CONSTRAINT EmailProveedor_d1 ON EmailProveedor IS 'Restricción para que el email contenga al caracter @ y luego al .';
COMMENT ON CONSTRAINT EmailProveedor_pkey ON EmailProveedor IS 'La llave primaria de la tabla EmailProveedor va a ser el email';
COMMENT ON CONSTRAINT EmailProveedor_fkey ON EmailProveedor IS 'La llave foránea de la tabla EmailProveedor va a ser el RFC del proveedor';

--------------------------------------------------------------------------------

CREATE TABLE TelefonoProveedor (
    telefono CHAR(10),
    RFCProveedor CHAR(13)
);

--Restricciones TelefonoProveedor

-- Dominio
ALTER TABLE TelefonoProveedor ALTER COLUMN telefono
SET NOT NULL;
ALTER TABLE TelefonoProveedor ADD CONSTRAINT TelefonoProveedor_d1
CHECK(telefono SIMILAR TO '[0-9]+');

-- Entidad
ALTER TABLE TelefonoProveedor ADD CONSTRAINT TelefonoProveedor_pkey
PRIMARY KEY (telefono, RFCProveedor);

-- Referencial
ALTER TABLE TelefonoProveedor ADD CONSTRAINT TelefonoProveedor_fkey
FOREIGN KEY(RFCProveedor) REFERENCES Proveedor(RFCProveedor) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE TelefonoProveedor IS 'Tabla que contiene a los telefonos de los proveedores';
COMMENT ON COLUMN TelefonoProveedor.RFCProveedor IS 'Identificador del provedor';
COMMENT ON COLUMN TelefonoProveedor.telefono IS 'Teléfono del cliente';
COMMENT ON CONSTRAINT TelefonoProveedor_d1 ON TelefonoProveedor IS 'Restricción para que telefono solo tenga numeros';
COMMENT ON CONSTRAINT TelefonoProveedor_pkey ON TelefonoProveedor IS 'La llave primaria de la tabla TelefonoProveedor va a ser el teléfono';
COMMENT ON CONSTRAINT TelefonoProveedor_fkey ON TelefonoProveedor IS 'La llave foránea de la tabla TelefonoProveedor va a ser el RFC del proveedor';

--------------------------------------------------------------------------------

CREATE TABLE Veterinario (
    RFCVeterinario CHAR(13),
    nombre VARCHAR(50),
    aPaterno VARCHAR(50),
    aMaterno VARCHAR(50),
    nacimiento DATE,
    genero CHAR(1),
    calle VARCHAR(50),
    numExterior INT,
    numInterior INT,
    colonia VARCHAR(50),
    estado VARCHAR(50),
    inicioContrato DATE,
    finContrato DATE,
    especialidad VARCHAR(100),
    salario FLOAT
);

-- Restricciones Veterinario

-- Dominio
ALTER TABLE Veterinario ALTER COLUMN RFCVeterinario
SET NOT NULL;
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d1
CHECK(RFCVeterinario SIMILAR TO '[A-Z]{4}[0-9]{6}([A-Z]|[0-9]){3}');
ALTER TABLE Veterinario ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d2
CHECK(nombre <> '');
ALTER TABLE Veterinario ALTER COLUMN aPaterno
SET NOT NULL;
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d3
CHECK(aPaterno <> '');
ALTER TABLE Veterinario ALTER COLUMN aMaterno
SET NOT NULL;
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d4
CHECK(aMaterno <> '');
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d5
CHECK(nacimiento < CURRENT_DATE);
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d6
CHECK(genero = 'M' OR genero  = 'F' OR genero = 'X');
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d7
CHECK(calle <> '');
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d8
CHECK(numExterior >= 1);
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d9
CHECK(numInterior >= 0);
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d10
CHECK(colonia <> '');
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d11
CHECK(estado <> '');
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d12
CHECK(inicioContrato <= CURRENT_DATE);
ALTER TABLE Veterinario ALTER COLUMN especialidad
SET NOT NULL;
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d13
CHECK(especialidad <> '');
ALTER TABLE Veterinario ALTER COLUMN salario
SET NOT NULL;
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_d14
CHECK(salario > 0.0);

-- Entidad
ALTER TABLE Veterinario ADD CONSTRAINT Veterinario_pkey
PRIMARY KEY (RFCVeterinario);

-- Comentarios
COMMENT ON TABLE Veterinario IS 'Tabla que contiene a los veterinarios';
COMMENT ON COLUMN Veterinario.RFCVeterinario IS 'Identificador del veterinario';
COMMENT ON COLUMN Veterinario.nombre IS 'Nombre del veterinario';
COMMENT ON COLUMN Veterinario.aPaterno IS 'Apellido paterno del veterinario';
COMMENT ON COLUMN Veterinario.aMaterno IS 'Apellido materno del veterinario';
COMMENT ON COLUMN Veterinario.nacimiento IS 'Fecha de nacimiento del veterinario';
COMMENT ON COLUMN Veterinario.genero IS 'Genero del veterinario';
COMMENT ON COLUMN Veterinario.calle IS 'Calle de la direccion del veterinario';
COMMENT ON COLUMN Veterinario.numExterior IS 'Numero exterior de la direccion del veterinario';
COMMENT ON COLUMN Veterinario.numInterior IS 'Numero interior de la direccion del veterinario';
COMMENT ON COLUMN Veterinario.colonia IS 'Colonia de la direccion del veterinario';
COMMENT ON COLUMN Veterinario.estado IS 'Estado de la direccion del veterinario';
COMMENT ON COLUMN Veterinario.inicioContrato IS 'Fecha de inicio de contrato del veterinario';
COMMENT ON COLUMN Veterinario.finContrato IS 'Fecha de fin de contrato del veterinario';
COMMENT ON COLUMN Veterinario.especialidad IS 'Especialidad del veterinario';
COMMENT ON COLUMN Veterinario.salario IS 'Salario del veterinario';
COMMENT ON CONSTRAINT Veterinario_pkey ON Veterinario IS 'La llave primaria de la tabla Veterinario va a ser su RFC';
COMMENT ON CONSTRAINT Veterinario_d1 ON Veterinario IS 'Restricción para que RFCVeterinario conste de 4 letras mayusculas al inicio, luego 6 numeros y por ultimo 3 letras o numeros';
COMMENT ON CONSTRAINT Veterinario_d2 ON Veterinario IS 'Restricción para que nombre no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d3 ON Veterinario IS 'Restricción para que aPaterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d4 ON Veterinario IS 'Restricción para que aMaterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d5 ON Veterinario IS 'Restricción para que nacimiento sea anterior de la fecha actual';
COMMENT ON CONSTRAINT Veterinario_d6 ON Veterinario IS 'Restricción para que genero sea M o F';
COMMENT ON CONSTRAINT Veterinario_d7 ON Veterinario IS 'Restricción para que calle no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d8 ON Veterinario IS 'Restricción para que numExterior sea mayor a cero';
COMMENT ON CONSTRAINT Veterinario_d9 ON Veterinario IS 'Restricción para que numInterior sea mayor a cero';
COMMENT ON CONSTRAINT Veterinario_d10 ON Veterinario IS 'Restricción para que colonia no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d11 ON Veterinario IS 'Restricción para que estado no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d12 ON Veterinario IS 'Restricción para que inicioContrato sea anterior o igual a la fecha actual';
COMMENT ON CONSTRAINT Veterinario_d13 ON Veterinario IS 'Restricción para que especialidad no sea la cadena vacia';
COMMENT ON CONSTRAINT Veterinario_d14 ON Veterinario IS 'Restricción para que salario sea mayor a cero';

--------------------------------------------------------------------------------

CREATE TABLE EmailVeterinario (
    email VARCHAR(100),
    RFCVeterinario CHAR(13)
);

-- Restricciones EmailVeterinario

-- Dominio
ALTER TABLE EmailVeterinario ALTER COLUMN email
SET NOT NULL;
ALTER TABLE EmailVeterinario ADD CONSTRAINT EmailVeterinario_d1
CHECK(email LIKE '%_@_%._%');

-- Entidad
ALTER TABLE EmailVeterinario ADD CONSTRAINT EmailVeterinario_pkey
PRIMARY KEY (email, RFCVeterinario);

-- Referencial
ALTER TABLE EmailVeterinario ADD CONSTRAINT EmailVeterinario_fkey
FOREIGN KEY(RFCVeterinario) REFERENCES Veterinario(RFCVeterinario) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE EmailVeterinario IS 'Tabla que contiene a los emails de los veterinarios';
COMMENT ON COLUMN EmailVeterinario.RFCVeterinario IS 'Identificador del veterinario';
COMMENT ON COLUMN EmailVeterinario.email IS 'email del veterinario';
COMMENT ON CONSTRAINT EmailVeterinario_d1 ON EmailVeterinario IS 'Restricción para que el email contenga al caracter @ y luego al .';
COMMENT ON CONSTRAINT EmailVeterinario_pkey ON EmailVeterinario IS 'La llave primaria de la tabla EmailVeterinario va a ser su email';
COMMENT ON CONSTRAINT EmailVeterinario_fkey ON EmailVeterinario IS 'La llave foránea de la tabla EmailVeterinario va a ser el RFC del veterinario';

--------------------------------------------------------------------------------

CREATE TABLE TelefonoVeterinario (
    telefono CHAR(10),
    RFCVeterinario CHAR(13)
);

-- Restricciones TelefonoVeterinario

-- Dominio
ALTER TABLE TelefonoVeterinario ALTER COLUMN telefono
SET NOT NULL;
ALTER TABLE TelefonoVeterinario ADD CONSTRAINT TelefonoVeterinario_d1
CHECK(telefono SIMILAR TO '[0-9]+');

-- Entidad
ALTER TABLE TelefonoVeterinario ADD CONSTRAINT TelefonoVeterinario_pkey
PRIMARY KEY (telefono, RFCVeterinario);

-- Referencial
ALTER TABLE TelefonoVeterinario ADD CONSTRAINT TelefonoVeterinario_fkey
FOREIGN KEY(RFCVeterinario) REFERENCES Veterinario(RFCVeterinario) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE TelefonoVeterinario IS 'Tabla con los telefonos de los veterinarios';
COMMENT ON COLUMN TelefonoVeterinario.RFCVeterinario IS 'Identificador del veterinario';
COMMENT ON COLUMN TelefonoVeterinario.telefono IS 'Teléfono del veterinario';
COMMENT ON CONSTRAINT TelefonoVeterinario_d1 ON TelefonoVeterinario IS 'Restricción para que telefono solo tenga numeros';
COMMENT ON CONSTRAINT TelefonoVeterinario_pkey ON TelefonoVeterinario IS 'La llave primaria de la tabla TelefonoVeterinario va a ser su teléfono';
COMMENT ON CONSTRAINT TelefonoVeterinario_fkey ON TelefonoVeterinario IS 'La llave foránea de la tabla TelefonoVeterinario va a ser el RFC del veterinario';

--------------------------------------------------------------------------------

CREATE TABLE Bioma(
    idBioma INT,
    tipoBioma VARCHAR(20)
);

-- Restricciones Bioma

-- Dominio
ALTER TABLE Bioma ALTER COLUMN idBioma
SET NOT NULL;
ALTER TABLE Bioma ALTER COLUMN tipoBioma
SET NOT NULL;
ALTER TABLE Bioma ADD CONSTRAINT Bioma_d1
CHECK(tipoBioma = 'desierto' OR tipoBioma = 'pastizales' OR tipoBioma = 'franja costera'
OR tipoBioma = 'tundra' OR tipoBioma = 'aviario' OR tipoBioma = 'bosque templado' OR tipoBioma = 'bosque tropical');

-- Entidad
ALTER TABLE Bioma ADD CONSTRAINT Bioma_pkey
PRIMARY KEY (idBioma);

-- Comentarios
COMMENT ON TABLE Bioma IS 'Tabla con los biomas del zoológico';
COMMENT ON COLUMN Bioma.idBioma IS 'Identificador del bioma';
COMMENT ON COLUMN Bioma.tipoBioma IS 'Tipo del bioma, estos son: Desierto, pastizales, franja costera, tundra, aviario, bosque templado y bosque tropical';
COMMENT ON CONSTRAINT Bioma_d1 ON Bioma IS 'Sólo hay siete posibles valores para el tipo de bioma'; 
COMMENT ON CONSTRAINT Bioma_pkey ON Bioma IS 'La llave primaria del bioma va a ser su identificador';

--------------------------------------------------------------------------------

CREATE TABLE Jaula (
    numero INT,
    idBioma INT
);

-- Restricciones Jaula

-- Dominio
ALTER TABLE Jaula ALTER COLUMN numero
SET NOT NULL;

-- Entidad
ALTER TABLE Jaula ADD CONSTRAINT Jaula_pkey
PRIMARY KEY (numero);

-- Referencial
ALTER TABLE Jaula ADD CONSTRAINT Jaula_fkey
FOREIGN KEY(idBioma) REFERENCES Bioma(idBioma) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Jaula IS 'Jaulas en los biomas para que habiten los animales individualmente';
COMMENT ON COLUMN Jaula.numero IS 'Número de la jaula respecto al bioma';
COMMENT ON COLUMN Jaula.idBioma IS 'Identificador del bioma donde se ubica la jaula';
COMMENT ON CONSTRAINT Jaula_pkey ON Jaula IS 'La llave primaria de la jaula va a ser su número';
COMMENT ON CONSTRAINT Jaula_fkey ON Jaula IS 'La llave foránea de la jaula va a ser el id del bioma donde está';

--------------------------------------------------------------------------------

CREATE TABLE Cuidador (
    RFCCuidador CHAR(13),
    idBioma INT,
    nombre VARCHAR(50),
    aPaterno VARCHAR(50),
    aMaterno VARCHAR(50),
    nacimiento DATE,
    genero CHAR(1),
    calle VARCHAR(50),
    numExterior INT,
    numInterior INT,
    colonia VARCHAR(50),
    estado VARCHAR(50),
    inicioContrato DATE,
    finContrato DATE,
    horarioLaboral TEXT,
    diasTrabajo TEXT,
    salario FLOAT
);

-- Restricciones Cuidador

-- Dominio
ALTER TABLE Cuidador ALTER COLUMN RFCCuidador
SET NOT NULL;
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d1
CHECK(RFCCuidador SIMILAR TO '[A-Z]{4}[0-9]{6}([A-Z]|[0-9]){3}');
ALTER TABLE Cuidador ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d2
CHECK(nombre <> '');
ALTER TABLE Cuidador ALTER COLUMN aPaterno
SET NOT NULL;
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d3
CHECK(aPaterno <> '');
ALTER TABLE Cuidador ALTER COLUMN aMaterno
SET NOT NULL;
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d4
CHECK(aMaterno <> '');
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d5
CHECK(nacimiento < CURRENT_DATE);
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d6
CHECK(genero = 'M' OR genero  = 'F' OR genero = 'X');
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d7
CHECK(calle <> '');
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d8
CHECK(numExterior >= 1);
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d9
CHECK(numInterior > 0);
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d10
CHECK(colonia <> '');
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d11
CHECK(estado <> '');
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d12
CHECK(inicioContrato <= CURRENT_DATE);
ALTER TABLE Cuidador ALTER COLUMN horarioLaboral
SET NOT NULL;
ALTER TABLE Cuidador ALTER COLUMN diasTrabajo
SET NOT NULL;
ALTER TABLE Cuidador ALTER COLUMN salario
SET NOT NULL;
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_d13
CHECK(salario > 0.0);

-- Entidad
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_pkey
PRIMARY KEY (RFCCuidador);

-- Referencial
ALTER TABLE Cuidador ADD CONSTRAINT Cuidador_fkey
FOREIGN KEY(idBioma) REFERENCES Bioma(idBioma) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Cuidador IS 'Tabla que contiene a los cuidadores';
COMMENT ON COLUMN Cuidador.RFCCuidador IS 'Identificador del cuidador';
COMMENT ON COLUMN Cuidador.idBioma IS 'Identificador del bioma';
COMMENT ON COLUMN Cuidador.nombre IS 'Nombre del cuidador';
COMMENT ON COLUMN Cuidador.aPaterno IS 'Apellido paterno del cuidador';
COMMENT ON COLUMN Cuidador.aMaterno IS 'Apellido materno del cuidador';
COMMENT ON COLUMN Cuidador.nacimiento IS 'Fecha de nacimiento del cuidador';
COMMENT ON COLUMN Cuidador.genero IS 'Genero del cuidador';
COMMENT ON COLUMN Cuidador.calle IS 'Calle de la direccion del cuidador';
COMMENT ON COLUMN Cuidador.numExterior IS 'Numero exterior de la direccion del cuidador';
COMMENT ON COLUMN Cuidador.numInterior IS 'Numero interior de la direccion del cuidador';
COMMENT ON COLUMN Cuidador.colonia IS 'Colonia de la direccion del cuidador';
COMMENT ON COLUMN Cuidador.estado IS 'Estado de la direccion del cuidador';
COMMENT ON COLUMN Cuidador.inicioContrato IS 'Fecha de inicio de contrato del cuidador';
COMMENT ON COLUMN Cuidador.finContrato IS 'Fecha de fin de contrato del cuidador';
COMMENT ON COLUMN Cuidador.horarioLaboral IS 'Horario laboral del cuidador';
COMMENT ON COLUMN Cuidador.diasTrabajo IS 'Dias de trabajo del cuidador';
COMMENT ON COLUMN Cuidador.salario IS 'Salario del cuidador';
COMMENT ON CONSTRAINT Cuidador_pkey ON Cuidador IS 'La llave primaria de la tabla Cuidadr va a ser el RFC del cuidador';
COMMENT ON CONSTRAINT Cuidador_d1 ON Cuidador IS 'Restricción para que RFCVeterinario conste de 4 letras mayusculas al inicio, luego 6 numeros y por ultimo 3 letras o numeros';
COMMENT ON CONSTRAINT Cuidador_d2 ON Cuidador IS 'Restricción para que nombre no sea la cadena vacia';
COMMENT ON CONSTRAINT Cuidador_d3 ON Cuidador IS 'Restricción para que aPaterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Cuidador_d4 ON Cuidador IS 'Restricción para que aMaterno no sea la cadena vacia';
COMMENT ON CONSTRAINT Cuidador_d5 ON Cuidador IS 'Restricción para que nacimiento sea anterior de la fecha actual';
COMMENT ON CONSTRAINT Cuidador_d6 ON Cuidador IS 'Restricción para que genero sea M, F o X';
COMMENT ON CONSTRAINT Cuidador_d7 ON Cuidador IS 'Restricción para que calle no sea la cadena vacia';
COMMENT ON CONSTRAINT Cuidador_d8 ON Cuidador IS 'Restricción para que numExterior sea mayor a cero';
COMMENT ON CONSTRAINT Cuidador_d9 ON Cuidador IS 'Restricción para que numInterior sea mayor a cero';
COMMENT ON CONSTRAINT Cuidador_d10 ON Cuidador IS 'Restricción para que colonia no sea la cadena vacia';
COMMENT ON CONSTRAINT Cuidador_d11 ON Cuidador IS 'Restricción para que estado no sea la cadena vacia';
COMMENT ON CONSTRAINT Cuidador_d12 ON Cuidador IS 'Restricción para que inicioContrato sea anterior o igual a la fecha actual';
COMMENT ON CONSTRAINT Cuidador_d13 ON Cuidador IS 'Restricción para que salario sea mayor a cero';

--------------------------------------------------------------------------------

CREATE TABLE EmailCuidador (
    email VARCHAR(100),
    RFCCuidador CHAR(13)
);

-- Restricciones EmailCuidador

-- Dominio
ALTER TABLE EmailCuidador ALTER COLUMN email
SET NOT NULL;
ALTER TABLE EmailCuidador ADD CONSTRAINT EmailCuidador_d1
CHECK(email LIKE '%_@_%._%');

-- Entidad
ALTER TABLE EmailCuidador ADD CONSTRAINT EmailCuidador_pkey
PRIMARY KEY (email, RFCCuidador);

-- Referencial
ALTER TABLE EmailCuidador ADD CONSTRAINT EmailCuidador_fkey
FOREIGN KEY(RFCCuidador) REFERENCES Cuidador(RFCCuidador) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE EmailCuidador IS 'Tabla que contiene a los emails de los cuidadores';
COMMENT ON COLUMN EmailCuidador.RFCCuidador IS 'Identificador del cuidador';
COMMENT ON COLUMN EmailCuidador.email IS 'email del cuidador';
COMMENT ON CONSTRAINT EmailCuidador_d1 ON EmailCuidador IS 'Restricción para que el email contenga al caracter @ y luego al .';
COMMENT ON CONSTRAINT EmailCuidador_pkey ON EmailCuidador IS 'La llave primaria de la tabla EmailCuidador va a ser el email del cuidador';
COMMENT ON CONSTRAINT EmailCuidador_fkey ON EmailCuidador IS 'La llave foránea de la tabla EmailCuidador va a ser el RFC del cuidador';

--------------------------------------------------------------------------------

CREATE TABLE TelefonoCuidador (
	telefono CHAR(10),
    RFCCuidador CHAR(13)
);

-- Restricciones TelefonoCuidador

-- Dominio
ALTER TABLE TelefonoCuidador ALTER COLUMN telefono
SET NOT NULL;
ALTER TABLE TelefonoCuidador ADD CONSTRAINT TelefonoCuidador_d1
CHECK(telefono SIMILAR TO '[0-9]+');

-- Entidad
ALTER TABLE TelefonoCuidador ADD CONSTRAINT TelefonoCuidador_pkey
PRIMARY KEY (telefono, RFCCuidador);

-- Referencial
ALTER TABLE TelefonoCuidador ADD CONSTRAINT TelefonoCuidador_fkey
FOREIGN KEY(RFCCuidador) REFERENCES Cuidador(RFCCuidador) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE TelefonoCuidador IS 'Tabla que contiene a los telefonos de los cuidadores';
COMMENT ON COLUMN TelefonoCuidador.RFCCuidador IS 'Identificador del cuidador';
COMMENT ON COLUMN TelefonoCuidador.telefono IS 'telefono del cuidador';
COMMENT ON CONSTRAINT TelefonoCuidador_d1 ON TelefonoCuidador IS 'Restricción para que telefono solo tenga numeros';
COMMENT ON CONSTRAINT TelefonoCuidador_pkey ON TelefonoCuidador IS 'La llave primaria de la tabla TelefonoCuidador va a ser el teléfono del cuidador';
COMMENT ON CONSTRAINT TelefonoCuidador_fkey ON TelefonoCuidador IS 'La llave foránea de la tabla TelefonoCuidador va a ser el RFC del cuidador';

--------------------------------------------------------------------------------

CREATE TABLE Animal (
    idAnimal INT,
    numero INT,
    RFCCuidador CHAR(13),
    nombre VARCHAR(50),
    peso FLOAT,
    altura FLOAT,
    especie VARCHAR(50),
    sexo CHAR(1),
    alimentacion VARCHAR(10)
);

-- Restricciones Animal

-- Dominio
ALTER TABLE Animal ALTER COLUMN idAnimal
SET NOT NULL;
ALTER TABLE Animal ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Animal ADD CONSTRAINT Animal_d1
CHECK(nombre <> '');
ALTER TABLE Animal ALTER COLUMN especie
SET NOT NULL;
ALTER TABLE Animal ADD CONSTRAINT Animal_d2
CHECK(especie <> '');
ALTER TABLE Animal ADD CONSTRAINT Animal_d3
CHECK(sexo = 'M' OR sexo  = 'H');
ALTER TABLE Animal ADD CONSTRAINT Animal_d4
CHECK(alimentacion = 'herbivoro' OR alimentacion = 'carnivoro' OR alimentacion = 'omnivoro');

-- Entidad
ALTER TABLE Animal ADD CONSTRAINT Animal_pkey
PRIMARY KEY (idAnimal);

-- Referencial
ALTER TABLE Animal ADD CONSTRAINT Animal_fkey1
FOREIGN KEY(numero) REFERENCES Jaula(numero) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE Animal ADD CONSTRAINT Animal_fkey2
FOREIGN KEY(RFCCuidador) REFERENCES Cuidador(RFCCuidador) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Animal IS 'Tabla con los animales del zoológico';
COMMENT ON COLUMN Animal.idAnimal IS 'Identificador del animal';
COMMENT ON COLUMN Animal.numero IS 'Número de la jaula del animal';
COMMENT ON COLUMN Animal.RFCCuidador IS 'RFC del cuidador del animal';
COMMENT ON COLUMN Animal.nombre IS 'Nombre del animal';
COMMENT ON COLUMN Animal.peso IS 'Peso del animal';
COMMENT ON COLUMN Animal.altura IS 'Altura del animal';
COMMENT ON COLUMN Animal.especie IS 'Especie del animal';
COMMENT ON COLUMN Animal.sexo IS 'Sexo del animal';
COMMENT ON COLUMN Animal.alimentacion IS 'Alimentación del animal';
COMMENT ON CONSTRAINT Animal_d1 ON Animal IS 'Restricción para que el nombre del animal no sea una cadena vacía';
COMMENT ON CONSTRAINT Animal_d2 ON Animal IS 'Restricción para que la especie del animal no sea una cadena vacía';
COMMENT ON CONSTRAINT Animal_d3 ON Animal IS 'Restricción para que el sexo del animal sea M o H';
COMMENT ON CONSTRAINT Animal_d4 ON Animal IS 'Restricción para que que la alimentación del animal solo pueda recoger tres posibles valores';
COMMENT ON CONSTRAINT Animal_pkey ON Animal IS 'La llave primaria de la tabla Animal va a ser su identificador';
COMMENT ON CONSTRAINT Animal_fkey1 ON Animal IS 'Integridad referencial para la llave foránea respecto a la jaula del animal';
COMMENT ON CONSTRAINT Animal_fkey2 ON Animal IS 'Integridad referencial para la llave foránea respecto al cuidador del animal';

--------------------------------------------------------------------------------

CREATE TABLE Medicina (
    idMedicina INT,
    nombre VARCHAR(50),
    cantidad INT,
    caducidad DATE,
    refrigeracion BOOL,
    laboratorio VARCHAR(100),
    lote INT
);

-- Restricciones Medicina

-- Dominio
ALTER TABLE Medicina ALTER COLUMN idMedicina
SET NOT NULL;
ALTER TABLE Medicina ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Medicina ADD CONSTRAINT Medicina_d1
CHECK(nombre <> '');
ALTER TABLE Medicina ADD CONSTRAINT Medicina_d2
CHECK(cantidad >= 0);

-- Entidad
ALTER TABLE Medicina ADD CONSTRAINT Medicina_pkey
PRIMARY KEY (idMedicina);

-- Comentarios
COMMENT ON TABLE Medicina IS 'Tabla con el inventario de medicinas del zoológico';
COMMENT ON COLUMN Medicina.idMedicina IS 'Identificador de medicina';
COMMENT ON COLUMN Medicina.nombre IS 'Nombre de la medicina';
COMMENT ON COLUMN Medicina.cantidad IS 'Cantidad de medicina';
COMMENT ON COLUMN Medicina.caducidad IS 'Fecha de caducidad de la medicina';
COMMENT ON COLUMN Medicina.refrigeracion IS 'Si la medicina necesita refrigeracion o no';
COMMENT ON COLUMN Medicina.laboratorio IS 'Laboratorio que fabrico la medicina';
COMMENT ON COLUMN Medicina.lote IS 'Lote de la medicina';
COMMENT ON CONSTRAINT Medicina_pkey ON Medicina IS 'La llave primaria de la tabla Medicina';
COMMENT ON CONSTRAINT Medicina_d1 ON Medicina IS 'Restricción para que nombre no sea la cadena vacia';
COMMENT ON CONSTRAINT Medicina_d2 ON Medicina IS 'Restricción para que cantidad sea mayor o igual a cero';

--------------------------------------------------------------------------------

CREATE TABLE DistribuidoMedicina(
    idMedicina INT,
    idBioma INT
);

-- Restricciones DistribuidoMedicina

-- Referencial
ALTER TABLE DistribuidoMedicina ADD CONSTRAINT DistribuidoMedicina_fkey1
FOREIGN KEY(idMedicina) REFERENCES Medicina(idMedicina) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE DistribuidoMedicina ADD CONSTRAINT DistribuidoMedicina_fkey2
FOREIGN KEY(idBioma) REFERENCES Bioma(idBioma) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE DistribuidoMedicina IS 'Tabla que contiene la relacion entre medicina y bioma al que pertenece';
COMMENT ON COLUMN  DistribuidoMedicina.idMedicina IS 'Identificador de medicina';
COMMENT ON COLUMN  DistribuidoMedicina.idBioma IS 'Identificador de bioma';
COMMENT ON CONSTRAINT DistribuidoMedicina_fkey2 ON DistribuidoMedicina IS 'Integridad referencial para la llave foránea respecto a los veterinarios';
COMMENT ON CONSTRAINT DistribuidoMedicina_fkey1 ON DistribuidoMedicina IS 'Integridad referencial para la llave foránea respecto a los veterinarios';

--------------------------------------------------------------------------------

CREATE TABLE Alimento (
    idAlimento INT,
    nombre VARCHAR(50),
    cantidad INT,
    caducidad DATE,
    refrigeracion BOOL,
    tipo VARCHAR(50)
);

-- Restricciones Alimento

-- Dominio
ALTER TABLE Alimento ALTER COLUMN idAlimento
SET NOT NULL;
ALTER TABLE Alimento ALTER COLUMN nombre
SET NOT NULL;
ALTER TABLE Alimento ADD CONSTRAINT Alimento_d1
CHECK(nombre <> '');
ALTER TABLE Alimento ADD CONSTRAINT Alimento_d2
CHECK(cantidad >= 0);
ALTER TABLE Alimento ALTER COLUMN tipo
SET NOT NULL;
ALTER TABLE Alimento ADD CONSTRAINT Alimento_d3
CHECK(tipo <> '');


-- Entidad
ALTER TABLE Alimento ADD CONSTRAINT Alimento_pkey
PRIMARY KEY (idAlimento);

-- Comentarios
COMMENT ON COLUMN  Alimento.idAlimento IS 'Identificador de alimento';
COMMENT ON COLUMN  Alimento.nombre IS 'Nombre de la alimento';
COMMENT ON COLUMN  Alimento.cantidad IS 'Cantidad de alimento';
COMMENT ON COLUMN  Alimento.caducidad IS 'Fecha de caducidad de la alimento  ';
COMMENT ON COLUMN  Alimento.refrigeracion IS 'Si la alimento necesita refrigeracion o no';
COMMENT ON COLUMN  Alimento.tipo IS 'Tipo de alimento';
COMMENT ON CONSTRAINT Alimento_d1 ON Alimento IS 'Restricción para que nombre no sea la cadena vacia';
COMMENT ON CONSTRAINT Alimento_d2 ON Alimento IS 'Restricción para que cantidad sea mayor o igual a cero';
COMMENT ON CONSTRAINT Alimento_d3 ON Alimento IS 'Restricción para que tipo no sea la cadena vacia';
COMMENT ON CONSTRAINT Alimento_pkey ON Alimento IS 'La llave primaria va a ser el id del alimento';

--------------------------------------------------------------------------------

CREATE TABLE DistribuidoAlimento(
    idAlimento INT,
    idBioma INT
);

-- Restricciones DistribuidoAlimento

-- Referencial
ALTER TABLE DistribuidoAlimento ADD CONSTRAINT DistribuidoAlimento_fkey1
FOREIGN KEY(idAlimento) REFERENCES Alimento(idAlimento) ON UPDATE CASCADE ON DELETE CASCADE  ;
ALTER TABLE DistribuidoAlimento ADD CONSTRAINT DistribuidoAlimento_fkey2
FOREIGN KEY(idBioma) REFERENCES Bioma(idBioma) ON UPDATE CASCADE ON DELETE CASCADE ;

-- Comentarios
COMMENT ON TABLE DistribuidoAlimento IS 'Tabla que contiene la relacion entre alimento y bioma al que pertenece';
COMMENT ON COLUMN DistribuidoAlimento.idAlimento IS 'Identificador de alimento';
COMMENT ON COLUMN DistribuidoAlimento.idBioma IS ' Identificador de bioma';
COMMENT ON CONSTRAINT DistribuidoAlimento_fkey2 ON DistribuidoAlimento IS 'Integridad referencial para la llave foránea respecto a los alimentos';
COMMENT ON CONSTRAINT DistribuidoAlimento_fkey1 ON DistribuidoAlimento IS 'Integridad referencial para la llave foránea respecto a los biomas';

--------------------------------------------------------------------------------

CREATE TABLE Evento (
    idEvento INT,
    capacidad INT,
    fecha DATE,
    tipo VARCHAR(30)
);

-- Restricciones Evento

-- Dominio
ALTER TABLE Evento ALTER COLUMN idEvento
SET NOT NULL;
ALTER TABLE Evento ALTER COLUMN capacidad
SET NOT NULL;
ALTER TABLE Evento ADD CONSTRAINT Evento_d1
CHECK(capacidad >= 0);
ALTER TABLE Evento ALTER COLUMN fecha
SET NOT NULL;
ALTER TABLE Evento ALTER COLUMN tipo
SET NOT NULL;
ALTER TABLE Evento ADD CONSTRAINT Evento_d2
CHECK(tipo = 'social' OR tipo  = 'academico' OR tipo  = 'recaudacion de fondos'
OR tipo  = 'infantil' OR tipo  = 'escolar' OR tipo  = 'dias festivos');

-- Entidad
ALTER TABLE Evento ADD CONSTRAINT Evento_pkey
PRIMARY KEY (idEvento);

-- Comentarios
COMMENT ON TABLE Evento IS 'Tabla que contiene la descripcion de un evento ';
COMMENT ON COLUMN Evento.idEvento IS 'Identificador del evento';
COMMENT ON COLUMN Evento.capacidad IS 'expresa la capacidad de asistentes al evento';
COMMENT ON CONSTRAINT Evento_d1 ON Evento IS 'Restricción para que la capacidad sea mayor o igual a cero';
COMMENT ON CONSTRAINT Evento_d2 ON Evento IS 'Solo hay 6 posibles valores que puede tomar el tipo de evento';
COMMENT ON CONSTRAINT Evento_pkey ON Evento IS 'La llave primaria va a ser el identificador del evento';

--------------------------------------------------------------------------------

CREATE TABLE Ticket (
    folio INT,
    idCliente INT,
    descuento FLOAT,
    fecha DATE
);

-- Restricciones Ticket

-- Dominio
ALTER TABLE Ticket ALTER COLUMN folio
SET NOT NULL;
ALTER TABLE Ticket ADD CONSTRAINT Ticket_d1
CHECK(descuento >= 0 AND descuento <= 100);
ALTER TABLE Ticket ADD CONSTRAINT Ticket_d2
CHECK(fecha <= CURRENT_DATE);

-- Entidad
ALTER TABLE Ticket ADD CONSTRAINT Ticket_pkey
PRIMARY KEY (folio);

-- Referencial
ALTER TABLE Ticket ADD CONSTRAINT Ticket_fkey
FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Ticket IS 'Ticket de compra en algún local de servicio';
COMMENT ON COLUMN Ticket.folio IS 'Folio e identificador del ticket';
COMMENT ON COLUMN Ticket.idCliente IS 'Identificador del cliente a quien se le emitió el ticket';
COMMENT ON COLUMN Ticket.descuento IS 'Porcentaje de descuento aplicado en la compra';
COMMENT ON COLUMN Ticket.fecha IS 'Fecha en la que se emitió el ticket';
COMMENT ON CONSTRAINT Ticket_d1 ON Ticket IS 'El descuento solo puede ser un número positivo entre el 0 y 100';
COMMENT ON CONSTRAINT Ticket_d2 ON Ticket IS 'Cuando se emite un ticket, este debería tener una fecha no menor a la actual';
COMMENT ON CONSTRAINT Ticket_pkey ON Ticket IS 'La llave primaria va a ser el folio';
COMMENT ON CONSTRAINT Ticket_fkey ON Ticket IS 'Integridad referencial para la llave foránea respecto al cliente';

--------------------------------------------------------------------------------

CREATE TABLE Emite (
    folio INT,
    idServicio INT
);

--Restricciones Emite

--Referencial
ALTER TABLE Emite ADD CONSTRAINT Emite_fkey1
FOREIGN KEY(folio) REFERENCES Ticket(folio) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE Emite ADD CONSTRAINT Emite_fkey2
FOREIGN KEY(idServicio) REFERENCES Servicio(idServicio) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Emite IS 'Local de servicios que emite cada ticket';
COMMENT ON COLUMN Emite.folio IS 'Identificador del ticket emitido';
COMMENT ON COLUMN Emite.idServicio IS 'Identificador del servicio emisor del ticket';
COMMENT ON CONSTRAINT Emite_fkey1 ON Emite IS 'Integridad referencial para la llave foránea respecto al ticket';
COMMENT ON CONSTRAINT Emite_fkey2 ON Emite IS 'Integridad referencial para la llave foránea respecto al servicio emisor';

--------------------------------------------------------------------------------

CREATE TABLE Asistir (
    idCliente INT,
    idEvento INT
);

-- Restricciones Asistir

-- Referencial
ALTER TABLE Asistir ADD CONSTRAINT Asistir_fkey1
FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE Asistir ADD CONSTRAINT Asistir_fkey2
FOREIGN KEY(idEvento) REFERENCES Evento(idEvento) ON UPDATE CASCADE ON DELETE SET NULL;

-- Comentarios
COMMENT ON TABLE Asistir IS 'Tabla que contiene la relación entre asistentes  y eventos';
COMMENT ON COLUMN Asistir.idCliente IS 'Identificador del cliente';
COMMENT ON COLUMN Asistir.idEvento IS ' Identificador del evento';
COMMENT ON CONSTRAINT Asistir_fkey2 ON Asistir IS 'Integridad referencial para la llave foránea respecto al cliente asistente';
COMMENT ON CONSTRAINT Asistir_fkey1 ON Asistir IS 'Integridad referencial para la llave foránea respecto al evento';

--------------------------------------------------------------------------------

CREATE TABLE ProveeAlimento (
    RFCProveedor CHAR(13),
    idAlimento INT,
    frecuencia VARCHAR(100),
    costo NUMERIC (10,2)
);

-- Restricciones ProveeAlimento

-- Dominio
ALTER TABLE ProveeAlimento ADD CONSTRAINT ProveeAlimento_d1
CHECK(costo >= 0);

-- Referencial
ALTER TABLE ProveeAlimento ADD CONSTRAINT ProveeAlimento_fkey1
FOREIGN KEY(RFCProveedor) REFERENCES Proveedor(RFCProveedor) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ProveeAlimento ADD CONSTRAINT ProveeAlimento_fkey2
FOREIGN KEY(idAlimento) REFERENCES Alimento(idAlimento) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE ProveeAlimento IS 'Tabla que contiene la relacion entre proveedores y alimentos';
COMMENT ON COLUMN ProveeAlimento.RFCProveedor IS 'Identificador de proveedor';   
COMMENT ON COLUMN ProveeAlimento.idAlimento IS 'Identificador de alimento';
COMMENT ON CONSTRAINT ProveeAlimento_d1 ON ProveeAlimento IS 'El costo del alimento tiene que ser un número positivo';
COMMENT ON CONSTRAINT ProveeAlimento_fkey2 ON ProveeAlimento IS 'Integridad referencial para la llave foránea respecto al proveedor';
COMMENT ON CONSTRAINT ProveeAlimento_fkey1 ON ProveeAlimento IS 'Integridad referencial para la llave foránea respecto al alimento';

--------------------------------------------------------------------------------

CREATE TABLE ProveeMedicina (
    RFCProveedor CHAR(13),
    idMedicina INT,
    frecuencia VARCHAR(100),
    costo NUMERIC (10,2)
);

-- Restricciones ProveeMedicina

-- Dominio
ALTER TABLE ProveeMedicina ADD CONSTRAINT ProveeMedicina_d1
CHECK(costo >= 0);

-- Referencial
ALTER TABLE ProveeMedicina ADD CONSTRAINT ProveeMedicina_fkey1
FOREIGN KEY(RFCProveedor) REFERENCES Proveedor(RFCProveedor) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE ProveeMedicina ADD CONSTRAINT ProveeMedicina_fkey2
FOREIGN KEY(idMedicina) REFERENCES Medicina(idMedicina) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE ProveeMedicina IS 'Tabla que contiene la relacion entre proveedores y medicinas';
COMMENT ON COLUMN ProveeMedicina.RFCProveedor IS 'Identificador de proveedor';
COMMENT ON COLUMN ProveeMedicina.idMedicina IS ' Identificador de la medicina';
COMMENT ON CONSTRAINT ProveeMedicina_fkey2 ON ProveeMedicina IS 'Integridad referencial para la llave foránea respecto al proveedor';
COMMENT ON CONSTRAINT ProveeMedicina_fkey1 ON ProveeMedicina IS 'Integridad referencial para la llave foránea respecto a la medicina';

--------------------------------------------------------------------------------

CREATE TABLE Ubicado (
	idServicio INT,
	idBioma INT
);

--Restricciones Ubicado

--Referencial
ALTER TABLE Ubicado ADD CONSTRAINT Ubicado_fkey1
FOREIGN KEY(idServicio) REFERENCES Servicio(idServicio) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE Ubicado ADD CONSTRAINT Ubicado_fkey2
FOREIGN KEY(idBioma) REFERENCES Bioma(idBioma) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Ubicado IS 'Tabla que define la ubicación de cada servicio dentro del zoológico';
COMMENT ON COLUMN Ubicado.idServicio IS 'Identificador del servicio a tratar';
COMMENT ON COLUMN Ubicado.idBioma IS 'Identificador del bioma donde se ubica el servicio';
COMMENT ON CONSTRAINT Ubicado_fkey1 ON Ubicado IS 'Integridad referencial para la llave foránea respecto idServicio';
COMMENT ON CONSTRAINT Ubicado_fkey2 ON Ubicado IS 'Integridad referencial para la llave foránea respecto idBioma';

--------------------------------------------------------------------------------

CREATE TABLE Adjunto (
    RFCVeterinario CHAR(13),
    idBioma INT
);
COMMENT ON TABLE Ubicado IS 'Ubicación de cada servicio en su bioma correspondiente';

--Restricciones Adjunto

--Referencial
ALTER TABLE Adjunto ADD CONSTRAINT Adjunto_fkey1
FOREIGN KEY(RFCVeterinario) REFERENCES Veterinario(RFCVeterinario) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE Adjunto ADD CONSTRAINT Adjunto_fkey2
FOREIGN KEY(idBioma) REFERENCES Bioma(idBioma) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Adjunto IS 'Tabla que especifica la relación entre veterinarios y el bioma al que están asignados';
COMMENT ON COLUMN Adjunto.RFCVeterinario IS 'RFC del veterinario que esta asignado a un bioma especificado';
COMMENT ON COLUMN Adjunto.idBioma IS 'Identificador del bioma al que está asignado un veterinario en particular';
COMMENT ON CONSTRAINT Adjunto_fkey1 ON Adjunto IS 'Integridad referencial para la llave foránea respecto a los veterinarios';
COMMENT ON CONSTRAINT Adjunto_fkey2 ON Adjunto IS 'Integridad referencial para la llave foránea respecto a los biomas';

--------------------------------------------------------------------------------

CREATE TABLE Atiende (
    RFCVeterinario CHAR(13),
    idAnimal INT,
    indicaciones TEXT
);

-- Restricciones Atiende

-- Dominio
ALTER TABLE Atiende ALTER COLUMN indicaciones
SET NOT NULL;

-- Referencial
ALTER TABLE Atiende ADD CONSTRAINT Atiende_fkey1
FOREIGN KEY(RFCVeterinario) REFERENCES Veterinario(RFCVeterinario) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE Atiende ADD CONSTRAINT Atiende_fkey2
FOREIGN KEY(idAnimal) REFERENCES Animal(idAnimal) ON UPDATE CASCADE ON DELETE CASCADE;

-- Comentarios
COMMENT ON TABLE Atiende IS 'Tabla que especifica la relación entre veterinarios y los animales que atienden';
COMMENT ON COLUMN Atiende.RFCVeterinario IS 'RFC del veterinario que va a atender al animal especificado';
COMMENT ON COLUMN Atiende.idAnimal IS 'Identificador del animal atendido por el veterinario especificado';
COMMENT ON COLUMN Atiende.indicaciones IS 'Texto enunciando las indicaciones médicas para atender al animal';
COMMENT ON CONSTRAINT Atiende_fkey1 ON Atiende IS 'Integridad referencial para la llave foránea respecto los veterinarios';
COMMENT ON CONSTRAINT Atiende_fkey2 ON Atiende IS 'Integridad referencial para la llave foránea respecto los animales';
