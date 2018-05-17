package java.com.tianshouzhi.security.entity;

import java.io.Serializable;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
public class PrivilegeEntity implements Serializable{
    private int userId;
    private String name;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
