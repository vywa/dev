function add() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../account/add",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
				$("#content").show();
				window.location.href='accountShow.jsp';
		}
	});
}

function update() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../account/update",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
				$("#content").show();
				window.location.href='accountShow.jsp';
		}
	});
}

function load() {

        $.ajax({
            type: "get",
            dataType: "json",
            url: "../account/show",
            success: function (msg) {
                var str = "";
                for (i in msg) {
                    str += "<tr><td>" + msg[i].id + "</td><td>" + msg[i].catagory + "</td><td>" + msg[i].username + "</td><td>" + msg[i].mobilephone + 
                    "</td><td>" + msg[i].email + "</td><td>" +msg[i].workNum +"</td><td>" + msg[i].QQ +"</td><td>" + msg[i].weiChat +
                    msg[i].weiBo +"</td><td>" + msg[i].password +"</td><td>" + msg[i].status + "</td></tr>";
                }
                $("tbody").append(str);
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