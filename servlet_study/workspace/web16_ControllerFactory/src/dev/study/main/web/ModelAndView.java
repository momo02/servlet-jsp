package dev.study.main.web;

/**
 * 
 * 페이지 주소와 리다이렉트 여부를 갖고 있는 클래스.
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;
	

	public ModelAndView(String path) {
		this.path = path;
	
	}


	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isRedirect() {
		return isRedirect;
	}


	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
