package dk.ss.swaggerdocker.app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dk.ss.swaggerdocker.app.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "talents")
public class Talent extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profileText;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;


    private String github;
    private String linkedin;

    @OneToMany(mappedBy = "talent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Document> documents;

    public Talent(String name, String title, String profileText, String email,
                  String phone, String city, String country, String github, String linkedin) {
        this.name = name;
        this.title = title;
        this.profileText = profileText;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.github = github;
        this.linkedin = linkedin;
        this.documents = new java.util.ArrayList<>();
    }
}
