package hayber.matchdiary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table (name = "team")
@Entity(name = "team")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor 
public class Team {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "photoUrl")
    private String photoUrl;

}
