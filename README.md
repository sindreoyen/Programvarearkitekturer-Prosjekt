# Rocket Racer
This is project is part of the course TDT4240 Software Architecture at NTNU. This android application is group 21 project and is created based on a predefined architecture
created during the requirements and architecture phase. 

## How to run and build

To build the application use the command`./gradlew build` for mac or linux or `.\gradlew build` for windows power shell in the command line. 
Using the android studio editor, Make Project will also build the project. 

The project can be run using an emulated android device or a physical device.
In android studio an emulated device can be created with the device manager and it runs with the android module.
When the android emulator is configured select android in the run configurations and run the application.

There has been provided an APK file which is located in the root repository. This can also be used to run
the application. It is called android-debug.apk and can be dragged onto a running emulator or physical device to install it.
The game is called rocket-racer and has the LibGDX symbol.

The application can be run using the desktop module, but is not recommended as it scales poorly. It can
however be ok to test small changes fast in a development environment.

If you are having trouble building or running the application a more detailed guide can be 
found at the [android developer site](https://developer.android.com/studio/run).

It is recommended to use a newer phone or emulator as the game scales poor on screens smaller than 5" and a resolution lower than full hd 1080x1920.
The application has been tested on android emulators using API 30 and newer.

Some tests have been created, which can be run using `./gradlew test`.
Android studio can also display coverage by right clicking the test folder and pressing run test in tdt4240-g21 with coverage.



## About the application
The application is a game where the player controls a rocket and the goal is to stay on course towards
outer space as long as possible. The rocket has a fuel level which decreases when hitting objects.
As the player progresses upwards the obstacles change and become harder to maneuver around.

There are two game modes: single player and multiplayer. Single player is only you
where you can enjoy the game offline. In multiplayer mode the user is offered to initiate a game
and joining users enter the game pin provided to the host. They can then compete and the goal is
to get the highest possible score and enter the high score list.

## Structure
The code is structured using three modules: desktop, core and android. There are also other packages like
gradle which contain the configuration files and assets which contain images and other similar resources.
There can be found detailed class diagrams in the [documentation directory](/documentation/com/rocketracer/game).
Plant UML code and png files are provided.


### Core
Core is where the business logic lies together with the controllers and views. Its structure is 
highly affected by using the Entity Component System and the Model View Controller architectural
patterns. There are packages for controllers and views for the MVC pattern and there is an ECS package
used to structure the ECS pattern setup. The ECS package contains Components, Entities and Systems.
The Entity package contains the code for the game objects, the Component package for the logic used
by the objects (or entities) and the System package defines the code that work on all the entities which
contain certain components. There is also code for the factory pattern in code, located in the factory-package.
The SharedData package contains classes that are used throughout the system, including some that use the
singleton pattern.


### Android
The android module is used to run the application on android and the important classes are the AndroidLauncher
which initiate the game on the android device and the Firebase classes which are used towards storing data
remote in the cloud.

### Desktop
The desktop module is used to run the application on desktop and the important class is the DesktopLauncher.


To provide an overview of the structure we have provided the main overview of the application used when describing the logical view.

<img width="1000" src = "/documentation/com/rocketracer/game/LogicalView.png"> 

## Resources
We have used some resources during our development process as we were all new to LibGDX.
The sources we have found most inspiration are listed below.

A game development blog using Ashley ECS:

John Day. (2017). "Full LibGDX Game Tutorial - Entities using Ashley(ECS)". Web: [https://www.gamedevelopment.blog/full-libgdx-game-tutorial-entities-ashley/](https://www.gamedevelopment.blog/full-libgdx-game-tutorial-entities-ashley/)
/Accessed 22.04.23

A public github repo using Ashley:

Daniel Platon (2017). "Obstacle Course". Web: [https://github.com/dplaton/obstacle-course](https://github.com/dplaton/obstacle-course)/Accessed 22.04.23


