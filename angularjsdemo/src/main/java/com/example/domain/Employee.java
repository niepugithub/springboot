package com.example.domain;

public class Employee {
    private int id;
    private String empno;
    private String empname;
    private String position;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empno='" + empno + '\'' +
                ", empname='" + empname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Employee(){}
    public Employee(int id, String empno, String empname, String position) {
        this.id = id;
        this.empno = empno;
        this.empname = empname;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
