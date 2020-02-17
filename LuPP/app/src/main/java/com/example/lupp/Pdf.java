package com.example.lupp;


public class Pdf {
    private String pdfurl;
    private String pdfname;
    private String year;
    private String unitname;
    private String unitcode;
    private String lecturer;

    //url
    public String getUrl() {
        return pdfurl;
    }

    public void setUrl(String url) {
        this.pdfurl = url;
    }

 //name
    public String getName() {
        return pdfname;
    }

    public void setName(String name) {
        this.pdfname = name;
    }

    //year
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    //unitname
    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String department) {
        this.unitname = department;
    }

    //unitcode
    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String school) {
        this.unitcode = school;
    }

    //lecturer
    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
}
