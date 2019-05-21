layui.use('form', function() {

	var form = layui.form;
	//监听提交
	form.on('submit(formDemo)', function(data1) {

		$.ajax({
			type: "POST",
			url: "http://api.pei.com/api/user/user/save",
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify(data1.field),
			success: function(data) {
				alert(data.msg)
				if (data.msg == "注册成功") {
					layer.msg('注册成功,请稍后...')
					var t = setTimeout(function() {
						location.href = "Login.html";
					}, 3500);
				}				
			}
			
		})
		console.log(data.field)
		return false;
	});
});
