package com.example.Travel_Experience_Route_Sharing_Platform.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class Users
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false,length = 100)
    private String fullName;

    @Column(name = "email",nullable = false,unique = true,length = 150)
    private String email;

    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password_hash", nullable = false,length = 255)
    private String passwordHash;

    @Column(name = "bio",columnDefinition = "Text")
    private String bio;

    @Column(name = "profile_image_url",length = 500)
    private String profileImageUrl;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "ENUM('ROLE_USER','ROLE_TRAVELER') DEFAULT 'ROLE_USER'")
    private Role role=Role.ROLE_USER;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

//    @JsonIgnore
//    @Builder.Default
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private List<Trip> trips=new ArrayList<>();
}
