package com.example.admin.firebaselogin;

public class data {

    String uname;
    String uemail;
    String upass;
    String udate;
    String upnumber;
    String uid;

    public data(){

    }

    public data(String uid,String uname, String uemail, String upass, String udate, String upnumber) {
        this.uname = uname;
        this.uemail = uemail;
        this.upass = upass;
        this.udate = udate;
        this.upnumber = upnumber;
        this.uid=uid;
    }

    public String getUname() {
        return uname;
    }

    public String getUemail() {
        return uemail;
    }

    public String getUpass() {
        return upass;
    }

    public String getUdate() {
        return udate;
    }

    public String getUpnumber() {
        return upnumber;
    }

    public String getUid() {
        return uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public void setUpnumber(String upnumber) {
        this.upnumber = upnumber;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
