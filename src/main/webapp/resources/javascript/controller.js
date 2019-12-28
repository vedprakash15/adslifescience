$(document).ready(function() {

	$("#form1").submit(function(event) {

		// stop submit the form, we will post it manually.
		// event.preventDefault();

		fire_ajax_submit();

	});

});
/*
 * function fire_ajax_submit(){ alert("AJAX fire"); }
 */
function fire_ajax_submit() {
	var user = document.getElementById('username').value;
	var emailId = document.getElementById('emailid').value;
	//alert("User Name " + user + " Email id : " + emailId);
	// $("#submit").prop("disabled", true);
    var data = {
            username : user,
            email : emailId
        };
    var jsonData = JSON.stringify(data);
	$.ajax({
		type : "POST",
		contentType: "application/json",
		url : "http://localhost:8080/august/api/db/post-api",
		data : jsonData,
        //data : $('form1').serialize(),
		dataType : 'json',
		// cache : false,
		// timeout : 600000,
		success : function(data) {
			console.log("SUCCESS : ", data);
		}
	});
}

function getFormData() {

	var id = document.getElementById('id');
	console.log("id : " + id);
	alert("getFormData js method called");
	$.ajax({
		url : 'http://localhost:8080/august/api/db/get-column',
		data : $('form').serialize(),
		success : function(data) {
			$('#result').html(data);
			console.log("data : " + data);
			console.log("response " + response);
		},
		error : function(e) {
			console.log("Error : " + data);
		}
	});
}