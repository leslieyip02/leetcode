input="file.txt"
count=0

while IFS= read -r line
do
    ((count++))
    if [[ $count == 10 ]]
    then
        echo "$line"
        break
    fi
done < "$input"

