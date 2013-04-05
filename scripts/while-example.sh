#!/bin/bash

path=$PATH:

# List all the folders on my path...

  while [ $path ]; do
    # deletes everything after first colon 
    echo ${path%%:*}
    # removes everything before and including the first colon 
    path=${path#*:}
  done

