class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if(firstName == null || firstName.isBlank()){
            return;
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        // write your code here
        if(lastName == null || lastName.isBlank()){
            return;
        }
        this.lastName = lastName;
    }

    public String getFullName() {
        if(firstName == null || firstName.isBlank()){
            if(lastName == null || lastName.isBlank()){
                return "Unknown";
            }else{
                return lastName;
            }
        }else if(lastName == null || lastName.isBlank()){
            return firstName;
        }else{
            return firstName + " " + lastName;
        }
    }
}

public class Main{
    public static void main(String[] args) {
        User tim = new User();
        tim.setFirstName("Tim");
        tim.setLastName("Towler");
        System.out.println(tim.getFullName()); // Tim Towler

        User katie = new User();
        katie.setFirstName("Katie");
        katie.setLastName(null);
        System.out.println(katie.getFullName()); // Katie (without additional spaces)
    }
}
