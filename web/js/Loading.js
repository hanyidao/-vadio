			layui.use('flow', function() {
				var flow = layui.flow;
				flow.load({
					elem: '#init_pic', //流加载容器	
					//scrollElem: '#init_pic', //滚动条所在元素，一般不用填，此处只是演示需要。
					done: function(page, next) { //执行下一页的回调
						//模拟数据插入
						setTimeout(function() {
							var lis = [];
							for (var i = 0; i < 4; i++) {
								lis.push('<li> <div><img id="loading" src="Products/p_' + ((page - 1) * 4 + i + 1) +
									'.jpg \"/></li>')
							}

							//执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
							//pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
							next(lis.join(''), page < 10); //假设总页数为 10
						}, 500);
					}
				});

			});