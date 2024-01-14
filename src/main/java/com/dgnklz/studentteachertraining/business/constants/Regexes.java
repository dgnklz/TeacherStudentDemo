package com.dgnklz.studentteachertraining.business.constants;

public class Regexes {
    public static final String Email = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)";
    public static final String Password = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
}
