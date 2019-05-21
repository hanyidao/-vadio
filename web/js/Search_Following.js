
	$(window).scroll(function() {
		//获取距离浏览器顶部距离并赋值th
		var th = $(window).scrollTop();
		//用if判断，距离顶部大于300时给一个警告弹窗
		if (th >= 630) {
			
			$("#Search_bar").show(500);
								

			
		}else{
			$("#Search_bar").hide(500);
		}

	}); 

