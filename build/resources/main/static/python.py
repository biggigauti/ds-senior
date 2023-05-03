import sys
print(sys.version)
import urllib.request
from PIL import Image
import numpy as np
import tensorflow as tf

input = sys.argv[1]

urllib.request.urlretrieve(input, "image")

im = Image.open("image")
im = im.resize((16, 16))
im = im.convert("L")

symbol = []
gsValue = np.array(im.getdata())
gsValue = gsValue / 255.0
symbol.append(gsValue)
symbol = np.array(symbol)


model = tf.keras.models.load_model('src/main/resources/static/myModel')

answer = model.predict(symbol)

highest = 0
counter = 0
highestCounter = 0
for i in range(len(answer[0])):
    counter += 1
    if answer[0][i] > highest:
        highest = answer[0][i]
        highestCounter = counter

print(highestCounter)
