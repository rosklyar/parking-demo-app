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

function showParkingState(places) {
    $("#parking").empty();
    places.forEach(function(place){
        $("#parking").append("<tr>");
        $("#parking").append("<td>DevEui: " + place.deviceId + "</td>");
        $("#parking").append("<td>Battery: " + place.battery + "</td>");
        $("#parking").append("<td>State: " + place.parking + "</td>");
        $("#parking").append("</tr>");
    });
}

