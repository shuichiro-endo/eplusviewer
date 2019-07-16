# E+Viewer

ELF(Executable and Linkable Format) File Viewer


## Summary

This tool is ELF File Viewer.

Few years ago(2015), I created this tool to learn ELF File.


## Cautions

<font style="color:red;font-size:150%">
This tool needs huge main memory(About 2GB main memory per 1MB file).<br>
Do not open a file over 1MB.<br>
</font>


## Installation

This tool can run on an environment that is installed Java8.

- Java version 1.8.0_60(JRE)
    - <font style="color:blue">Note: This tool uses JavaFX 8.</font>


## Example
1. Run
    ```
    java -Xmx4g -jar "E+Viewer2.0.0.jar"
    ```
1. Open ELF File([File]-[FileOpen])


## Screenshot

![001.png](./image/001.png)

![002.png](./image/002.png)

![003.png](./image/003.png)


## Additional Functions

You can use some functions if you input the following key in InputKey Dialog([Help]-[InputKey]).

- Key
    ```
    59bd99714b29f807723ad6aa3c6d9848d14a3074c253b94a1d2f7823ef5c9bf2
    ```
- Additional Functions
    - File Export
    - Binary Edit
    - ReRun
    - Dump
    - Disasm
        - <font style="color:blue">Note: You need to install objdump.</font>


## Develop

I develped this tool on the following environment.

- Windows 8.1 Pro(Japanese)
- Java version 1.8.0_60
- Eclipse IDE for Java Developers Mars.1 Release(4.5.1)
- e(fx)clipse
- JavaFX Scene Builder 2.0
