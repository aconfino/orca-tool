#!/bin/bash

# to get this to stop, press ctrl-z to put the process in the background
# then try kill %1
# that won't work because of the TERM trap, so run kill -KILL %1

trap "echo 'You hit control-c'" INT
trap "echo 'You tried to kill me'" TERM

while true; do
  sleep 60
  echo "Still sleeping"
done

