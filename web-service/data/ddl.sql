CREATE TABLE method (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        count INTEGER NOT NULL DEFAULT 0,
                        version INTEGER,
                        rule_id INTEGER[] NOT NULL
);

CREATE TABLE rule (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      count INTEGER NOT NULL DEFAULT 0,
                      version INTEGER,
                      content TEXT NOT NULL
);