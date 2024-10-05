(SELECT name AS results 
FROM Users U
JOIN MovieRating M 
ON U.user_id = M.user_id
GROUP BY M.user_id 
ORDER BY COUNT(rating) DESC, name 
LIMIT 1) 

UNION ALL 

(SELECT title AS results 
FROM Movies 
JOIN MovieRating 
USING(movie_id) 
WHERE MONTH(created_at) = '02' AND YEAR(created_at) = "2020" 
GROUP BY title 
ORDER BY AVG(rating) DESC, title 
LIMIT 1);