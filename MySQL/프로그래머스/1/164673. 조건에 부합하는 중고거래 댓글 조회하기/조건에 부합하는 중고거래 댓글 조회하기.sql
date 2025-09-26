SELECT 
b.title as TITLE,
b.board_id as BOARD_ID,
r.reply_id as REPLY_ID,
r.writer_id as WRITER_ID,
r.contents as CONTENTS,
DATE_FORMAT(r.created_date, '%Y-%m-%d') as CREATED_DATE
FROM used_goods_reply as r
INNER JOIN used_goods_board as b
ON r.board_id = b.board_id
WHERE YEAR(b.created_date) = 2022 AND MONTH(b.created_date) = 10
ORDER BY r.created_date, b.title;