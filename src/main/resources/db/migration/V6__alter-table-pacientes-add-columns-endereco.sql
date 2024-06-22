ALTER TABLE pacientes
ADD logradouro varchar(100) NOT NULL,
ADD bairro varchar(100) NOT NULL,
ADD cep varchar(9) NOT NULL,
ADD complemento varchar(100),
ADD numero varchar(20),
ADD uf char(2) NOT NULL,
ADD cidade varchar(100) NOT NULL;
