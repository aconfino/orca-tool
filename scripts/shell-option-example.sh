#!/bin/bash

# Example of a shell with options

while [ -n "$(echo $1 | grep '-')" ]; do

  case $1 in
    -a ) echo "option -a specified" 
         #shift shifts the args X number of times 
         shift ;;
    -b ) echo "option -b specified"
         shift ;; 
    -c ) echo "option -c specified" 
         shift ;; 
     * ) echo "usage: -a -b -c args..." 
         break ;;
  esac

done

