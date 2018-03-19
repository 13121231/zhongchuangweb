package cn.edu.njupt.bigdata.service;

public class FileUploadButtonService {
	// filestate 0 文档未上传 1文档已上传  billstate 0 报销未上传 1 报销已上传 changestate 0 不可修改 1 可修改 adminstate 0 未批复 1已批复
	//文档上传
	public boolean fileUpload(int fileState, int changeState) {
		if((fileState == 0)|| ((fileState == 1) && (changeState == 1))) {
			return true;
		} else {
			return false;
		}
	}
	//清单上传
	public boolean billUpload(int fileState, int billState, int adminState) {
		if ((fileState == 1) && (billState == 0) && (adminState == 1) ) {
			return true ;
		} else {
			return false;
		}
	}
	
	//文档下载
	public boolean download(int fileState, int changeState) {
		if((fileState == 1) && (changeState == 1)) {
			return true;
		} else {
			return false;
		}
	}

}
