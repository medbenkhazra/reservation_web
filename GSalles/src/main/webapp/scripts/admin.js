$(document).ready(function() {




	$("#Modifer").click(function() {

		var name = $("#name").val();
		var lastname = $("#lastname").val();
		var email = $("#email").val();
		var login = $("#login").val();
		var pwd = $("#pwd").val();


		$.ajax({
			type: "POST",
			url: "admin.php",
			data: { op: 'ajouter', name: name, lastname: lastname, email: email, login: login, pwd: pwd },
			success: function(response) {
				console.log(name);
			}
		});


	});

});