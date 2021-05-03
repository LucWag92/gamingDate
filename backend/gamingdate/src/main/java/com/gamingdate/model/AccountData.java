package com.gamingdate.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity(name="AccountData")
@Table(
    name="accountdata",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "accountdata_email_unique",
            columnNames = "email"
        )
    }
)
@Data
public class AccountData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountdataid")
    private Long accountDataId;

    @Column(name="email", nullable = false)
    @NotBlank(message = "EMail is mandatory")
    private String eMail;

    @Column(name="hashedpassword", nullable = false)
    @Size(min = 8)
    @NotBlank(message = "Password is mandatory and must be at least 8 characters long")
    private String hashedPassword; 

    @OneToOne(mappedBy = "accountData")
    private User user;

    // default connstructor which is only used for JPA
    protected AccountData(){}
    public AccountData(String eMail, String hashedPassword){
        this.eMail = eMail;
        this.hashedPassword = hashedPassword;
    }
    
}
