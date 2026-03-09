package dk.ss.swaggerdocker.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dk.ss.swaggerdocker.app.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
public class Document extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "talent_id", nullable = false)
    @JsonIgnore
    private Talent talent;

    public Document(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
