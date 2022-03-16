package com.lp.birthday.model;

import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JacksonXmlRootElement(localName = "BirthMsgs")
public class BirthMsgs {

    private List<BirthMsg> birthMsgs;

    public BirthMsgs(List<BirthMsg> birthMsgs) {
        this.birthMsgs = birthMsgs;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "root")
    public List<BirthMsg> getBirthMsgs() {
        return birthMsgs;
    }

    public void setBirthMsgs(List<BirthMsg> birthMsgs) {
        this.birthMsgs = birthMsgs;
    }

}
