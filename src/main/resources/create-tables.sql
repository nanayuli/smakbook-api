DROP TABLE IF EXISTS novel_genre, novel_tag, genre, tag, "comment", chapter, volume, novel, alternative_title, author, "user", "role";
DROP TYPE IF EXISTS novel_status, translation_status;

CREATE TYPE novel_status AS ENUM ('скоро', 'видається', 'призупинено', 'завершено');
CREATE TYPE translation_status AS ENUM ('скоро', 'перекладається', 'призупинено', 'завершено');

CREATE TABLE "role"
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE "user"
(
    id SERIAL PRIMARY KEY,
    username VARCHAR(64) NOT NULL UNIQUE,
    password VARCHAR(512) NOT NULL,
    role_id INTEGER REFERENCES "role" (id) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE author
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE novel
(
    id SERIAL PRIMARY KEY,
    author_id INTEGER REFERENCES author (id) NOT NULL,
    translator_id INTEGER REFERENCES "user" (id) NOT NULL,
    cover_image_path VARCHAR(512),
    title VARCHAR(256) NOT NULL,
    description TEXT NOT NULL,
    country VARCHAR(64) NOT NULL,
    release_date DATE NOT NULL,
    novel_status novel_status NOT NULL,
    translation_status translation_status NOT NULL,
    is_published BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE alternative_title
(
    id SERIAL PRIMARY KEY,
    novel_id INTEGER REFERENCES novel (id),
    name VARCHAR(256) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE volume
(
    id SERIAL PRIMARY KEY,
    novel_id INTEGER REFERENCES novel (id) NOT NULL,
    number INTEGER NOT NULL,
    title VARCHAR(128) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now(),
    UNIQUE (novel_id, number)
);

CREATE TABLE chapter_comment
(
    id SERIAL PRIMARY KEY,
    volume_id INTEGER REFERENCES volume (id) NOT NULL,
    number INTEGER NOT NULL,
    title VARCHAR(256) NOT NULL,
    content TEXT NOT NULL,
    is_published BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now(),
    UNIQUE (volume_id, number)
);

CREATE TABLE genre
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE tag
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);

CREATE TABLE novel_genre
(
    novel_id INTEGER REFERENCES novel (id),
    genre_id INTEGER REFERENCES genre (id),
    PRIMARY KEY (novel_id, genre_id)
);

CREATE TABLE novel_tag
(
    novel_id INTEGER REFERENCES novel (id),
    tag_id INTEGER REFERENCES tag (id),
    PRIMARY KEY (novel_id, tag_id)
);

CREATE TABLE "comment"
(
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "user" (id) NOT NULL,
    chapter_id INTEGER REFERENCES chapter (id) NOT NULL,
    content VARCHAR(512) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now()
);
