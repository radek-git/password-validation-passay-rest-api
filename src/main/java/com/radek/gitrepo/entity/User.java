package com.radek.gitrepo.entity;


import com.radek.gitrepo.service.UserService;
import com.radek.gitrepo.validation.unique.Unique;
import com.radek.gitrepo.validation.password.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity{

    @NotNull(message = "Imię nie może być puste")
    @Size(min = 1, max = 20, message = "Podaj właściwą długość imienia (1-20 znaków)")
    @Pattern(regexp = "[A-Za-z]+", message = "Imię moze składać się tylko z liter")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 20, message = "Podaj właściwą długość nazwiska (1-20 znaków)")
    @Pattern(regexp = "[A-Za-z]+", message = "Nazwisko moze składać się tylko z liter")
    private String lastName;

    @NotNull
    @Unique(service = UserService.class, fieldName = "username", message = "Uzytkownik o podanej nazwie uzytkownika juz istnieje")
    @Size(min = 1, max=20, message = "Podaj właściwą długość (1-20 znaków)")
    @Column(unique = true)
    private String username;

    @NotNull
    @Unique(service = UserService.class, fieldName = "pesel", message = "Uzytkownik o podanym peselu juz istnieje")
    @Pattern(regexp = "[0-9]{11}", message = "Pesel musi skladac sie tylko z cyfr")
    @Size(min = 11, max = 11, message = "Pesel musi zawierac dokladnie 11 cyfr")
    @Column(unique = true, updatable = false)
    private String pesel;

    @ValidPassword
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
//            message = "Min długość hasła to 8 znaków, hasło musi składać się przynajmniej z 1 litery, 1 cyfry, 1 znaku specjalnego ")
    private String password;

    @NotNull
    @Unique(service = UserService.class, fieldName = "email", message = "Uzytkownik o podanym emailu juz istnieje")
    @Email(message = "Podaj prawidlowy adres email")
    @Column(unique = true)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;


//    @UpdateTimestamp
//    private LocalDateTime updatedAt;

}
