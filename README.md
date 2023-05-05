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

```terminal
$ ./gradlew bootRun
```

In a browser of your choice, enter "localhost:8080".

### Step 3: Draw and submit

Draw one of the following symbols on the canvas and hit "Submit".

The result will be printed to the console.

I was hoping to link the results back to the web page but due to M1 issues I was unable to test this feture. However, what I would have done is take the output from the Python file, assign it to a global variable, and refresh the HTML index page a couple of milliseconds after the user hits submit and use Thymeleaf to dynamically display the results after adding it as an attribute to a Spring model.
