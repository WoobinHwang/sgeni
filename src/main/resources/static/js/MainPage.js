/**
 * 
 */
function finduser(){
	
	pass = false;
	 
	user = {
		username :  document.getElementById('username').value
		, password :  document.getElementById('password').value
	}
	alert("시작");
	
	$.ajax({
	    url: '/find/account',
	    method: 'post',
	    data : user,
	    dataType : 'json',
	    success: function (data) {
			if(user.password!==data.password){
				alert("패스워드");
				pass = false;
				return pass;
			}else if(user.password==data.password){
				alert("성공")
				pass = true;
				return pass;
			}
	    },
		error:function(data) {
			if(data.username==null){
				alert("null");
				pass = false;
				return pass;
			} else{
				alert("서버 문제")
				pass = false;
				return pass;
			}
        }
	});
	
}