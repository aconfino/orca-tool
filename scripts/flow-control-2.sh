#!/bin/bash

filename=$1
word1=$2
word2=$3

function validate {
   if [ -z "$filename" ]; then
     echo "Please specify a filename"
     exit 1
   fi

   if [ -z "$word1" ]; then
    echo "Please specify a word"
    exit 1
   fi

   if [ -z "$word2" ]; then
    echo "Please specify second word"
    exit 1
   fi
}

function contains {
  if grep $word1 $filename || grep $word2 $filename 
  then   
     echo "$filename contains $word1 OR $word2"
  else
     echo "$filename does not contain $word1 OR $word2"
  fi
}

validate
contains
