var stompClient = null;

function startConsuming() {
    var socket = new SockJS('/easy-parking');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/parking-state/live', function (deviceInfos) {
            showParkingState(JSON.parse(deviceInfos.body));
        });
    });
}

function getBgColor(state) {
    if(state == 0) {
        return "green";
    } else {
        return "red";
    }
}

function getAvailability(state) {
    if(state == 0) {
        return "Free";
    } else {
        return "Occupied";
    }
}

function showParkingState(deviceInfos) {
    $("#parking").empty();
    deviceInfos.forEach(function(deviceInfo){
        $("#parking").append("<thead>");
        $("#parking").append("<tr>");
        $("#parking").append("<th>" + deviceInfo.alias + "</th>");
        $("#parking").append("</tr>");
        $("#parking").append("</thead>");
        $("#parking").append("<tr>");
        $("#parking").append("<td bgcolor='" + getBgColor(deviceInfo.parking) + "' align='center'> " + getAvailability(deviceInfo.parking) + " </td>");
        $("#parking").append("<td>" + deviceInfo.deviceId + "</td>");
        $("#parking").append("<td>" + deviceInfo.time + "</td>");
        $("#parking").append("</tr>");
    });
}
