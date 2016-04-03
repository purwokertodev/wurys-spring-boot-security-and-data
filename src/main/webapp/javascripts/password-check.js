//form registration validation for password
function checkPassword(){
	var pass1 = document.getElementById('pwd1');
    var pass2 = document.getElementById('pwd2');
	var submitButton = document.getElementById('sm_button');
    //Store the Confimation Message Object ...
    var message1 = document.getElementById('confirmMessage');
	var message2 = document.getElementById('passwordLengthMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
	
	if(pass1.value.length < 8){
		pass1.style.backgroundColor = badColor;
        message2.style.color = badColor;
        message2.innerHTML = "password should be at least 8 digits !!"
		submitButton.disabled = true;
	}else{
		pass1.style.backgroundColor = goodColor;
		message2.innerHTML = ""
		if(pass1.value == pass2.value){
			pass2.style.backgroundColor = goodColor;
			message1.style.color = goodColor;
			message1.innerHTML = "Passwords Match!"
			submitButton.disabled = false;
		}else{
			pass2.style.backgroundColor = badColor;
			message1.style.color = badColor;
			message1.innerHTML = "Passwords Do Not Match!"
			submitButton.disabled = true;
		}
	}
}

//login form validation

function checkLoginForm(){
	var email = document.getElementById('email');
	var pwd = document.getElementById('pwd');
	var loginButton = document.getElementById('login_button');
	
	if(email.value.length > 0 && pwd.value.length > 0){
		loginButton.disabled = false;
	}else{
		loginButton.disabled = true;
	}
}



 