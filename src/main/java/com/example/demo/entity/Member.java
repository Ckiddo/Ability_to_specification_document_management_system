package com.example.demo.entity;

<<<<<<< HEAD
public class Member {
    String name;
    String sex;
    java.util.Date birthdate;
    String homeAddress;
    String contactInfor;
    String referees;
    String IndustryBranch;
    String specialCommittee;
=======
import lombok.Data;



@Data
public class Member {
    private String name;
    private String password;
    private String sex;
    private String birthdate;
    private String homeAddress;
    private String contactInfor;
    private String referees;
    private String IndustryBranch;
    private String specialCommittee;
>>>>>>> ck
}
