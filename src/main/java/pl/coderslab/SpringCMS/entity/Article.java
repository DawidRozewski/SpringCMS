package pl.coderslab.SpringCMS.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    @Size
    @NotNull
    private String title;

    @ManyToOne
    private Author author;

    @ManyToMany
    @Size(min = 1)
    private List<Category> categories = new ArrayList<>();

    @Size(max = 500)
    @NotNull
    private String content;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

}
