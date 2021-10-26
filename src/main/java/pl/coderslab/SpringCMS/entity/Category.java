package pl.coderslab.SpringCMS.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.transaction.Transactional;

@Entity

@Getter
@Setter
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Nullable
    private String description;

}
