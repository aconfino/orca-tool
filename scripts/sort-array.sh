#!/bin/bash

values=(39 5 12 9 3 2 30 4 18 22 1 28 25)
#has the length of the above array 
numvalues=${#values[@]}  

for (( i=0; i<numvalues; i++ )); do
  
  # initially this just holds our index in the array
  # if we find a lower number we'll change this index 
   
  lowestIndex=$1 
  
  # begins looping over the array, skipping the items    
  # we've previously iterated over 
   
  for (( j=i; j<numvalues; j++ )); do
    
    # iterate over this subset, if we
    # find a value less than or equal to
    # the value in the lowest index , we'll use that index 
    
    if [ ${values[j]} -le ${values[$lowest_index]} ]; then
       lowest_index=$j
    fi
  done

  # We are essentially doing a swap here...

  # here is the value of our current position in the array 
  temp=${values[i]}
  # set the next lowest value to our index in the array
  values[i]=${values[lowest_index]}
  # put this value in the index where we pulled out the lowest value 
  values[lowest_index]=$temp
  
done 

for (( int=0; a<numvalues; a++ )); do
  echo -ne "${values[a]}\t" 
done

echo
