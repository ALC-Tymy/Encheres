IF OBJECT_ID('tempdb..#Winner') IS NOT NULL DROP TABLE #Winner;

SELECT
    a.id_article,
    a.id_seller,
    p.id_buyer,
    p.point_proposal
INTO #Winner
FROM ARTICLE a
         JOIN PROPOSAL p
              ON p.id_article = a.id_article
                  AND p.ranking = 1
WHERE a.status = 'VD';

UPDATE a
SET a.id_buyer = w.id_buyer,
    a.final_point = w.point_proposal
FROM ARTICLE a
         JOIN #Winner w ON w.id_article = a.id_article;

UPDATE u
SET u.walletPoint = u.walletPoint + w.point_proposal
FROM [USER] u
         JOIN #Winner w ON w.id_seller = u.id_user;

UPDATE u
SET u.walletPending = u.walletPending - w.point_proposal
FROM [USER] u
         JOIN #Winner w ON w.id_buyer = u.id_user;

UPDATE a
SET a.status = 'LV'
FROM ARTICLE a
         JOIN #Winner w ON w.id_article = a.id_article
WHERE a.status = 'VD';
