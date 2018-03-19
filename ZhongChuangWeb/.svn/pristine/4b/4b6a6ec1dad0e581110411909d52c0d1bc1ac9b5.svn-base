/**
 * XMLHttpRequest对象池
 */
//json方式生成对象
var xmlHttpRequest = {
	XMLHttpRequestPool: [],
	//该方法用于返回一个xmlHttpRequest的对象
	getInstance: function() {
		//遍历xmlHttpRequest的对象池，将空闲的xmlHttpRequest的对象返回出去
		for(var i = 0; i < this.XMLHttpRequestPool.length; i++) {
			if(this.XMLHttpRequestPool[i].readyState == 0 || this.XMLHttpRequestPool[i].readyState == 4) {
				return this.XMLHttpRequestPool[i];
			}
		}
		//如果没有空闲的则生成一个新的xmlHttpRequest的对象放入池中
		this.XMLHttpRequestPool[this.XMLHttpRequestPool.length] = new this.createXMLHttpRequest();
		return this.XMLHttpRequestPool[this.XMLHttpRequestPool.length - 1];
	},
		
	//创建一个xmlHttpRequest对象
	createXMLHttpRequest: function() {
		if(window.XMLHttpRequest) {
			//DOM2浏览器
			XMLHttpReq = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			//使用json语法创建数组
			var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
			for(var i = 0; i < MSXML.length; i++) {
				try{
					XMLHttpReq = new ActiveXObject(MSXML[i]);
				} catch(e) {
					
				}
			}
		}
	},
	
	//发送请求（方法[POST, GET],地址,数据,回调函数）
	sendRequest: function(method, url, data, callback) {
		var XMLHttpRequest = this.getInstance();
		with(XMLHttpRequest) {
			try{
				//增加一个额外的参数randnum，防止ie浏览器缓存
				if(url.indexOf('?') > 0) {
					url += url + "&randnum=" + Math.random();
				} else {
					url += url + "?randnum=" + Math.random();
				}
				
				//打开与服务器的连接
				open(method, url, true);
				
				//设置回调函数
				onreadystatechange = function() {
					if(XMLHttpRequest.readyState == 4 && (XMLHttpRequest.status == 200 || XMLHttpRequest.status == 304)) {
						callback.call(null, XMLHttpRequest);
					}
				}
				
				//若是使用post请求方式则
				if(method == "POST") {
					setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					send(data);
				} else if(method == "GET") {
					//若是使用get请求方式则
					send(null);
				}
			} catch (e) {
				alert(e);
			}
		}
	}
};