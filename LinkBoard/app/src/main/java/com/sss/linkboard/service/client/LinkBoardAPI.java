package com.sss.linkboard.service.client;


public final class LinkBoardAPI {
    public static final String BASE_URL = "http://api.linkboard.com";
    public static final String TRENDING_API = BASE_URL + "/search/getTrending";
    public static final String GET_TWEETS_API = BASE_URL + "/search/getTweets";
    public static final String GET_BING_API = BASE_URL + "/search/getBingResults";

    public static final String SIGN_UP_API = BASE_URL + "/users/register";
    public static final String LOGIN_API = BASE_URL + "/users/login";


    //FOLDER MENU API

    public static final String GET_GROUP_BY_USER_ID = BASE_URL + "/groups/getGroupsByUserID";
    public static final String ADD_GROUP_BY_USER_ID_TITLE = BASE_URL + "/groups/addGroup";
    public static final String EDIT_GROUP_BY_GROUP_ID_TITLE = BASE_URL + "/groups/editGroup";
    public static final String REMOVE_GROUP_BY_GROUP_ID = BASE_URL + "/groups/removeGroup";
    public static final String GET_FOLDER_BY_GROUP_ID = BASE_URL + "/folders/getFoldersByGroupID";
    public static final String ADD_FOLDER_BY_GROUP_ID = BASE_URL + "/folders/addFolder";
}
