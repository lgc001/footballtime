package cn.footballtime.web.model;

/**
 * Created by Administrator on 2016/11/29 0029.
 */
public class UserLoginStatus {
    private int isAuthenticated;
    public int getIsAuthenticated() {
        return isAuthenticated;
    }
    public void setIsAuthenticated(int isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    public String getShowName() {
        return showName;
    }
    public void setShowName(String showName) {
        this.showName = showName;
    }
    private String showName;
}
