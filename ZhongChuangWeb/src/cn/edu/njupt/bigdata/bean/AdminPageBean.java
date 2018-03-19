package cn.edu.njupt.bigdata.bean;

public class AdminPageBean {
			private int totalPage;//总的页数
		    private int currentPage;//当前页数
		    private int currentPage1;//当前页数
		    private int totalRecord;//总的记录数
		    private int currentRecord;//当前记录数
		    private int pageSize=5;//每页的记录数
		    private int last = -pageSize;//设置上一页
		    private int next = pageSize ;//设置上一页
		    private int lastPage = -1;//设置上一页
		    private int nextPage = 1 ;//设置上一页
		    //获得和设置当前页
		    public int getCurrentPage(){
			   	 return currentPage;
		    }
		    
		    public void setCurrentPage(int currentRecord,int pageSize){
			   	 if(currentRecord%pageSize==0){
			   		 currentPage=currentRecord/pageSize;
			   	 }
			   	 else{
			   		 currentPage=currentRecord/pageSize+1;
			   	 }
		    }
		    
		    public int getlast(){
			   	 return last;
		    }
		    
		    public void setlast(int currentRecord,int pageSize){
			   last=currentRecord-pageSize;
		    }
		    
		    public int getnext(){
			   	 return next;
		    }
		    
		    public void setnext(int currentRecord,int pageSize){
			   next=currentRecord+pageSize;
		    }
		    
		    
		    public int getlastPage(){
			   	 return lastPage;
		    }
		    
		    public void setlastPage(int currentPage){
			   lastPage=currentPage-1;
		    }
		    
		    public int getnextPage(){
			   	 return nextPage;
		    }
		    
		    public void setnextPage(int currentPage){
			   nextPage=currentPage+1;
		    }
		    
		    public int getCurrentPage1(){
		    	currentPage1=currentPage+1;
			   	 return currentPage1;
		    }
		    
		    
		    
		    //获得和设置当前记录
		    public int getCurrentRecord(){
		   	 return currentRecord;
		    }
		    
		    public void setCurrentRecord(int currentRecord){
		   	 this.currentRecord=currentRecord;
		    }
		    
		    //获得和设置每页记录数量
		    public int getPageSize(){
		   	 return pageSize;
		    }
		    public void setPageSize(int pageSize){
		   	 this.pageSize=pageSize;
		    }
		    
		    //获得和设置总页数
		    public int getTotalPage(){
		   	 return totalPage;
		    }
		    public void setTotalPage(int totalRecord,int pageSize){
		   	 if(totalRecord%pageSize==0){
		   		 totalPage=totalRecord/pageSize;
		   	 }
		   	 else{
		   		 totalPage=totalRecord/pageSize+1;
		   	 }
		    }
		    
		    //获得和设置总记录
		    public int getTotalRecord(){
		   	 return totalRecord;
		    }
		    public void setTotalRecord(int totalRecord){
		   	 this.totalRecord=totalRecord;
		    }
}
