/* Adicionar usuarios */
INSERT INTO usuario (nome, email, username, senha, data_criacao)
VALUES ('Bruno', 'bruno@serratec.org', 'bruno', '12345678', '2023-01-01');
INSERT INTO usuario (nome, email, username, senha)
VALUES ('Igor', 'igor@serratec.org', 'igor', '12345678');
INSERT INTO usuario (nome, email, username, senha)
VALUES ('Kenny', 'kenny@serratec.org', 'kenny', '12345678');
INSERT INTO usuario (nome, email, username, senha)
VALUES ('Pedro', 'pedro@serratec.org', 'pedro', '12345678');
INSERT INTO usuario (nome, email, username, senha)
VALUES ('Wallace', 'wallace@serratec.org', 'wallace', '12345678');

/* Adicionar endereços */
INSERT INTO endereco (usuario_id, cep)
VALUES (1, '25651-000');
INSERT INTO endereco (usuario_id, cep)
VALUES (2, '55332-707');
INSERT INTO endereco (usuario_id, cep)
VALUES (3, '45200-580');
INSERT INTO endereco (usuario_id, cep)
VALUES (4, '76813-846');
INSERT INTO endereco (usuario_id, cep)
VALUES (5, '94834-416');

/* Adicionar categorias */
INSERT INTO categoria (nome, descricao)
VALUES ('Ação', 'Filmes ou series de ação');
INSERT INTO categoria (nome, descricao)
VALUES ('Drama', 'Filmes ou series de drama');
INSERT INTO categoria (nome, descricao)
VALUES ('Comédia', 'Filmes ou series de comédia');
INSERT INTO categoria (nome, descricao)
VALUES ('Terror', 'Filmes ou series de terror');
INSERT INTO categoria (nome, descricao)
VALUES ('Ficção Científica', 'Filmes ou series de ficção científica');

/* Adicionar filmes */
INSERT INTO filme (titulo, descricao, duracao, data_lancamento, nota_media, classificacao_indicativa)
VALUES ('Vingadores - Ultimato', 'Ultimo filme da saga', '180', '2019-04-24', '8.4', 'MAIORES_14');
INSERT INTO filme (titulo, descricao, duracao, data_lancamento, nota_media, classificacao_indicativa)
VALUES ('O Poderoso Chefão', 'Filme de máfia', '175', '1972-03-24', '9.2', 'MAIORES_18');
INSERT INTO filme (titulo, descricao, duracao, data_lancamento, nota_media, classificacao_indicativa)
VALUES ('Interestelar', 'Filme de ficção científica', '169', '2014-11-06', '8.6', 'MAIORES_14');
INSERT INTO filme (titulo, descricao, duracao, data_lancamento, nota_media, classificacao_indicativa)
VALUES ('O Exorcista', 'Filme de terror', '122', '1973-12-26', '8.0', 'MAIORES_18');
INSERT INTO filme (titulo, descricao, duracao, data_lancamento, nota_media, classificacao_indicativa)
VALUES ('Eu, Eu Mesmo e Irene', 'Filme de comédia', '117', '2000-06-23', '6.6', 'MAIORES_14');

/* Tabela de relação de filme com categoria */
INSERT INTO filme_categoria (filme_id, categoria_id)
VALUES (1, 1);
INSERT INTO filme_categoria (filme_id, categoria_id)
VALUES (2, 2);
INSERT INTO filme_categoria (filme_id, categoria_id)
VALUES (3, 5);
INSERT INTO filme_categoria (filme_id, categoria_id)
VALUES (4, 4);
INSERT INTO filme_categoria (filme_id, categoria_id)
VALUES (5, 3);

/* Adicionar avaliações de filmes */
INSERT INTO avaliacao_filme (nota, comentario, filme_id, usuario_id, data_avaliacao)
VALUES ('8.5', 'Ótimo filme!', 1, 1, '2023-01-30');
INSERT INTO avaliacao_filme (nota, comentario, filme_id, usuario_id, data_avaliacao)
VALUES ('9.0', 'Clássico atemporal!', 2, 2, '2023-01-29');
INSERT INTO avaliacao_filme (nota, comentario, filme_id, usuario_id, data_avaliacao)
VALUES ('8.0', 'Visualmente impressionante!', 3, 3, '2023-01-28');
INSERT INTO avaliacao_filme (nota, comentario, filme_id, usuario_id, data_avaliacao)
VALUES ('7.5', 'Assustador e bem feito!', 4, 4, '2023-01-27');
INSERT INTO avaliacao_filme (nota, comentario, filme_id, usuario_id, data_avaliacao)
VALUES ('6.0', 'Engraçado, mas não para todos!', 5, 5, '2023-01-26');

