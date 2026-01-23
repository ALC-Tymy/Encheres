

CREATE TABLE [USER] (
                        id_user BIGINT NOT NULL PRIMARY KEY IDENTITY(1,1),
                        pseudo VARCHAR(30) NOT NULL UNIQUE,
                        email VARCHAR(30) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        first_name VARCHAR(30) NOT NULL,
                        last_name VARCHAR(30) NOT NULL,
                        address VARCHAR(30) NOT NULL,
                        zipcode VARCHAR(10) NOT NULL,
                        city VARCHAR(30) NOT NULL,
                        phone VARCHAR(20) NOT NULL,
                        walletPoint INTEGER NOT NULL CHECK(walletPoint >= 0),
                        walletPending INTEGER NOT NULL CHECK(walletPending >= 0),
                        actif BIT NOT NULL
)

CREATE TABLE ARTICLE(
                        id_article BIGINT NOT NULL PRIMARY KEY IDENTITY(1,1),
                        name VARCHAR(30) NOT NULL,
                        description VARCHAR(500) NOT NULL,
                        original_point INTEGER NOT NULL CHECK (original_point>=0),
                        final_point INTEGER,
                        begginning_date DATETIME2 NOT NULL,
                        status CHAR(2) NOT NULL CHECK((status IN ('CR', 'EC', 'VD', 'LV')))
)

CREATE TABLE PROPOSAL (
                          id_proposal BIGINT NOT NULL PRIMARY KEY IDENTITY(1,1),
                          point_proposal INTEGER NOT NULL CHECK (point_proposal >= 0),
                          date_proposal DATETIME2 NOT NULL,
                          is_number_one BIT NOT NULL
)

CREATE TABLE CATEGORY (
                          id_category BIGINT NOT NULL PRIMARY KEY IDENTITY(1,1),
                          name VARCHAR(30) NOT NULL
)

CREATE TABLE DELIVERY_ADDRESS (
                                  id_delivery_address BIGINT NOT NULL PRIMARY KEY IDENTITY(1,1),
                                  address VARCHAR(30) NOT NULL,
                                  zipcode VARCHAR(10) NOT NULL,
                                  city VARCHAR(30) NOT NULL
)

ALTER TABLE PROPOSAL
    ADD CONSTRAINT fk_user_proposal FOREIGN KEY (id_user) REFERENCES [USER](id_user)
        ON DELETE NO ACTION
        ON UPDATE no action

ALTER TABLE PROPOSAL
    ADD CONSTRAINT fk_article_proposal FOREIGN KEY (id_article) REFERENCES ARTICLE(id_article)
        ON DELETE NO ACTION
        ON UPDATE no action

ALTER TABLE ARTICLE
    ADD CONSTRAINT fk_article_category FOREIGN KEY (id_category) REFERENCES CATEGORY(id_category)
        ON DELETE NO ACTION
        ON UPDATE no action

ALTER TABLE ARTICLE
    ADD CONSTRAINT fk_article_delibery_address FOREIGN KEY (id_del_address) REFERENCES DELIVERY_ADDRESS(id_del_address)
        ON DELETE NO ACTION
        ON UPDATE no action