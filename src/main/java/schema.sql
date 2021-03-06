CREATE TABLE user (
  user_id BIGINT(20) NOT NULL,
  username VARCHAR(100) NOT NULL,
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)
);

CREATE TABLE message (
  message_id BIGINT(20) NOT NULL,
  writtenBy BIGINT(20) NOT NULL,
  insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (message_id)
);