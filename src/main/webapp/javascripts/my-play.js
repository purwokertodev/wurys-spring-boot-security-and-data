function checkCommentForm(){
	var name = document.getElementById('commentatorName');
	var content = document.getElementById('commentContent');
	var submitButton = document.getElementById('post_comment_button');

	if(name.value.length > 0 && content.value.length > 0){
		submitButton.disabled = false;
	}else{
		submitButton.disabled = true;
	}
}