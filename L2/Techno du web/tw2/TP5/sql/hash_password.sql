-- Passage à la version "mots de passe hachés" (empreintes), exercice 2
set search_path = 'authent';
DELETE from users
  where login != 'mallani' and login != 'aporation';

UPDATE users
  set password = '$2y$10$m09t6nVdVgjw/qD7hkowFOd4AWtQI5jukA73Cq0D2mfZM0chMPda2'
  where login='mallani';

UPDATE users
  set password = '$2y$10$//IwI6O9e1YbiSp4W//6v.8s6AOo7w0hqQLhC6PqjSr.dC6.1XmOi'
  where login='aporation';
