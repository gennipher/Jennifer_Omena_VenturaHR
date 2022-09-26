# Scripts para criação das tabelas do banco de dados
## Nome da database: ventura_hr

CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `razao_social` varchar(50) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `cnpj_UNIQUE` (`cnpj`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `vagas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `forma_contratacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario_idx` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `criterios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_vaga2` int NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `perfil` int NOT NULL,
  `peso` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_vaga_idx` (`id_vaga2`),
  CONSTRAINT `id_vaga2` FOREIGN KEY (`id_vaga2`) REFERENCES `vagas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `respostas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario1` int NOT NULL,
  `id_vaga1` int NOT NULL,
  `data` datetime NOT NULL,
  `indice` decimal(2,1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario_idx` (`id_usuario1`),
  KEY `id_vaga_idx` (`id_vaga1`),
  CONSTRAINT `id_usuario1` FOREIGN KEY (`id_usuario1`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `id_vaga1` FOREIGN KEY (`id_vaga1`) REFERENCES `vagas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `respostas_criterios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_resposta1` int NOT NULL,
  `id_criterio1` int NOT NULL,
  `resposta` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_resposta_idx` (`id_resposta1`),
  KEY `id_criterio_idx` (`id_criterio1`),
  CONSTRAINT `id_criterio1` FOREIGN KEY (`id_criterio1`) REFERENCES `criterios` (`id`),
  CONSTRAINT `id_resposta1` FOREIGN KEY (`id_resposta1`) REFERENCES `respostas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
