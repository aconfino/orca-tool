#!/bin/bash

# Example of getopts 

while getopts ":ab:c" opt; do

  case $opt in

    a ) echo "option -a specified" ;; 
    b ) echo "option -b specified with arg $OPTARG" ;;  
    c ) echo "option -c specified" ;; 
    \? ) echo "usage: foo [-a] [-b barg] [-c] args..." 
         exit 1 
  esac
done

shift $(($OPTIND -1))

echo $1
