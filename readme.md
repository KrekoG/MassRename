# MassRename

A java command line tool to rename files and subfolders of a selected directory with a disrespectful TUI.
It was created to eliminate the leftover directories generated by @zurb/foundation-cli, since some of them happen to be too long for windows to handle. (It is otherwise awesome, give it a try, it's [free](http://foundation.zurb.com/ "Zurb/Foundation") and [open source](https://github.com/zurb/foundation-cli "Foundation CLI").

## Requirements

You will need:

1. A terminal/command line
2. [java runtime environment](https://www.java.com/en/download/ "Download the freshest!") - which you more than likely already have. To check, you can follow the link to the download site, then click `Do I have Java?` under the download button.
3. The [MassReadme.jar](https://github.com/KrekoG/MassRename/releases/tag/v1.0.1 "version v1.0.1 Ash") itself

## Using MassRename

To run, type:
```
java -jar MassRename.jar
```
The first parameter takes the path of the target directory, in case it is not launched from there:
```
java -jar MassRename.jar C:\Direct\Path\To\Target\Directory
```

>Be careful when running MassRename, as it will rename *everything* it has access to in the target folder.
>I'm not responsible for the damage you cause with incautious usage!
>
>Or really any kind of usage.
