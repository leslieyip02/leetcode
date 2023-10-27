SELECT
    machine_id,
    ROUND(AVG(processing_time), 3) as processing_time
FROM
(
    SELECT 
        Starts.machine_id as machine_id,
        Ends.timestamp - Starts.timestamp as processing_time
    FROM (
        SELECT
            machine_id,
            process_id,
            timestamp
        FROM Activity
        WHERE activity_type = "start"
    ) AS Starts
    JOIN (
        SELECT
            machine_id,
            process_id,
            timestamp
        FROM Activity
        WHERE activity_type = "end"
    ) AS Ends
    ON Starts.machine_id = Ends.machine_id
    AND Starts.process_id = Ends.process_id
) As Timestamps
GROUP BY machine_id;
