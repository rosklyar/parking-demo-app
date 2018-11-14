var stompClient = null;

function startConsuming() {
    var socket = new SockJS('/easy-parking');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/parking-state', function (parkingState) {
            showParkingState(JSON.parse(parkingState.body));
        });
    });
}

function showParkingState(allDeviceInfos) {
    $("#parking").empty();
    allDeviceInfos.forEach(function(deviceInfos){
        $("#parking").append("<thead>");
        $("#parking").append("<tr>");
        $("#parking").append("<th>" + deviceInfos[0].deviceId + "</th>");
        $("#parking").append("</tr>");
        $("#parking").append("</thead>");
        deviceInfos.forEach(function(deviceInfo){
            $("#parking").append("<tr>");
            $("#parking").append("<td>Battery: " + deviceInfo.battery + "</td>");
            $("#parking").append("<td>State: " + deviceInfo.parking + "</td>");
            $("#parking").append("<td>Frame type: " + deviceInfo.frameType + "</td>");
            $("#parking").append("<td>Time: " + deviceInfo.time + "</td>");
            $("#parking").append("</tr>");
        });
    });
}

