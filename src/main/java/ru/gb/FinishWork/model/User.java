package ru.gb.FinishWork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "tel_number",nullable = false)
    private String telNumber;
    @Column(nullable = false)
    private String email;
    @Column(name = "user_role",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
