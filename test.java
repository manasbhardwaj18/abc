class Student {
    String name;
    String enrollmentNumber;
    double cgpa;
    String password;
    
    Student(String name, String enrollmentNumber, double cgpa, String password){
        this.name = name;
        this.enrollmentNumber = enrollmentNumber;
        this.cgpa = cgpa;
        this.password = password;
    }
    
    
    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    
    double getCgpa(){
        return cgpa;
    }
    void setCgpa(double cgpa){
        this.cgpa = cgpa;
    }
    String getEnrollmentNumber(){
        return enrollmentNumber;
    }
    void setEnrollmentNumber(String enrollmentNumber){
        this.enrollmentNumber = enrollmentNumber;
    }
    String getPassword(){
        return password;
    }
    void setPassword(String password){
        this.password=password;
    }
    void validateCgpa(){
        if(cgpa > 10 || cgpa < 0){
            throw new IllegalArgumentException("CGPA must be between 0 and 10");
        }      
    }
    void validateEnrollmentNumber() {
        String regex = "^BE[2-3]{2}(CSU|ENU|ECU|EEU)[0-9]{3}$";
    
        if (!enrollmentNumber.matches(regex)) {
            throw new IllegalArgumentException("Invalid Enrollment Number");
        }
    }
    

    public void validatePassword() {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Minimun required password length is 8 characters.");
        }
        

        if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$")) {
            throw new IllegalArgumentException("Password must contain a special symbol, "
                    + "an Uppercase and a lowercase letter, along with a number.");
        }
    }

   public void display(Student s1){
   
        System.out.println("Name: " + s1.getName());
        System.out.println("CGPA: " + s1.getCgpa());
        System.out.println("Enrollment number: " + s1.getEnrollmentNumber());
        System.out.println("Password: " + s1.getPassword());
        
   } 
    
}


class Main{
    public static void main(String[] args) {
       
        Student s1 = new Student("Neo" , "BE23CSU107", 8.77, "Pass47*d!");
          s1.display(s1);
        try {
            s1.validateCgpa();
            s1.validateEnrollmentNumber();
            s1.validatePassword();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

     }

    }
