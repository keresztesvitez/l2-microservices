package com.epam.payfriend;

public class UserIdResponse {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserIdResponse{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
