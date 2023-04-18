# COMIX - A Comic Book Manager

SWEN 262 Group 6

## Team
* [**Aditya Vikram**](https://github.com/lunarcon)
* [**Andrew Apollo**](https://github.com/AndrewApollo628)
* [**Charlie Luebstorff**](mailto:cjl7292@rit.edu)
* [**Joshua Shaffer**](mailto:jds7626@rit.edu)
* [**Tavish Chen**](mailto:tc3086@g.rit.edu) 

## How to run
* start walking
* walk faster x5
* you are now nunning

## How to run the project
* Run cli/ComixCLI.java

## How to add a new command to the cli
* Create a command in cli/clicmds implementing ICliCmd or extending UndoableCmd depending on if it can be undone. 

* Modify it to fit command requirements. The COMMAND string is what is used to invoke the command by the cli

* if the command is undoable, override the undo method

* Add the new command to the cli/CommandMap.java

## Trello Board
https://trello.com/b/XocrP3sE/swen-262-team-6-board
