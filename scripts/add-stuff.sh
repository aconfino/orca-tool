#!/bin/bash

assertInteger(){
  if [[ $1 != [0-9]* ]]
  then 
     echo "Sorry Jack - $1 is not a number."
     exit;
  fi
}

add(){
  local SUM=$(($1 + $2))
  echo "=============="
  echo "$1 + $2 = $SUM"
}

echo "Please enter your first number"
read NUMBER1
assertInteger $NUMBER1
echo "Please enter your second number"
read NUMBER2
assertInteger $NUMBER2
add $NUMBER1 $NUMBER2
