$(document).ready(function () {

    $("#login").click(function () {
     
        
  		
  		
	
        $.ajax({
            url: "LoginController",
            data: {login: login, password: password},
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
				console.log("d5uul l success");
              //  remplir(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(textStatus);
            }
        });
	

       

    });
    

 
});

