function login() {
	 var data = $('#form1').serializeObject();   
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../reglog/username",// 要访问的后台地址
		data:'data='+JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
			alert(msg.userCode);
			alert(msg.message);
			setCookie("tocken",msg.message, 24 * 60 * 60 * 1000);
			window.location.href='../index.jsp';
		}
	});
}

$.extend({
cookieHelper: function(name,value,options){
	if(typeof value !='undefined'){
		options = options ||{};
		if(value == null){
			value='';
			options.expires=-1;
		}
		var expires = '';
		
	}
}	
	
})


function setCookie(name, value, iDay) 
{
	var oDate=new Date();
	
	oDate.setDate(oDate.getDate()+iDay);
	
	document.cookie=name+'='+encodeURIComponent(value)+';expires='+oDate;
}

function getCookie(name)
{
	var arr=document.cookie.split('; ');
	var i=0;
	for(i=0;i<arr.length;i++)
	{
		//arr2->['username', 'abc']
		var arr2=arr[i].split('=');
		
		if(arr2[0]==name)
		{	
			var getC = decodeURIComponent(arr2[1]);
			return getC;
		}
	}
	
	return '';
}

function removeCookie(name)
{
	setCookie(name, '1', -1);
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