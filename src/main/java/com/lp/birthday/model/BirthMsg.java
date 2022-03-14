package com.lp.birthday.model;

public class BirthMsg {
    private String subject;
    private String content; 
    private String picBase64;

    public BirthMsg(String subject, String content, String picBase64) {
        this.subject = subject;
        this.content = content;
        this.picBase64 = picBase64;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureBase64() {
        return picBase64;
    }

    public void setPictureBase64(String picBase64) {
        this.picBase64 = picBase64;
    }

}
