const canvas = document.getElementById('drawing-canvas');
const toolbar = document.getElementById('toolbar');
const ctx = canvas.getContext('2d');
const drawing = document.getElementById('drawing-board');

let isPainting = false;
let lineWidth = 2;
let startX;
let startY;

ctx.fillStyle = "white";
ctx.fillRect(0, 0, canvas.width, canvas.height);

toolbar.addEventListener('click', e => {
    if (e.target.id === 'clear') {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
    }
    if (e.target.id === 'submit') {
        var image = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream");

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
            body: JSON.stringify(jsonBody)
        })
            .then(response => response.json())
            .then(response => console.log(JSON.stringify(response)))
    }
});

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