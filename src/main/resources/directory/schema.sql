create table users (
                      id bigint PRIMARY KEY AUTO_INCREMENT,
                      username varchar(100) NOT NULL UNIQUE,
                      password varchar(100) NOT NULL,
                      email varchar(200),
                      picurl varchar(200),
                      created_at timestamp) ;
create table tweet(
                      id bigint(20) AUTO_INCREMENT,
                      user_id bigint(20),
                      content text,
                      created_at timestamp,
                      CONSTRAINT FK_user_id FOREIGN KEY (user_id)
                          REFERENCES users(id),
                      PRIMARY KEY (id)
);

CREATE TABLE friendship(
                           id bigint(20) AUTO_INCREMENT,
                           from_user_id bigint(20),
                           to_user_id bigint(20),
                           created_time timestamp,
                           PRIMARY KEY (id),
                           CONSTRAINT FK_from_user_id FOREIGN KEY (from_user_id)
                               REFERENCES users(id),
                           CONSTRAINT FK_to_user_id FOREIGN KEY (to_user_id)
                               REFERENCES users(id)
);

CREATE TABLE newsfeed(
                           id bigint(20) AUTO_INCREMENT,
                           user_id bigint(20),
                           tweet_id bigint(20) ,
                           created_time timestamp,
                           PRIMARY KEY (id),
                           CONSTRAINT FK_user_id FOREIGN KEY (user_id)
                               REFERENCES users(id),

                           CONSTRAINT FK_tweet_id FOREIGN KEY (tweet_id)
                               REFERENCES tweet(id)
);

