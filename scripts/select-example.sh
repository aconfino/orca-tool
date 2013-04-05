#!/bin/bash

week=('Sun' 'Mon' 'Tues' 'Wed' 'Thurs' 'Fri' 'Sat' 'Sun')

function favoriteDay {
  select day in "${week[@]}"; do 
    if [ $day ]; then
      echo "Your favorite day of the week is $day"
      break
    else
      echo "Invalid selection Jack"
    fi

  done
}

echo $week
favoriteDay
