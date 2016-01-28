function add() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../hospital/add",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
				$("#content").show();
				window.location.href='hospitalShow.jsp';
		}
	});
}

function update() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../hospital/update",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
				$("#content").show();
				window.location.href='hospitalShow.jsp';
		}
	});
}

function load() {

        $.ajax({
            type: "get",
            dataType: "json",
            url: "../hospital/showAll",
            success: function (msg) {
                var str = "";
                for (i in msg) {
                    str += "<tr><td>" + msg[i].id + "</td><td>" + msg[i].hospitalName + "</td><td>" + msg[i].level + "</td><td>" + msg[i].address + "</td><td>" + msg[i].telephone + "</td><td>" +
                    msg[i].email +"</td><td>" + msg[i].hospitalIM +"</td><td>" + msg[i].WeiChatPublicNumber +"</td></tr>";
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