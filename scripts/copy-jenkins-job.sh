#!/bin/bash

jobName=$1
fromJenkinsHome=$2
toJenkinsHome=$3
counter=0

if [ -z "$jobName" ]
  then
    echo "Please provide a job name"
    exit 1
fi

if [ -z "$fromJenkinsHome" ]
  then
    echo "Please provide the Jenkins home directory you are copying from"
    exit 1
fi

if [ -z "$toJenkinsHome" ]
  then
    echo "Please provide the Jenkins home directory that is the destination"
    exit 1
fi

for file in $(ls -d $fromJenkinsHome/jobs/*$jobName*); do
   cp -r $file $toJenkinsHome/jobs
   echo "Copied $file to " 
   echo "$toJenkinsHome/jobs"
   counter=$(( $counter + 1 ))
done

echo "Copied $counter jobs"
