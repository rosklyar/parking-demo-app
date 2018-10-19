var stompClient = null;

function startConsuming() {
    var socket = new SockJS('/easy-parking');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/parking-state', function (parkingState) {
            showParkingState(JSON.parse(parkingState.body).places);
        });
    });
}

function showParkingState(places) {
    $("#parking").empty();
    places.forEach(function(place){
        $("#parking").append("<tr>");
        $("#parking").append("<td>Row: " + place.row + "</td>");
        $("#parking").append("<td>Column: " + place.column + "</td>");
        $("#parking").append("<td>State: " + place.state + "</td>");
        $("#parking").append("</tr>");
    });
}

