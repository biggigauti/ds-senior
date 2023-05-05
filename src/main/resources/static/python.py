import sys
import urllib.request
from PIL import Image
import numpy as np
import tensorflow as tf

#Grab the input passed through Java.
input = sys.argv[1]

#Pass the image Data URL to this function which returns the image.
urllib.request.urlretrieve(input, "image")

#open, resize, and convert image to grayscale.
im = Image.open("image")
im = im.resize((16, 16))
im = im.convert("L")

#initialize symbol array, get the grayscale values and normalize them.
symbol = []
gsValue = np.array(im.getdata())
gsValue = gsValue / 255.0
symbol.append(gsValue)
symbol = np.array(symbol)


#fixed pathing
model = tf.keras.models.load_model('src/main/resources/static/myModel')

#answer is a list of lists, need index 0 to properly assess values instead of list of values
#answer is a softmax vector with different probabilities
answer = model.predict(symbol)

highest = 0
counter = 0
highestCounter = 0
#loop through the probabilities and find the index with the highest probability.
for i in range(len(answer[0])):
    counter += 1
    if answer[0][i] > highest:
        highest = answer[0][i]
        highestCounter = counter

#this print is captures by the Java process builder.
print(highestCounter)
