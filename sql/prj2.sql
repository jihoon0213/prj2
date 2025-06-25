USE prj2;

CREATE TABLE board
(
    id         INT AUTO_INCREMENT NOT NULL,
    title      VARCHAR(255)       NOT NULL,
    content    VARCHAR(10000)     NULL,
    writer     VARCHAR(255)       NOT NULL,
    created_at datetime           NOT NULL DEFAULT NOW(),
    CONSTRAINT pk_board PRIMARY KEY (id)
);

SELECT *
FROM board;

DELETE
FROM board
WHERE id = 2;

