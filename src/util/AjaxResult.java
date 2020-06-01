package util;

public class AjaxResult {
	
	private boolean success = true;
	private String message;
	private int code;//错误码
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	//成功时调用的构造方法
	public AjaxResult(String message) {
		this.message = message;
	}
	//错误时调用的构造方法
	public AjaxResult(String message,int code){
		this.success = false;
		this.message = message;
		this.code = code;
	}
	
	

}
