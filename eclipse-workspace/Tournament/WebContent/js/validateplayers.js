function validateForm() {
	var player1 = document.getElementById("player1").value;
	var player2 = document.getElementById("player2").value;
	if( player1.length==0 || player2.length==0) {
		alert("Empty field");
		return false;
	}

	else {

		return true;
	}
}