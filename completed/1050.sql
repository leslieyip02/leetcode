SELECT
    actor_id,
    director_id
FROM (
    SELECT
        actor_id,
        director_id,
        COUNT(*) as times
    FROM ActorDirector
    GROUP BY actor_id, director_id
) AS pairs
WHERE times >= 3;
