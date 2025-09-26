SELECT YEAR(a.differentiation_date) as YEAR, (b.YEAR_DEV - a.SIZE_OF_COLONY) as YEAR_DEV, a.ID
FROM ecoli_data a
LEFT OUTER JOIN (
SELECT YEAR(differentiation_date) as YEAR, MAX(size_of_colony) as YEAR_DEV FROM ecoli_data GROUP BY YEAR(differentiation_date)) as b
ON YEAR(a.differentiation_date) = b.year
ORDER BY YEAR, YEAR_DEV