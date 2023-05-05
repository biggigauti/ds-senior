### Birgir Gauti Stefánsson
### Dr. Theodore Wendt, Carroll College
### 05/05/2023
### 2023 Data Science Senior Project

This is my Data Science/Computer Science senior project for Carroll College. This is a web application that accept user input in the form of a hand-drawn symbol and evaluates that symbol using my symbol recognition model built using a convolutional neural network.

### Step 1: Pull Project from GitHub

```terminal
$ git clone https://github.com/biggigauti/ds-senior.git
```

### Step 2: Run the program and navigate to the web application

There are two ways to run the application. One of them is using Gradle and the other is using an IDE like IntelliJ. Below I have the instructions for Gradle:

```terminal
$ ./gradlew bootRun
```

For IntelliJ, import the program, make sure Gradle is loaded, build the program, and run the "DsApplication.java" file.

In a browser of your choice, enter "localhost:8080".

### Step 3: Draw and submit

Draw one of the following symbols on the canvas and hit "Submit".

Symbol 0:

<img width="201" alt="image" src="https://user-images.githubusercontent.com/98067108/236564210-7323c905-a17c-4697-b1c4-5cc39c064bd0.png">
Symbol 1:
<img width="201" alt="image" src="https://user-images.githubusercontent.com/98067108/236564231-1d9972c1-a897-4099-bf18-73c3493f3d73.png">
Symbol 2:
<img width="200" alt="image" src="https://user-images.githubusercontent.com/98067108/236564255-cec27f67-7521-4a97-98c9-7507733bb84a.png">
Symbol 3:
<img width="200" alt="image" src="https://user-images.githubusercontent.com/98067108/236564262-db2d7177-f791-43bf-b16b-f5532dc5945c.png">
Symbol 4: 
<img width="201" alt="image" src="https://user-images.githubusercontent.com/98067108/236564271-7016ccae-a2cb-44ff-add7-f9b745383915.png">
Symbol 5:
<img width="200" alt="image" src="https://user-images.githubusercontent.com/98067108/236564287-ef98dbee-ef6d-42de-8330-37ec8295f131.png">
Symbol 6:
<img width="201" alt="image" src="https://user-images.githubusercontent.com/98067108/236564297-25881e58-5be3-433f-a577-5e6d3de1a814.png">


The result will be printed to the console.

I was hoping to link the results back to the web page but due to M1 chip issues I was unable to test this feture. However, what I would have done is take the output from the Python file, assign it to a global variable, and refresh the HTML index page a couple of milliseconds after the user hits submit and use Thymeleaf to dynamically display the results after adding it as an attribute to a Spring model.
