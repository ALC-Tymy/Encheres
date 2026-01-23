---------------------------------------------------------------------------
-- DROP POUR CLEAR BDD
ALTER TABLE PROPOSAL
    DROP CONSTRAINT fk_buyer,fk_article;
ALTER TABLE ARTICLE
    DROP CONSTRAINT fk_seller,fk_category,fk_del_address;
ALTER TABLE ROLES
    DROP CONSTRAINT fk_roles;
DROP TABLE IF EXISTS ROLES,[USER],ARTICLE,PROPOSAL,CATEGORY,DELIVERY_ADDRESS;
---------------------------------------------------------------------------


---------------------------------------------------------------------------
-- CREATION DES TABLES
---------------------------------------------------------------------------

CREATE TABLE [USER]
(
    id_user       BIGINT       NOT NULL PRIMARY KEY IDENTITY (1,1),
    pseudo        VARCHAR(30)  NOT NULL UNIQUE,
    email         VARCHAR(30)  NOT NULL,
    password      VARCHAR(255) NOT NULL,
    first_name    VARCHAR(30)  NOT NULL,
    last_name     VARCHAR(30)  NOT NULL,
    address       VARCHAR(30)  NOT NULL,
    zipcode       VARCHAR(10)  NOT NULL,
    city          VARCHAR(30)  NOT NULL,
    phone         VARCHAR(20)  NOT NULL,
    walletPoint   INTEGER      NOT NULL CHECK (walletPoint >= 0),
    walletPending INTEGER      NOT NULL CHECK (walletPending >= 0),
    actif         BIT          NOT NULL
)

CREATE TABLE ARTICLE
(
    id_article     BIGINT       NOT NULL PRIMARY KEY IDENTITY (1,1),
    name           VARCHAR(30)  NOT NULL,
    description    VARCHAR(500) NOT NULL,
    original_point INTEGER      NOT NULL CHECK (original_point >= 0),
    final_point    INTEGER,
    beginning_date DATETIME2    NOT NULL,
    ending_date    DATETIME2    NOT NULL,
    status         CHAR(2)      NOT NULL CHECK ((status IN ('CR', 'EC', 'VD', 'LV'))),
    id_category    BIGINT       NOT NULL,
    id_del_address BIGINT       NOT NULL,
    id_seller      BIGINT,
    id_buyer       BIGINT
)

CREATE TABLE PROPOSAL
(
    id_proposal    BIGINT    NOT NULL PRIMARY KEY IDENTITY (1,1),
    point_proposal INTEGER   NOT NULL CHECK (point_proposal >= 0),
    date_proposal  DATETIME2 NOT NULL,
    ranking        INTEGER   NOT NULL,
    id_buyer       BIGINT    NOT NULL,
    id_article     BIGINT    NOT NULL
)

CREATE TABLE CATEGORY
(
    id_category BIGINT PRIMARY KEY IDENTITY (1,1),
    name        VARCHAR(30) NOT NULL
)

CREATE TABLE DELIVERY_ADDRESS
(
    id_delivery_address BIGINT PRIMARY KEY IDENTITY (1,1),
    address             VARCHAR(30) NOT NULL,
    zipcode             VARCHAR(10) NOT NULL,
    city                VARCHAR(30) NOT NULL
)


--------------------------------------------------------------------------
--SECURITE--
--------------------------------------------------------------------------

CREATE TABLE [ROLES]
(
    [pseudo] [VARCHAR](30),
    [role]   [VARCHAR](30) NOT NULL
        PRIMARY KEY (pseudo, role)
)


---------------------------------------------------------------------------
-- LIENS ENTRE LES TABLES
---------------------------------------------------------------------------


ALTER TABLE PROPOSAL
    ADD CONSTRAINT fk_buyer FOREIGN KEY (id_buyer) REFERENCES [USER] (id_user)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

ALTER TABLE PROPOSAL
    ADD CONSTRAINT fk_article FOREIGN KEY (id_article) REFERENCES ARTICLE (id_article)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

ALTER TABLE ARTICLE
    ADD CONSTRAINT fk_seller FOREIGN KEY (id_seller) REFERENCES [USER] (id_user)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

ALTER TABLE ARTICLE
    ADD CONSTRAINT fk_category FOREIGN KEY (id_category) REFERENCES CATEGORY (id_category)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

ALTER TABLE ARTICLE
    ADD CONSTRAINT fk_del_address FOREIGN KEY (id_del_address) REFERENCES DELIVERY_ADDRESS (id_delivery_address)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION

ALTER TABLE ROLES
    ADD CONSTRAINT fk_roles FOREIGN KEY (pseudo) REFERENCES [USER](pseudo)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION