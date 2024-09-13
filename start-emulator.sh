#!/bin/sh

# Read the number of iterations from the first command-line argument, or default to 1 if not provided
iterations=${1:-1}

for i in $(seq 1 $iterations); do
  emulator @pixel_8 -partition-size 1500 -noaudio -no-boot-anim -netdelay none -no-snapshot -wipe-data -read-only -skin 1080x2160 &
  sleep 70
done
