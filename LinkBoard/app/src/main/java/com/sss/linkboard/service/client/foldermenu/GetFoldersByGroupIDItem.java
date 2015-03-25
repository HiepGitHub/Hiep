package com.sss.linkboard.service.client.foldermenu;

public class GetFoldersByGroupIDItem {
    private int folderID;
    private int userID;
    private String title;
    private String folderOrderID;

    public int getFolderID() {
        return folderID;
    }

    public void setFolderID(int folderID) {
        this.folderID = folderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolderOrderID() {
        return folderOrderID;
    }

    public void setFolderOrderID(String folderOrderID) {
        this.folderOrderID = folderOrderID;
    }
}

