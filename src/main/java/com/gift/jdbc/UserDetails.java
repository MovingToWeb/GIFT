package com.gift.jdbc;

public class UserDetails {

    private String userName;
    private String userId;
    private String address;
    private String country;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetails)) return false;

        UserDetails that = (UserDetails) o;

        if (!getUserName().equals(that.getUserName())) return false;
        if (!getUserId().equals(that.getUserId())) return false;
        if (!getAddress().equals(that.getAddress())) return false;
        return getCountry().equals(that.getCountry());

    }

    @Override
    public int hashCode() {
        int result = getUserName().hashCode();
        result = 31 * result + getUserId().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getCountry().hashCode();
        return result;
    }
}
