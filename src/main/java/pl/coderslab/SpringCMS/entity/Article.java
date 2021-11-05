package pl.coderslab.SpringCMS.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
    private String title;

    @OneToOne
    private Author author;

    @OneToMany
    private List<Category> categories = new ArrayList<>();

    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;


}
