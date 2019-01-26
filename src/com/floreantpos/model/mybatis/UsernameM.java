package com.floreantpos.model.mybatis;

/**
 *
 * @author Mike
 *  2012/4/26
 */
public class UsernameM {
    private String username;
    private String displayname;

    @Override
    public String toString() {
        return "Category No.: " + username + "\tName: " + displayname;
    }

    /**
     * @return the username
     */
    public String getusername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setusername(String username) {
        this.username = username;
    }

    /**
     * @return the displayname
     */
    public String getdisplayname() {
        return displayname;
    }

    /**
     * @param displeyname the displayname to set
     */
    public void setdispleyname(String displayname) {
        this.displayname = displayname;
    }


}
