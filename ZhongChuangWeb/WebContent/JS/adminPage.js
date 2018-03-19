/**
 * 
 */
function deleteProject(){
	var deleteFlag = null;
	var projectId=$("#base").val();
	//alert($("#base").val());
	 if(window.confirm("您确定要删除此条信息？")){
		 
	      $('#deleteProject').attr("href","ShowAdminPageServlet?programNo="+projectId+"&deleteFlag=1");
		 deleteFlag = 1;	
		 return true;
	       }
	       else{
	     //  alert("取消删除！");
	    	   deleteFlag = null;
	    $('#deleteProject').attr("href","ShowAdminPageServlet");
	       return false;
	       }      
	    }
	