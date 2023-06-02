
package org.example;

public class Airport {

    private int bizId;
    private String bizName;
    private String address;
    private String city;

    public Airport() {}

    // konstruktorius skirtas redagavimui
    public Airport(int bizId, String bizName, String address, String city) {
        this.bizId = bizId;
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

   // konstruktorius skirtas naujų įrašų kurimui

    public Airport(String bizName, String address, String city) {
        this.bizName = bizName;
        this.address = address;
        this.city = city;
    }

    public String getBizName() {
        return bizName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Integer getBizId(){
        return bizId;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "bizid=" + bizId +
                ", bizName='" + bizName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
