
CREATE TABLE places (
  place_id int (11) UNSIGNED NOT NULL,
  title VARCHAR(30) NOT NULL,
  description VARCHAR(50) NOT NULL,
  x DOUBLE(11,5) NOT NULL ,
  y DOUBLE(11,5) NOT NULL ,
  zoom DOUBLE(11,5) NOT NULL,
  PRIMARY KEY (place_id),
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)  ENGINE = innoDB
     DEFAULT CHARSET = utf8;

CREATE TABLE mapArea (
  map_id INT(11) UNSIGNED NOT NULL,
  place_id INT (11) UNSIGNED NOT NULL,
  title VARCHAR(30) NOT NULL,
  PRIMARY KEY (map_id),
  CONSTRAINT  FK_map_place FOREIGN KEY (place_id) REFERENCES places (place_id),
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)  ENGINE = innoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE users(
  user_id INT(11) UNSIGNED NOT NULL,
  map_id INT(11) UNSIGNED NOT NULL,
  login VARCHAR(20) NOT NULL,
  password VARCHAR(20) NOT NULL,
  email VARCHAR(20) NOT NULL,
  PRIMARY KEY (user_id),
  CONSTRAINT FK_user_map FOREIGN KEY (map_id) REFERENCES mapArea (map_id),
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE = innoDB
  DEFAULT CHARSET = utf8;



