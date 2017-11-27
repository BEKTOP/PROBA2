package com.example.kravchik.proba2.todo;


import java.io.Serializable;
import java.util.Date;


public class TodoDocument implements Serializable {
    private String name;
    private String content;
    private Date createDate;
    private int number=-1;

    public TodoDocument(){

    }

    public TodoDocument(String name, String content, Date createDate){
        super();
        this.name = name;
        this.content = content;
        this.createDate = createDate;
    }



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }
    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Date createDate){
        this.createDate=createDate;
    }
    public int getNumber(){ return number; }
    public void setNumber(int number){this.number=number;}

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TodoDocument)) return false;
        TodoDocument document = (TodoDocument) o;
        return number == document.getNumber();
    }
}
