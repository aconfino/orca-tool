#!/bin/bash

function validate {
local intToTest=$1
  if [[ $intToTest != [0-9]* ]]; then
     echo "$intToTest is not an integer"
     echo "exiting..."
     exit 1 
  fi
}

function compare {
  if [ "$firstInt" -eq "$secondInt" ]; then
    echo "$firstInt equals $secondInt"
  fi

  if [ "$firstInt" -gt "$secondInt" ]; then
    echo "$firstInt is greather than $secondInt"
  fi

  if [ "$firstInt" -lt "$secondInt" ]; then
    echo "$firstInt is less than $secondInt"
  fi
}

echo "Type in an integer followed by [ENTER]:"
read firstInt
validate $firstInt

echo "Type in a second integer followed by [ENTER]:"
read secondInt
validate $secondInt
compare

