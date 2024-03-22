#!/bin/bash

words=$(tr ' ' '\12' < words.txt)
unique=$(tr ' ' '\12' < words.txt | sort | uniq)

declare -A frequencies

for i in $unique
do
    count=0
    for j in $words
    do
        if [ $i = $j ]; then
            count=$((count + 1))
        fi
    done
    frequencies[$i]=$count
done

for k in ${!frequencies[@]}
do
    echo $k "${frequencies[$k]}"
done | sort -nrk2