/* Adicionar séries */
INSERT INTO serie (titulo_serie, descricao_serie, temporadas, episodios, data_lancamento, nota_media_serie)
VALUES ('Friends', 'Série de comédia', '10', '236', '1994-09-22', '9.0');
INSERT INTO serie (titulo_serie, descricao_serie, temporadas, episodios, data_lancamento, nota_media_serie)
VALUES ('Breaking Bad', 'Série de drama', '5', '62', '2008-01-20', '9.5');
INSERT INTO serie (titulo_serie, descricao_serie, temporadas, episodios, data_lancamento, nota_media_serie)
VALUES ('True Detective', 'Série de ação', '3', '24', '2014-01-12', '8.5');
INSERT INTO serie (titulo_serie, descricao_serie, temporadas, episodios, data_lancamento, nota_media_serie)
VALUES ('The Last of Us', 'Série de ficção científica', '1', '9', '2023-01-15', '9.2');
INSERT INTO serie (titulo_serie, descricao_serie, temporadas, episodios, data_lancamento, nota_media_serie)
VALUES ('The Walking Dead', 'Série de terror', '11', '153', '2010-10-31', '7.8');

/* Adicionar avaliações de séries */
INSERT INTO avaliacao_serie (nota, comentario, data_avaliacao,id_serie ,id_usuario)
VALUES ('9.0', 'Série clássica e divertida!', '2024-01-01', 1,1);
INSERT INTO avaliacao_serie (nota, comentario, data_avaliacao,id_serie , id_usuario)
VALUES ('9.5', 'Uma das melhores séries de todos os tempos!', '2024-01-02',2, 2);
INSERT INTO avaliacao_serie (nota, comentario, data_avaliacao,id_serie , id_usuario)
VALUES ('8.5', 'Série intrigante e bem produzida!', '2024-01-03', 3,3);
INSERT INTO avaliacao_serie (nota, comentario, data_avaliacao,id_serie , id_usuario)
VALUES ('9.2', 'Série emocionante e visualmente impressionante!', '2024-01-04', 4,4);
INSERT INTO avaliacao_serie (nota, comentario, data_avaliacao,id_serie , id_usuario)
VALUES ('7.8', 'Série de terror que mantém o suspense!', '2024-01-05', 5,5);

INSERT INTO serie_categoria (id_categoria, id_serie)
VALUES (3, 1);
INSERT INTO serie_categoria (id_categoria, id_serie)
VALUES (1, 2);
INSERT INTO serie_categoria (id_categoria, id_serie)
VALUES (1, 3);
INSERT INTO serie_categoria (id_categoria, id_serie)
VALUES (1, 4);
INSERT INTO serie_categoria (id_categoria, id_serie)
VALUES (1, 5);

/* Adicionar listas de favoritos */
INSERT INTO lista_favoritos (nome_lista, privado, data_criacao, id_usario)
VALUES ('Minha Lista de Favoritos', false, '2024-01-01', 1);
INSERT INTO lista_favoritos (nome_lista, privado, data_criacao, id_usario)
VALUES ('Séries para Assistir', true, '2024-01-02', 2);
INSERT INTO lista_favoritos (nome_lista, privado, data_criacao, id_usario)
VALUES ('Filmes de Ação', false, '2024-01-03', 3);
INSERT INTO lista_favoritos (nome_lista, privado, data_criacao, id_usario)
VALUES ('Séries de Drama', true, '2024-01-04', 4);
INSERT INTO lista_favoritos (nome_lista, privado, data_criacao, id_usario)
VALUES ('Filmes de Ficção Científica', false, '2024-01-05', 5);

/* Tabela de relação da lista de favoritos com filmes*/
INSERT INTO lista_favoritos_filme (id_lista_favoritos, id_filme)
VALUES ('1', '2');
INSERT INTO lista_favoritos_filme (id_lista_favoritos, id_filme)
VALUES ('2', '3');
INSERT INTO lista_favoritos_filme (id_lista_favoritos, id_filme)
VALUES ('4', '1');
INSERT INTO lista_favoritos_filme (id_lista_favoritos, id_filme)
VALUES ('1', '3');
INSERT INTO lista_favoritos_filme (id_lista_favoritos, id_filme)
VALUES ('3', '2');

/* Tabela de relação da lista de favoritos com séries*/
INSERT INTO lista_favoritos_serie (id_lista_favoritos, id_serie)
VALUES ('1', '1');
INSERT INTO lista_favoritos_serie (id_lista_favoritos, id_serie)
VALUES ('2', '3');
INSERT INTO lista_favoritos_serie (id_lista_favoritos, id_serie)
VALUES ('2', '1');
INSERT INTO lista_favoritos_serie (id_lista_favoritos, id_serie)
VALUES ('1', '3');
INSERT INTO lista_favoritos_serie (id_lista_favoritos, id_serie)
VALUES ('4', '2');