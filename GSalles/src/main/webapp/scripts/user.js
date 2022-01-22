$(document).ready(function() {
	function login() {
		console.log("d5ul l fct login");
		if ($('#username').val() == "" || $('#password').val() == "") {
			alert("Remplir Les champs Obligatoirement");
			return false;


		} 
		

		var Authdata = {
			username: $('#username').val(),
			password: $('#password').val()
		};
		$.ajax({
			url: "UserController",
			type: "POST",
			data: Authdata,
			dataType: 'JSON',
			success: function(data) {

				if (data.status === true) {
					console.log("raaah success");
					
				}
				else {
					alert("Ce admin est introuvable");
					return false;
				}
			}
		})
	}
	$("#connect").click(function() {
		
		console.log("connect button is clicked");
		login();
	});
});