# Write your MySQL query statement below
WITH top(salary) AS (
    SELECT salary FROM Employee
        GROUP BY salary
        ORDER BY salary DESC
        LIMIT 2
)
SELECT IF(
    (SELECT COUNT(*) FROM top) >= 2,
    salary,
    null
) AS SecondHighestSalary FROM top
ORDER BY salary ASC
LIMIT 1;
