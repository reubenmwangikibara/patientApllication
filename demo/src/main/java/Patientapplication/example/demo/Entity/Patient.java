package Patientapplication.example.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Patient {
//    @Id
//    @SequenceGenerator(
//        name= "patient_sequence",
//        sequenceName = "patient_sequence",
//        allocationSize = 1
//)
//    @GeneratedValue(
//the recomended value for post-gress
//        strategy = GenerationType.SEQUENCE,
//        generator = "patient_sequence"
//
//)
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for auto-increment

        private Long id;
        private String name;
        private String email;
        private Long phonnumber;
        private LocalDate DOB;

        public Patient(){

        }
//generated constructors
    public Patient(Long id,
                   String name,
                   String email,
                   Long phonnumber,
                   LocalDate DOB) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phonnumber = phonnumber;
        this.DOB = DOB;
    }
    //another generated constructors withiut ID
    public Patient(LocalDate DOB,
                   Long phonnumber,
                   String email,
                   String name) {
        this.DOB = DOB;
        this.phonnumber = phonnumber;
        this.email = email;
        this.name = name;
    }

//    private int calculateAge(LocalDate DOB) {
//        return Period.between(DOB, LocalDate.now()).getYears();
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhonnumber() {
        return phonnumber;
    }

    public void setPhonnumber(Long phonnumber) {
        this.phonnumber = phonnumber;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
///  generate tostring
    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phonnumber=" + phonnumber +
                ", phonnumber=" + phonnumber +
                ", DOB=" + DOB +
                '}';
    }
}
