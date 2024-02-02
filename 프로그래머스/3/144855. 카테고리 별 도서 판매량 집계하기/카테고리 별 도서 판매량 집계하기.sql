-- 코드를 입력하세요
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES S
ON B.BOOK_ID = S.BOOK_ID
WHERE S.SALES_DATE BETWEEN 20220101 AND 20220131
GROUP BY CATEGORY
ORDER BY CATEGORY