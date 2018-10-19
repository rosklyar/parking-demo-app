var stompClient = null;

function startConsuming() {
    var socket = new SockJS('/easy-parking');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/parking-state', function (parkingState) {
            showParkingState(parkingState.body);
        });
    });
}

function showParkingState(message) {
    $("#parking").append("<tr><td>" + message + "</td></tr>");
}

