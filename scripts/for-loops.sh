#!/bin/bash

for (( i=1 ; i<=12; i++ ))
do
  for (( j=1; j <=12; j++ ))
  do
    # do not output new line and add a tab 
    echo -ne "$(( j * i ))\t"	
  done
  # carriage return 
  echo -e "\r"
done
