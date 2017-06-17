package dev.study.model;

import dev.study.paging.PagingBean;

public class BoardVO {

    int seq;
    String title;
    String content;
    String user_id;
    String reg_date;
    
    //new
    PagingBean paging;
    
    //new
    public PagingBean getPaging() {
		return paging;
	}

    //new
	public void setPaging(PagingBean paging) {
		this.paging = paging;
	}

	public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content=" + content + ", user_id=" + user_id
				+ ", reg_date=" + reg_date + "]";
	}

}
