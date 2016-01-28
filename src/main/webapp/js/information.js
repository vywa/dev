function get() {
	$.ajax({
		type : "get",// 使用get方法访问后台
		dataType : "json",// 返回json格式的数据
		url : "../info/show",// 要访问的后台地址
		data : {
			 username:$("#username").val(),  
			   content:$("#content").val()  
		},
		contentType : "application/json; charset=utf-8",
		complete : function() {
			$("#load").hide();
		},// AJAX请求完成时隐藏loading提示
		success : function(msg) {// msg为返回的数据，在这里做数据绑定
			var data = msg.table;
			$.each(data, function(i, n) {
				var row = $("#template").clone();
				row.find("#OrderID").text(n.订单ID);
				row.find("#CustomerID").text(n.客户ID);
				row.find("#EmployeeID").text(n.雇员ID);
				row.find("#OrderDate").text(ChangeDate(n.订购日期));
				if (n.发货日期 !== undefined)
					row.find("#ShippedDate").text(ChangeDate(n.发货日期));
				row.find("#ShippedName").text(n.货主名称);
				row.find("#ShippedAddress").text(n.货主地址);
				row.find("#ShippedCity").text(n.货主城市);
				row.find("#more").html(
						"<a href=OrderInfo.aspx?id=" + n.订单ID + "&pageindex="
								+ pageIndex + ">&nbsp;More</a>");
				row.attr("id", "ready");// 改变绑定好数据的行的id
				row.appendTo("#datas");// 添加到模板的容器中
			});
		}
	});
}