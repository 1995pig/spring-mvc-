$(function() {
	$(iid).on("change",function(){
		if(this.value !=null){	//有数据
			iid = parseInt(this.value);	//iid =this.value;
			$("#sid option:gt(0)").remove();
			$.post("pages/back/admin/subitem/list_subitem",{iid:iid},function(data){
				for(x=0;x<data.allSubitems.length;x++){
					$(sid).append("<option value='"+data.allSubitems[x].sid+"'>"+data.allSubitems[x].title+" </option>");
 
				} 
			},"json"); 
		}
	}); 
	
	  
	$("#goodsForm").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"title" : {
				required : true,
				//remote : {
//									url : "check.jsp", // 后台处理程序
//									type : "post", // 数据发送方式
//									dataType : "html", // 接受数据格式
//									data : { // 要传递的数据
//										code : function() {
//											return $("#code").val();
//										}
//									},
//									dataFilter : function(data, type) {
//										if (data.trim() == "true")
//											return true;
//										else
//											return false;
//									}
				//}
			},
			"iid" : {
				required : true
			} ,
			"sid" : {
				required : true
			},
			"price" : {
				required : true ,
				number : true
			},
			"pic" : {
				required : true
			}
		}
	});
})