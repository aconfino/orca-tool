#!/bin/bash

filePath[0]='/home'
filePath[1]='/home/vagrant'
filePath[2]='/home/vagrant/scripts'

week=('sun' 'mon' 'tues' 'wed' 'thurs' 'fri' 'sat' 'sun')

for i in "${week[@]}"
do
  echo $i
done

for i in "${filePath[@]}"
do
  echo $i
done
