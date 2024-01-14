package com.dgnklz.studentteachertraining.business.constants;

public class ValidationMessages {
    public static class User{
        public static final String FirstNameBlank = "First name is required";
        public static final String FirstNameLength = "First name must be between 2 and 50 characters";
        public static final String LastNameBlank = "Last name is required";
        public static final String LastNameLength = "Last name must be between 2 and 50 characters";
        public static final String DateOfBirthBlank = "Date of birth is required";
        public static final String NationalIdentityBlank = "National Identity is required";
        public static final String NationalIdentityLength = "National Identity must be 11 char";
    }

    public static class Teacher{
        public static final String BranchBlank = "Branch is required";
        public static final String BranchLength = "Branch must be between 2 and 50 characters";
        public static final String EmailBlank = "Email is required";
        public static final String EmailValid = "Email is not valid";
        public static final String PasswordBlank = "Password is required";
        public static final String PasswordValid = "Password must be minimum 8 characters, at least one letter, one number and one special character:";
        public static final String ConfirmPasswordBlank = "Confirm password is required";
        public static final String ConfirmPasswordValid = "Confirm password must be same with password";
        public static final String OldPasswordBlank = "Old password is required";
        public static final String OldPasswordNotMatch = "Old password is not match";
        public static final String ThereIsNoChangeInPassword = "There is no change in the password. Please enter a new password";
    }

    public static class Student{
        public static final String AboutBlank = "About is required";
        public static final String AboutLength = "About must be between 5 and 100 characters";
    }
}
