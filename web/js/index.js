/**
 * Created by gs on 2019/4/9.
 */
var c = 0; //轮播第几个图片
var header_menu = document.getElementById("header_menu");
var menu_divs = header_menu.getElementsByTagName("div");
var header = document.getElementById("headeru");
var banner_img = document.getElementById("banner_img");
//右侧菜单效果
for (var i = 0; i < menu_divs.length; i++) {

	var menu_div = menu_divs[i];
	menu_div.index = i;
	menu_div.onmouseover = function() {
		for (var j = 0; j < menu_divs.length; j++) {
			menu_divs[j].className = "";
		}
		this.className = "menu-active";
		$("#banner_img img").eq(this.index).show().siblings("img").hide();
		c = this.index;

	};
}

$('#banner_img img').css("width", $('.list').width()).css("height", 420)
setInterval(function() {
	$("#banner_img img").eq(c).fadeIn(300).siblings("img").fadeOut(300);
	for (var j = 0; j < menu_divs.length; j++) {
		menu_divs[j].className = "";
	}
	menu_divs[c].className = "menu-active";
	c++;
	c = c % 6;
}, 4000)

$(function() {
	var url = location.search; //先获取地址栏的信息（也就是.html后你传过来的字符串）
	var Request = new Object(); //定义一个结果集，方便后面来接收结果

	//判断值信息
	if (url.indexOf("?") != -1) {
		var str = url.substr(1) //去掉?号
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			Request[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}

	//获取id的值，，（如果你传过来的是name属性，那么Request["  "]里面的参数就是填name了）

	$("#user").text(Request["uname"])
	if (Request["uname"]) {

	}

})
