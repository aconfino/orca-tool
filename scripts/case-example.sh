#!/bin/bash

DIRECTORY=$1
FILES=$DIRECTORY*

function validate {
   if [ ! -d "$DIRECTORY" ]; then
     echo "Please specify a valid directory"
     exit 1
   fi
}

function checkFileType {

for f in $FILES
  do
    case $f in
        *.jpg )
           echo "$f is a jpeg" ;;
        *.sh )
           echo "$f is a shell file" ;;
        *.txt )
           echo "$f is a text file" ;;
        * )
	   echo "$f is something else" ;;
    esac
done

}

validate
checkFileType
