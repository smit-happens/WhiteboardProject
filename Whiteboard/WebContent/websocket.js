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
			document.getElementById('messages').innerHTML = 'Now Connection established';
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
			  function broadcastCircle(radius, centerX, centerY, girth, color){
			   message = "update|Circle|" +
			       radius.toString() + "|" +
			       centerX.toString() + "|" +
			       centerY.toString() + "|" +
			       girth.toString() + "|" +
			       color.toString();
			   webSocket.send(message);
			  }
			  function broadcastRectangle(topLeftX, topRightY, width, height, girth, color){
			   message =  "update|Rectangle|" +
			      topLeftX.toString() + "|" +
			      topRightY.toString() + "|" +
			      width.toString() + "|" +
			      height.toString() + "|" +
			      girth.toString() + "|" +
			         color.toString();
			   webSocket.send(message);
			  }
			  function broadcastTriangle(topX, topY, base, height, girth, color){
			   message =  "update|Triangle|" +
			      topX.toString() + "|" +
			      topY.toString() + "|" +
			      base.toString() + "|" +
			      height.toString() + "|" +
			      girth.toString() + "|" +
			         color.toString();
			   webSocket.send(message);
			  }
			  
			  
			 
			  function onMessage(event) {

			   // THIS line below is what WAS in onMessage()
			   //document.getElementById('messages').innerHTML += '<br />' + event.data;
			   
			   MessageTokenArr = event.data.split("|")
			   if (MessageTokenArr[0] = "NumUsers"){
			    DisplayNumUsers(parseInt(MessageTokenArr[1]));
			   }
			   if (MessageTokenArr[0] = "Clear"){
			    ClearWhiteboard();
			   }
			   if (MessageTokenArr[0] = "Redo"){
			    RedoWhiteboard();
			   }
			   if (MessageTokenArr[0] = "Undo"){
			    UndoWhiteboard();
			   }
			 
			   if (MessageTokenArr[0] = "Update"){
			    if (MessageTokenArr[1] = "Circle"){
			     drawCircle(
			       parseFloat(MessageTokenArr[2]), //radius
			       parseInt(MessageTokenArr[3]), //CenterX
			       parseInt(MessageTokenArr[4]), //CenterY
			       parseFloat(MessageTokenArr[5]), //girth
			       parseFloat(MessageTokenArr[6]) //color
			       )
			    }
			    if (MessageTokenArr[1] = "Rectangle"){
			     drawRectangle(
			       parseInt(MessageTokenArr[2]), //TopLeftX
			       parseInt(MessageTokenArr[3]), //TopLeftY
			       parseFloat(MessageTokenArr[4]), //width
			       parseFloat(MessageTokenArr[5]), //height
			       parseFloat(MessageTokenArr[6]), //girth
			       parseFloat(MessageTokenArr[7]) //color
			       )
			    }
			    if (MessageTokenArr[1] = "Triangle"){
			     drawTriangle(
			       parseInt(MessageTokenArr[2]), //TopX
			       parseInt(MessageTokenArr[3]), //TopY
			       parseFloat(MessageTokenArr[4]), //base
			       parseFloat(MessageTokenArr[5]), //height
			       parseFloat(MessageTokenArr[6]), //girth
			       parseFloat(MessageTokenArr[7]) //color
			       )
			    }
			    
			   }	   
			  }
