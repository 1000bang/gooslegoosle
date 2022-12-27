
let index = {
	init: function() {
	
		$("#btn-partner-join").bind("click", () => {
			this.join
		});
	
	},
	
	join: function(){
		let data = {
			username: $("#username").val(),
			phoneNumber: $("#phonenumber").val(),
			email:  $("#email").val(),
			password: $("#password").val(),
			stroename: $("#storename").val(),
			address: $("#address").val(),
			mainnumber: $("#mainnumber").val(),
		}
	}
	
	
}

index.init();