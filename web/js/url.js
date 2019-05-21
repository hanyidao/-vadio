		function jsonURL() {
			var search = window.location.search
			if (search) {
				var arr = search.substr(1).split('&');
				var result = {};
				for (var x = 0; x < arr.length; x++) {
					var value = arr[x].split('=');
					result[value[0]] = value[1];
				}
				return result;
			}
		}