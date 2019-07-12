package com.avy.haobai;

public class GameInfo {

//  <GameInfo>
//        <gid>22</gid>
//        <name>ç±³ç®å¤§åé©</name>
//        <e_name></e_name>
//    <developer>Dreadlocks Mobile, Silicon Jelly</developer>
//    <publisher>Dreadlocks Mobile, Silicon Jelly, Dreadlocks Ltd.</publisher>
//        <release_date>2016-05-23T00:00:00 0800</release_date>
//        <issue_date>2019-05-08T00:00:00 0800</issue_date>
//        <cover>http://220.248.55.105:28092/game_cover/22.png</cover>
//        <categories>2Dåé©</categories>
//        <tags>ç¬ç«,å¯ç±,è§£å¯</tags>
//        <state>1</state>
//    </GameInfo>
    int gid;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String e_name;

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }
    String developer;

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getDeveloper() {
        return developer;
    }

    String publisher;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    String release_date;

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    String issue_date;

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    String cover;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    String categories;

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
