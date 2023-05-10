package com.example.search;

public class modal {

    private String CourseName;
    private String CourseDescription;
    private  int userImage;

    public modal(String english, String s, int img) {
        userImage =img;
        CourseName=english;
        CourseDescription=s;
    }


    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public modal(int userImage) {
        this.userImage = userImage;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseDescription() {
        return CourseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        CourseDescription = courseDescription;
    }

    public modal(String courseName, String courseDescription) {
        CourseName = courseName;
        CourseDescription = courseDescription;
    }
}
