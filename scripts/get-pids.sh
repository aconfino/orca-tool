#!/bin/bash

my_array=( $(ps -ef | grep vagrant | cut -c10-15) )

#has the length of the above array
array_length=${#my_array[@]}

for pid in "${my_array[@]}"; do
  
  #make sure it's an integer
  if  [[ "$pid" =~ ^[0-9]+$ ]] ; then
    echo "$pid is integer"
  fi
done

vagrant_array=( $(ps eaxo pid,etime,cmd,user | grep vagrant | cut -c1-5) )

for vagrant_pid in "${vagrant_array[@]}"; do
   echo "$vagrant_pid"
done

