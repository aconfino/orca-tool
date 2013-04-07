#!/bin/bash

stringValue1=10
stringValue2=5	
stringResult=$stringValue1*$stringValue2
echo "Variables are strings by default so the below evalutes to a string"
echo $stringResult

#declares value1 as an integer
declare -i someValue1=10
declare -i someValue2=5
declare -i someResult
someResult=$someValue1*$someValue2
echo "These are declared as ints so we can perform arithmetic operations on them"
echo $someResult

#let intval = express

let a=5+5
let b=3+3
let c=$a+$b
echo "These variables are declared with \"let\" so they are treated as ints"
echo $c
