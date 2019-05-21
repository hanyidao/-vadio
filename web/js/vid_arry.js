// 定义一个数组
//存放视频id的数组
var small_luobo_vid = new Array();
var big_luobo_vid = new Array();

//创建大轮播
function setBigArry(d) {

	for (let i = 0; i < d.data.length; i++) {
		big_luobo_vid.push(d.data[i].vid);
	}

}
//得到大轮播
function getBigArry() {
	return big_luobo_vid;
}



//创建小轮播
function setSmallArry(d) {
	for (let i = 0; i < d.data.length; i++) {
		small_luobo_vid.push(d.data[i].vid);
	}

}
//得到小轮播
function getSmallArry() {
	return small_luobo_vid;
}

//数组对比
function array_diff(a, b){
	for (let i = 0; i < b.length; i++) {
		for (let j = 0; j < a.length; j++) {
			if (a[j] == b[i]) {
				a.splice(j, 1);
				j = j - 1;
			}
		}
	}
	return a;
}
