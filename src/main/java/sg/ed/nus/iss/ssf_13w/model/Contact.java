package sg.ed.nus.iss.ssf_13w.model;

import java.time.LocalDate;
import java.util.Random;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Contact {
    private static final Random RANDOM = new Random();

    private String id;

    @NotBlank(message = "Name cannot be left empty.")
    @Size(min = 2, max = 64, message = "Please keep name entry to within 2-64 characters")
    private String name;

    @Email(message = "Enter a valid email.")
    @NotBlank(message = "Email cannot be left blank.")
    private String email;

    @NotBlank(message = "Phone number cannot be left blank.")
    @Pattern(regexp = "(8|9)[0-9]{6}", message = "Enter a valid phone number.")
    private String phoneNo;

    @Past(message = "Date of birth entered is not in the past.")
    private LocalDate dob;

    public Contact() {
    }

    public Contact(String name, String email, String phoneNo, LocalDate dob) {
        this.id = String.format("%08x", RANDOM.nextLong(0x50000000));
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhoneNo() {return phoneNo;}
    public void setPhoneNo(String phoneNo) {this.phoneNo = phoneNo;}

    public LocalDate getDob() {return dob;}
    public void setDob(LocalDate dob) {this.dob = dob;}
}