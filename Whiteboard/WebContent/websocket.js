var webSocket = new WebSocket('ws://localhost:8080/Whiteboard/websocket');

webSocket.onerror = function(event) {
	onError(event)
};

webSocket.onopen = function(event) {
	onOpen(event)
};

webSocket.onmessage = function(event) {
	onMessage(event)
};

function onOpen(event) {
	//document.getElementById('messages').innerHTML = 'Now Connection established';
}

function onError(event) {
	alert(event.data)
}

function start() {
	var text = document.getElementById("userinput").value;
	webSocket.send(text);
	return false;
}
function broadcastWhiteboardClear(){
	message = "Clear|"; 
	webSocket.send(message);
}
function broadcastWhiteboardUndo(){
	message = "Undo|"; 
	webSocket.send(message);
}
function broadcastWhiteboardRedo(){
	message = "Redo|"; 
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
	message =  "Update|" +
	type + "|" +
	girth.toString() + "|" +
	color + "|" +
	x1.toString() + "|" +
	y1.toString() + "|" +
	x2.toString()  + "|" +
	y2.toString() + "|" ;
	messageConsole.log(message);
	webSocket.send(message);
	
}
function broadcastFreeform(girth, color, arr){ // how to pass an array of x,y,x,y on JS?
	message =  "Update|Freeform|" + 
	girth.toString() + "|" +
	color + "|";
	
	for(i=0; i< arr.length(); i+=2){
		if(i= length-1){
			message = message + arr[i].toString + "|";
		}
		else{
			message = message + arr[i].toString + ",";
		}
	}
	webSocket.send(message);
}



function onMessage(event) {

	// THIS line below is what WAS in onMessage()
	//document.getElementById('messages').innerHTML += '<br />' + event.data;

	MessageTokenArr = event.data.split("|");
	if (MessageTokenArr[0] = "NumUsers"){
		messageConsole.log(MessageTokenArr[0]);
		DisplayNumUsers(parseInt(MessageTokenArr[1]));
	}
	if (MessageTokenArr[0] = "Clear"){
		ClearWhiteboard();
	}
	if (MessageTokenArr[0] = "Redo"){
		RedoWhiteboard();
	}
	if (MessageTokenArr[0] = "Undo"){
		undo();
	}
	//createNetworkShape(type, thickness, color, startX, startY, endX, endY) 
	
	if (MessageTokenArr[0] = "Update"){
		
		if (MessageTokenArr[1] = "Circle"){
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
		if (MessageTokenArr[1] = "Rectangle"){
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
		if (MessageTokenArr[1] = "Triangle"){
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
		if (MessageTokenArr[1] = "Freeform"){
			pointsList = MessageTokenArr[2]// parse in js x,y,x,y
			
			createNetworkShape(
					"Freeform",
					parseFloat(MessageTokenArr[2]), //girth
					parseInt(MessageTokenArr[3]), //color
					pointsList // array of x,y,x,y,x,y
			);
		}

	}	   
}
