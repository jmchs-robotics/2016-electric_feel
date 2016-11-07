# Controller Feedback
This [Toast](https://github.com/Open-RIO/ToastAPI) module allows your FIRST Robotics Competition robot to send haptic feedback to your driver(s) through their controller(s).

## Installation
This module can be installed in a project configured to run with [Toast](https://github.com/Open-RIO/ToastAPI) by adding the following to your `build.gradle` file:

```groovy
repositories {
    jcenter()
    maven {
        name = "Toast"
        url = "http://dev.imjac.in/maven"
    }
    maven {
        url  "http://dl.bintray.com/judgementcall5933/toast"
    }
}

dependencies {
    toastModule 'org.usfirst.frc5933:controller_feedback:+' //Depend on Module (deployed to bot and run)
}
```

This will signal to [GradleRIO](https://github.com/Open-RIO/GradleRIO) to download the most recent build of the module, and to deploy it alongside your robot code.
