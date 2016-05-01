var webSocket = new WebSocket('ws://localhost:8080/Whiteboard/websocket');

webSocket.onerror = function(event) {
	onError(event)
};

webSocket.onopen = function(event) {
	onOpen(event)
};

webSocket.onmessage = function(event) {
	onMessage(event.data)
};

function onOpen(event) {
	//document.getElementById('messages').innerHTML = 'Now Connection established';
	
}

function onError(event) {
	alert(event.data)
}

function start() {
	//var text = document.getElementById("userinput").value;
	webSocket.send(text);
	return false;
}
function broadcastWhiteboardClear(){
	var message = "Clear|";
	webSocket.send(message);
}
function broadcastWhiteboardUndo(){
	var message = "Undo|";
	webSocket.send(message);
}
function broadcastWhiteboardRedo(){
	var message = "Redo|";
	webSocket.send(message);
}

function broadcastLogin(email, pwrdHash) {
	var message = "Login|";
	message += email + "|";
	message += pwrdHash +"|";
	webSocket.send(message);
}

function broadcastLogout(email) {
	var message = "Logout|";
	message += email + "|";
	webSocket.send(message);
}



/*
function broadcastCircle(girth, color, x1, y1, x2, y2){
	message = "Update|Circle|" +
	girth.toString() + "|" +
	color.toString() + "|" +
	x1.toString() + "|" +
	y1.toString() + "|" +
	x2.toString()  + "|" +
	y2.toString() + "|" ;
	webSocket.send(message);
}
function broadcastRectangle(girth, color, x1, y1, x2, y2){
	message =  "Update|Rectangle|" +
	girth.toString() + "|" +
	color.toString() + "|" +
	x1.toString() + "|" +
	y1.toString() + "|" +
	x2.toString()  + "|" +
	y2.toString()+ "|" ;
	webSocket.send(message);
}
function broadcastTriangle(girth, color, x1, y1, x2, y2){
	message =  "Update|Triangle|" +
	girth.toString() + "|" +
	color.toString() + "|" +
	x1.toString() + "|" +
	y1.toString() + "|" +
	x2.toString()  + "|" +
	y2.toString() + "|" ;
	webSocket.send(message);
}
*/
function broadcastShape(type, girth, color, x1, y1, x2, y2){
	var message =  "Update|" +
	type + "|" +
	girth.toString() + "|" +
	color + "|" +
	x1.toString() + "|" +
	y1.toString() + "|" +
	x2.toString()  + "|" +
	y2.toString() + "|" ;
	webSocket.send(message);
	
}
function broadcastFreeform(girth, color, points){ // how to pass an array of x,y,x,y on JS?
	var message =  "Update|Freeform|" +
	girth.toString() + "|" +
	color + "|";
	
	//for(var i=0; i< arr.length(); i+=2){
	//	if(i== length-1){
	//		message = message + arr[i].toString + "|";
	//	}
	//	else{
	//		message = message + arr[i].toString + ",";
	//	}
	//}

	for(var i=0; i<points.length-1; i++) {
        //loop over points
        message += points[i].getX() + "," + points[i].getY() +"|";
    }

   // message += points[points.length-1].getX() + "," + points[points.length-1].getY();
    //messageConsole.log(message);

	webSocket.send(message);
}



function onMessage(msg) {

	// THIS line below is what WAS in onMessage()
	//document.getElementById('messages').innerHTML += '<br />' + event.data;
	//messageConsole.log(event.data);
	var MessageTokenArr = msg.split("|");
	//console.log(msg);
	
	if (MessageTokenArr[0] === "NumberUsers"){
		DisplayNumUsers(MessageTokenArr[1]);
	}
	else if (MessageTokenArr[0] === "Clear"){
			clearCanvasOnMessage();
	}
	else if (MessageTokenArr[0] === "Redo"){
		redo();
	}
	else if (MessageTokenArr[0] === "Undo"){
		undo();
	}
	else if(MessageTokenArr[0] === "InvalidPassword"){
		messageConsole.log("InvalidPassword");
	}
	else if(MessageTokenArr[0] === "InvalidEmailAccount"){
		messageConsole.log("InvalidEmailAccount");
	}
	else if(MessageTokenArr[0] === "AccountExists"){
		messageConsole.log("AccountExists");
	}
	else if(MessageTokenArr[0] === "AccountCreated"){
		messageConsole.log("AccountCreated");
	}
	else if (MessageTokenArr[0] === "Update"){
		
		if (MessageTokenArr[1] === "Circle"){
			createNetworkShape(
					"Circle",
					parseFloat(MessageTokenArr[2]), //girth
					MessageTokenArr[3], //color
					parseInt(MessageTokenArr[4]), //x1
					parseFloat(MessageTokenArr[5]), //y1
					parseFloat(MessageTokenArr[6]), // x2
					parseFloat(MessageTokenArr[7]) // y2
			);
		}
		else if (MessageTokenArr[1] === "Rectangle"){
			createNetworkShape(
					"Rectangle",
					parseFloat(MessageTokenArr[2]), //girth
					MessageTokenArr[3], //color
					parseInt(MessageTokenArr[4]), //x1
					parseFloat(MessageTokenArr[5]), //y1
					parseFloat(MessageTokenArr[6]), // x2
					parseFloat(MessageTokenArr[7]) // y2
			);
		}
		else if (MessageTokenArr[1] === "Triangle"){
			createNetworkShape(
					"Triangle",
					MessageTokenArr[2], //girth
					MessageTokenArr[3], //color
					MessageTokenArr[4], //x1
					MessageTokenArr[5], //y1
					MessageTokenArr[6], // x2
					MessageTokenArr[7] // y2
			);
		}
		else if (MessageTokenArr[1] === "Freeform"){
            var pointsList = MessageTokenArr.slice(4);
            //console.log(pointsList);
            var outputList = [];
            //var debugStr = "WEBSOCKET : ";

            for(var i=0; i<pointsList.length-1; i++) {
                var xy = pointsList[i].split(",");
                var p = new Point(parseInt(xy[0]), parseInt(xy[1]));
                outputList[i] = p;
               // debugStr += "(" + p.getX() + "," + p.getY() + ") | ";
            }
			console.log("First point received was (" + outputList[0].getX() + "," + outputList[0].getY() +")");
			console.log("Last point received was (" + outputList[outputList.length-1].getX() + "," + outputList[outputList.length-1].getY() +")");
            //console.log("Point list length " + outputList.length);
            //console.log(debugStr);
            createFreeformShape(MessageTokenArr[2],
                MessageTokenArr[3], outputList);
            return outputList;
		}

	}
}