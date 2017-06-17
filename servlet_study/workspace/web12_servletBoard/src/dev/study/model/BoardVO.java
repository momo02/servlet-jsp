package dev.study.model;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class BoardVO {

    int seq;
    String title;
    String content;
    String user_id;
    String reg_date;
    
    //페이징 관련.
    String firstIndex;
    String recordCountPerPage;
    int rnum;

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

	public String getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(String firstIndex) {
		this.firstIndex = firstIndex;
	}

	public String getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(String recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", content=" + content + ", user_id=" + user_id
				+ ", reg_date=" + reg_date + ", firstIndex=" + firstIndex + ", recordCountPerPage=" + recordCountPerPage
				+ ", rnum=" + rnum + "]";
	}

}
