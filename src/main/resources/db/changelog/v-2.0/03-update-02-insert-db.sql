UPDATE post_comments SET text = 'Первый ком ко второму посту' WHERE id = 1;
UPDATE post_comments SET text = 'Второй ком ко второму посту' WHERE id = 2;
UPDATE post_comments SET text = 'Третий ком ко второму посту' WHERE id = 3;
UPDATE post_comments SET text = 'Четвертый ком ко второму посту' WHERE id = 4;
UPDATE post_comments SET text = 'Первый ком к десятому посту' WHERE id = 5;
UPDATE post_comments SET text = 'Второй ком к десятому посту' WHERE id = 6;
UPDATE post_comments SET text = 'Первый ком к первому ком на второй пост', parent_id = '1' ,post_id = '2' WHERE id = 7;
UPDATE post_comments SET text = 'Первый ком к девятому посту' WHERE id = 8;

UPDATE users SET password = '$2y$12$Nzd36zGRZLoJIbNCQVxMjeBzskvtoQMZZD5bUXbI7Qvf6ProEWaAW' WHERE id = 1; --111111 sasha@email.com
UPDATE users SET password = '$2y$12$eR0QGC9cDv7jxD3ZT2XkC.lojMH8RNy4uObshFZhivpXo6R7gfz8K' WHERE id = 2; --222222 petya@email.com
UPDATE users SET password = '$2y$12$IZvnY.5TF0BHSAx7/3f5COyVypxGv/iRwjJOAs2lkZY3LOw./r4Ee' WHERE id = 3; --333333 katya@email.com
UPDATE users SET password = '$2y$12$eUqgZ5mcB7vtvwwOJiXv5uxJYmzXOuOqeNFZA4AECUHdAEaUHHmii' WHERE id = 4; --444444 irina@email.com

UPDATE global_settings SET value='YES' WHERE value = '1';
UPDATE global_settings SET value='NO' WHERE value = '0';

ALTER TABLE posts DROP CONSTRAINT `FK6m7nr3iwh1auer2hk7rd05riw`;