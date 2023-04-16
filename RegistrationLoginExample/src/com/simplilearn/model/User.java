package com.simplilearn.model;

public class User {  
private String uname,upass,uemail;  
  
public String getUname() {  
    return uname;  
}  
  
public void setUname(String uname) {  
    this.uname = uname;  
}  
  
public String getUpass() {  
    return upass;  
}  
  
public void setUpass(String upass) {  
    this.upass = upass;  
}  
  
public String getUemail() {  
    return uemail;  
}  
  
public void setUemail(String uemail) {  
    this.uemail = uemail;  
}

@Override
public String toString() {
	return "User [uname=" + uname + ", upass=" + upass + ", uemail=" + uemail + "]";
}  
  
}  