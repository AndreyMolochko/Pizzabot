#Pizzabot
Pizzabot is a console application, that helps to find solution for pizza delivery.

##Launch
###Windows
1. Unzip downloaded file in *YOUR_DIRECTORY*.
2. Open Command Prompt.

####First way: 
a) Select the Start button.

b) Select the **Windows System** folder from the list.

c) Choose **Command Prompt** from the folder group. 

#####Second way:
a) Run dialog box (**WIN+R**)

b) Enter cmd into the command-line interface.

3. In the command promt you should go to *YOUR_DIRECTORY* where is located your unzip ***pizzabot.jar*** file.
4. In *YOUR_DIRECTORY* you have to enter ***java -jar pizzabot.jar "5x5 (1, 3) (4, 4)"*** 
5. You can enter other points in the parameter.

###macOS
1. Unzip downloaded file in *YOUR_DIRECTORY*.
2. Open terminal.
3. In the terminal you have to go to *YOUR_DIRECTORY* where is located your unzip ***pizzabot.jar*** file.
4. In *YOUR_DIRECTORY* you have to enter ***java -jar pizzabot.jar "5x5 (1, 3) (4, 4)"***
5. You can enter other points in the parameter

##Parameters
You should pass parameters in quotes. You can use this pattern "axb (x_point1, y_point_1) (x_point2, y_point2)" 

where

**a** - a field size in x-dimension.

**b** - a field size in y-dimension.

**x_point1** - location coordinate in x-dimension.

**x_point1** - location coordinate in y-dimension.

##Launch project or tests using IntelliJ IDEA
You should open the project in IntelliJ IDEA and after it run the *main file* or *test* folder.

###Test pizzabot
####Input

```java -jar pizzabot.jar "5x5 (0, 0) (1, 3) (4,4) (4, 2) (4, 2) (0, 1) (3, 2) (2, 3) (4, 1)"```

####Output

```DENNNDEEENDSSDDWWWWSDEEENDWNDEESSD```