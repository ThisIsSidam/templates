# Random Wallpaper

To randomly change wallpaper..

### 1. The Script

The .sh file is the script to randomly change wallpaper.. change the folder path there if you want.

Put it in `~/.local/bin/`.

Run `chmod +x ~/.local/bin/random-wallpaper.sh` to make it executable.

### 2. The Service

The .service file is the service which runs the script.

Put it in `~/.config/systemd/user/`

Run `systemctl --user daemon-reload` for file rescans.

Run `systemctl --user enable --now random-wallpaper.service` to add the as a service.

### 3. The Timer

The .timer file is what runs the service periodically... change the period in that if you want.

Put it in `~/.config/systemd/user/`. Same as the .service file. 

Run `systemctl --user daemon-reload` for file rescans.

Run `systemctl --user enable --now random-wallpaper.timer` to add the as a service.

Run `systemctl --user list-timers` to check whether the timer was added or not.


