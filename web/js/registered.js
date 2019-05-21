		function query_user() {
			var str = $("input").val()
			var str1 = {username:$("input").val()};
			console.log(str)
			var ruler = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//正则表达式   邮箱规范
			if (!ruler.test(str.toString())) {
				$("#reg_submit").removeClass().addClass("layui-btn layui-btn-radius layui-btn-disabled");
				if (!str) {
					$("#TiShiPic").css("display", "none");
					$("#TiShiPic p").css("display", "none");
					return false;
				}
				$("#TiShiPic").removeClass().addClass("layui-icon layui-icon-close");
				$("#TiShiPic").css("color", "red");
				$("#TiShiPic").css("display", "block")
				$("#TiShiPic p").text("非有效地址！！！").css("display", "block");
				return false;
			}
			$("#reg_submit").removeClass().addClass("layui-btn layui-btn-radius layui-btn-danger");
			$.ajax({
				type: "POST",
				url: "http://api.pei.com/api/user/user/selectusername",
				contentType:"application/json",
				dataType: "json",
				data: JSON.stringify(str1),
				success: function(data) {
					console.log(data)
					if (data.msg == "用户名正确") {
						$("#TiShiPic").removeClass().addClass("layui-icon layui-icon-close");
						$("#TiShiPic").css("color", "red");
						$("#TiShiPic").css("display", "block");
						$("#TiShiPic p").text("用户已存在！！！").css("display", "block");
					} else if (data.msg == "该用户名不存在") {
						$("#TiShiPic").removeClass().addClass("layui-icon layui-icon-ok").css("color", "lawngreen");
						$("#TiShiPic p").text("正确").css("display", "block");
						$("#TiShiPic").css("display", "block");
						$("#reg_submit").removeClass().addClass("layui-btn layui-btn-radius layui-btn-danger");
					}
				}
			})
		}