package menu.test.android_aquery;

/**
 * Created by dsm2016 on 2017-07-03.
 */

public class Data {

    String title;
    int category;
    int number;
    String content;
    String writer;
    String date;
    int homeNumber;

    public Data(){

    }


    public Data(int category, int number, String content, String title, String writer, String date, int homeNumber) {
        this.category = category;
        this.number = number;
        this.content = content;
        this.writer = writer;
        this.date = date;
        this.title=title;
        this.homeNumber = homeNumber;
    }

    public Data(String title,String content){
        this.title=title;
        this.content=content;
    }

    public Data(String title,int homeNumber){
        this.title=title;
        this.homeNumber=homeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Data(int category){
        this.category=category;
    }

    public Data(String title){
        this.title=title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }



}
