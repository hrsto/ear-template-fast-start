#!/usr/bin/env sh

opts=""

case $1 in
    "build")
        mvn $opts -DskipTests clean package
    ;;
    "test")
        mvn $opts clean test
    ;;
    "clean")
        mvn $opts clean
    ;;
    "verify")
        mvn $opts verify
    ;;
    *) echo "Supply build|test|clean|verify"
    ;;
esac
