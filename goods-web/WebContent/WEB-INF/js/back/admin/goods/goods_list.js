$(function() {
	$(selectall).on("click",function(){
		checkboxSelectAll('gid',this.checked);
	});

	$(deleteBtn).on("click",function(){//绑定商品锁定操作
		if(window.confirm("确定要删除这些商品信息吗?")){
			deleteGid = "";
			$("#gid:checked").each(function(){
				deleteGid += this.value+",";
 			}); 
			
			if(deleteGid==""){
				operateAlert(false,"","您还未选择任何要删除的数据!!!");
			}else{
				window.location = jsDeleteUrl +"?ids="+deleteGid;
			}
		}
	});
})