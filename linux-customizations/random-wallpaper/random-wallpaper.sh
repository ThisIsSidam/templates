#!/usr/bin/env bash

# Folder containing wallpapers
WALLPAPER_DIR="$HOME/Pictures/wallpapers"

# Get all wallpapers into an array
wallpapers=("$WALLPAPER_DIR"/*)

# Pick a random one
RANDOM=$$$(date +%s)   # reseed random using PID + time
choice=${wallpapers[$RANDOM % ${#wallpapers[@]}]}

# Kill old swaybg and set new wallpaper
pkill swaybg
swaybg -i "$choice" -m fill &
