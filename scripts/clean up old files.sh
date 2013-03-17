#!/bin/bash
find /home/vagrant/test-data/* -mtime +30 -exec rm {} \;

part #1 - find the matching file
part #2 - select files older than 30 days
part #3 - exec the rm command