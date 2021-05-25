<%-- 
    Document   : index
    Created on : 2021-05-14, 11:33:14
    Author     : kasia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../web-components/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>    
    </head>
    <body>
        <script src="../javascript/canvasjs.min.js"></script>
        <script language="javascript" type="text/javascript">
            var applicationContext = '/WebApplication7KK';
            var dataPointsParam = [];
            
            var webSocketTimer = setInterval(doSend, 500);
            
            function drawChart(dataPointsParam) {
                var chart = new CanvasJS.Chart("chartContainer", {
                    title:{
                        text: "Wykres CanvasJS"
                    },
                    axisY:{
                        title: "Oś Y",
                        maximum: 100
                    },
                    data:[{
                        type: "column",
                        dataPoints: dataPointsParam
                    }]
                });
                chart.render();
            }
            
            var wsUri = getRootUri() + applicationContext + "/webSocketEndPointGen";
            function getRootUri() {
                var wsUri = (location.protocol === "http:" ? "ws://":"wss://");
                
                return wsUri + (document.location.hostname === "" ?
                        "localhost" :
                                document.location.hostname) + ":" +
                                (document.location.port === "" ? "8080" :
                                document.location.port);
            }
            function init() {
                drawChart(dataPointsParam);
                output = document.getElementById("output");
                initWebSocket();
            }
            function initWebSocket() {
                websocket = new WebSocket(wsUri);
                websocket.onopen = function(evt) {
                    onOpen(evt);
                };
                websocket.onmessage = function(evt) {
                    onMessage(evt);
                };
                websocket.onerror = function(evt) {
                    onError(evt);
                };
            }
            function onOpen(evt) {
                writeToScreen("CONNECTED");
            }
            function onMessage(evt) {
                writeToScreen("RECEIVED: " + evt.data);
                var dataArrayJSON = JSON.parse(evt.data);
                for(i = 0; i < dataArrayJSON.length; i++) {
                    dataPointsParam[i] = {label:i,y: dataArrayJSON[i]};
                }
                drawChart(dataPointsParam);
                console.log(evt.data);
            }
            function onError(evt) {
                writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
            }
            function doSend(message) {
                writeToScreen("SENT: " + message);
                websocket.send(message);
            }
            function writeToScreen(message) {
                var pre = document.getElementById("messageID");
                pre.value = message;
            }
            
            window.addEventListener("load", init, false);
        </script>
        
        <div class="container">
            <h3 class="text-center mb-3">WebSocket bez JSON</h3>
            <hr>
            <div style="text-align: center">
                <div id="chartContainer"></div>
                <form class="info" action="">

                    <input id="textID" class="align-middle" name="message" value="Hello WebSocket!" type="text">
                    <input onclick="doSend(textID.value)" value="Wyślij" type="button" class="btn btn-info">
                    <br>
                    <input id="messageID" name="messageInfo" value="" type="text" size="30">
                </form>
            </div>
            <div id="output"></div>
        </div>
    </body>
</html>
