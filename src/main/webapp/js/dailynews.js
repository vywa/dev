function add() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../dnews/add",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
				$("#content").show();
				window.location.href='dailynewsShow.jsp';
		}
	});
}

function update() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../post/update",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
				$("#content").show();
				window.location.href='postShow.jsp';
		}
	});
}



$.fn.serializeObject = function()    

{    
   var o = {};    

   var a = this.serializeArray();    

   $.each(a, function() {    

       if (o[this.name]) {    

           if (!o[this.name].push) {    

               o[this.name] = [o[this.name]];    

           }    

           o[this.name].push(this.value || '');    

       } else {    

           o[this.name] = this.value || '';    

       }    

   });    

   return o;    

};  