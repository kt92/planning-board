package pl.pb.model;

        import lombok.*;

        import javax.persistence.*;
        import java.time.LocalDateTime;
        import java.util.List;

@Builder
@Getter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDateTime creation_date;

    @OneToMany
    private List<Task> tasks;
}