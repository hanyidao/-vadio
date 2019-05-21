
 $("#btn_signin").click(function(){

  var str = {username: $("#user_text").val(),
						pwd: $("#tbPassword").val()}
				$.ajax({
					type: "POST",
					url: "http://api.pei.com/api/user/user/selectAll",
					data: JSON.stringify(str),
					contentType: 'application/json;',
					dataType:"json",
					success: function(data) { //请求成功时的处理
						// var jsonobj = eval("(" + data + ")")
						 console.log(data)
						// console.log(data.data[0].uname);
						if (data) {
              // localStorage.setItem('data',JSON.stringify(data));
							// window.location.href="Home.html";
              document.cookie =JSON.stringify(data);
              
              try {
                if(data.msg=="登录成功"){
                location.href = "Home.html";
              }else if(data.msg=="登录失败"){
                alert(data.msg+"用户名或密码失败！！！");
              }
              } catch (error) {
                alert("与服务器失去联系！！！0.0 请联系管理员");
                
              }
							
						}
					//	console.log(jsonobj);

					}

				});
});
