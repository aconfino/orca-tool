#!/bin/bash

# While is more common than until

# while ! cp $1 $2; do
 # echo "while is waiting for file to copy"
 # sleep 3
# done

until cp $1 $2; do
  echo "until is waiting for file to copy"
  sleep 2
done 
