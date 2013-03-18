#!/bin/bash
OPTIONS="Hello Quit"

echo Please select the number you want
select opt in $OPTIONS; do

if [ "$opt" == "Quit" ]; then
  echo done
  exit
elif [ "$opt" == "Hello" ]; then
  echo Hello World
else
  clear
  echo bad option
fi

done
