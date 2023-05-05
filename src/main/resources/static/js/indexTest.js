//Grab variables by their ID in HTML template.
const canvas = document.getElementById('drawing-canvas');
const toolbar = document.getElementById('toolbar');
const ctx = canvas.getContext('2d');
const drawing = document.getElementById('drawing-board');

//Variables
let isPainting = false;
let lineWidth = 1;
let startX;
let startY;

//Fill the canvas with white to add a background.
ctx.fillStyle = "white";
ctx.fillRect(0, 0, canvas.width, canvas.height);

//Event listener. Some of this code was sourced from https://www.youtube.com/watch?v=mRDo-QXVUv8.
//I added onto the funciton as I added more buttons. I added the "submit" functionality.
toolbar.addEventListener('click', e => {
    //When button with id "clear" is pressed, clear the rectangle.
    if (e.target.id === 'clear') {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
    }
    //When button with id "submit" is pressed, execute the following code.
    if (e.target.id === 'submit') {
        //Grab image DATA URL
        //base64 image stream
        var image = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream");

        //Define JSON string structure
        const jsonBody = {
            data: image
        };

        //post method
        fetch('http://localhost:8080/', {
            method: 'POST',
            headers: {
                //specify json
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            //turn JSON body into JSON string format
            body: JSON.stringify(jsonBody)
        })
            .then(response => response.json())
            .then(response => console.log(JSON.stringify(response)))
    }
});

//Again, the rest of this code was sources from the link provided above.
const draw = (e) => {
    let canvasOffsetX = canvas.offsetLeft;
    let canvasOffsetY = canvas.offsetTop;

    if(!isPainting) {
        return;
    }

    ctx.lineWidth = lineWidth;
    ctx.lineCap = 'round';

    ctx.lineTo(e.clientX - canvasOffsetX, e.clientY - canvasOffsetY);
    ctx.stroke();
}

canvas.addEventListener('mousedown', (e) => {
    isPainting = true;
    startX = e.clientX;
    startY = e.clientY;
});

canvas.addEventListener('mouseup', e => {
    isPainting = false;
    ctx.stroke();
    ctx.beginPath();
});

canvas.addEventListener('mousemove', draw);
