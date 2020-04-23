CREATE TABLE songs (
  id SERIAL PRIMARY KEY,
  song_title VARCHAR(255) NOT NULL,
  genre VARCHAR(255) NOT NULL,
  release_year INTEGER NOT NULL,
  explicit_content BOOLEAN NOT NULL
);