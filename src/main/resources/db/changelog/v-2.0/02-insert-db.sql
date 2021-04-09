insert into users (code, email, is_moderator, name, password, photo, reg_time)
     values ('NULL', 'sasha@email.com', 1, 'Sasha', '336JkIcKGKzsswa', NULL, '2018-08-01 15:02'),
            ('NULL', 'petya@email.com', 0, 'Petya', '1TowGxE7fyKo4Pb', NULL, '2018-04-25 03:10'),
            ('NULL', 'katya@email.com', 1, 'Katya', 'xSO7GcfW8FuIr2x', NULL, '2019-12-12 01:22'),
            ('NULL', 'irina@email.com', 0, 'Irina', 'hIGMcK48GZBG7i6', NULL, '2020-12-08 01:00');

insert into posts (is_active, moderation_status, text, time, title, view_count, moderator_id, user_id)
    values (1, 'NEW', 'Род птиц из семейства врановых. Род включает виды, известные как во́роны, воро́ны, грачи и галки. Между «во́ронами» и «воро́нами» нет чёткого различия, так как эти наименования присваиваются различным видам главным образом на основе их размера: во́роны, как правило, крупнее ворон.',
           '2021-01-05 18:24:45', 'Вороны', 0 , NULL, 2),
           (1, 'ACCEPTED', 'Наиболее многочисленный род птиц семейства чайковых, обитающих как на морских просторах, так и на внутренних водоёмах. Многие виды считаются синантропными — они живут вблизи человека и получают от этого выгоду.',
           '2020-03-01 16:34:45', 'Ча́йки', 12 , 1, 3),
           (1, 'ACCEPTED', 'Род птиц семейства синицевых. Обычный представитель рода — большая синица широко распространена на территории России',
           '2021-02-07 10:34:45', 'Синицы', 2 , 2, 4),
           (0, 'NEW', 'Морское млекопитающее из инфраотряда китообразных парвотряда зубатых китов семейства дельфиновых (дельфинов). Единственный современный представитель рода косаток. Признан самым крупным представителем своего семейства и единственный среди китообразных настоящий хищник, преследующий теплокровных животных.',
           '2021-04-01 12:34:45', 'Косатка', 0 , NULL, 4),
           (1, 'ACCEPTED', 'Птица из рода Настоящие ласточки, или касатки семейства ласточковых; в более узком смысле — деревенская ласточка.',
           '2021-4-10 15:34:45', 'Каса́тка', 24 , 1, 2),
           (1, 'ACCEPTED', 'Млекопитающее из рода пёстрых дельфинов. Назван в честь Филибера Коммерсона, который впервые описал этих животных в 1767 году.',
           '2021-03-18 12:34:45', 'Дельфи́н', 5 , 2, 3),
           (1, 'NEW', 'Вид хищных млекопитающих семейства кошачьих, один из пяти представителей рода пантера, который относится к подсемейству больших кошек.',
           '2021-03-14 14:34:45', 'Тигр', 0 , NULL, 3),
           (0, 'ACCEPTED', 'Род хищных млекопитающих семейства кошачьих, наиболее близкий к роду кошек (Felis).',
           '2020-08-08 13:34:45', 'Ры́си', 15 , 1, 1),
           (1, 'ACCEPTED', 'Вид хищных млекопитающих семейства кошачьих, один из пяти представителей рода пантер (Panthera), который относится к подсемейству больших кошек. Единственный представитель рода на территории Северной и Южной Америки. Третий по размеру в мире, и самый крупный в Новом свете представитель семейства кошачьих. Ареал вида простирается от Мексики к югу до Парагвая и северной Аргентины.',
           '2020-07-28 20:34:45', 'Ягуар', 9 , 1, 4),
           (1, 'ACCEPTED', 'Род крупных животных в семействе кошачьих, состоит из пяти ныне живущих общеизвестных видов: ирбис (лат. Panthera uncia), тигр (лат. Panthera tigris), лев (лат. Panthera leo), леопард (лат. Panthera pardus) и ягуар (лат. Panthera onca), а также ряда ископаемых таксонов.',
           '2021-01-28 20:34:45', 'Пантеры', 4 , 2, 1),
           (1, 'NEW', 'Семейство хищных млекопитающих подотряда кошкообразных. Современные гиены обитают на территории Африки и юго-западной Азии. Существует всего 4 современных вида гиен, в то время как по ископаемым остаткам описано более 70 видов.',
           '2021-02-28 20:34:45', 'Гиены', 14 , 2, 3);

insert into post_votes (time, value, post_id, user_id)
    values ('2021-02-28 20:34:45', 1, 1, 2),
    ('2021-02-28 20:34:45', 1, 1, 2),
    ('2021-02-28 20:34:45', -1, 1, 3),
    ('2021-02-28 20:34:45', 1, 1, 4),
    ('2021-02-28 20:34:45', 1, 2, 1),
    ('2021-02-28 20:34:45', -1, 2, 3),
    ('2021-02-28 20:34:45', -1, 10, 4),
    ('2021-02-28 20:34:45', 1, 3, 1),
    ('2021-02-28 20:34:45', 1, 3, 3),
    ('2021-02-28 20:34:45', 1, 10, 4),
    ('2021-02-28 20:34:45', -1, 9, 2),
    ('2021-02-28 20:34:45', 1, 10, 1),
    ('2021-02-28 20:34:45', -1, 4, 3),
    ('2021-02-28 20:34:45', 1, 5, 4),
    ('2021-02-28 20:34:45', -1, 9, 2);

insert into tags (name)
    values ('Птицы'),
    ('Млекопитающие'),
    ('Кошки'),
    ('Гиены'),
    ('Животные');

insert into tag2post (post_id, tag_id)
    values (1, 1), (1, 5), (2, 1), (2, 5), (3, 1), (3, 5), (4, 2), (4, 5), (5, 5), (5, 2),
    (7, 2), (7, 5), (7, 3), (8, 2), (8, 3), (8, 5), (9, 2), (9, 3), (9, 5), (10, 2), (10, 3),
    (10, 5), (11, 2), (11, 3), (11, 5);


insert into post_comments (text, time, parent_id, post_id, user_id)
    values ('Курто', '2021-02-28 20:34:45', NULL, 2, 1),
    ('Курто', '2021-02-28 20:34:45', NULL, 2, 2),
    ('Курто', '2021-02-28 20:34:45', NULL, 2, 2),
    ('Курто', '2021-02-28 20:34:45', NULL, 2, 4),
    ('Курто', '2021-02-28 20:34:45', NULL, 10, 2),
    ('Курто', '2021-02-28 20:34:45', NULL, 10, 3),
    ('Курто', '2021-02-28 20:34:45', NULL, 9, 4);


--insert into captcha_codes (code, secret_code, time)
--    values ();

insert into global_settings (code , name, value)
    values ('MULTIUSER_MODE', 'Многопользовательский режим', '1'),
           ('POST_PREMODERATION', 'Премодерация постов', '0'),
           ('STATISTICS_IS_PUBLIC', 'Показывать всем статистику блога', '1');