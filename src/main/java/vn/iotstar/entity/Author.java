package vn.iotstar.entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="author")
@NamedQuery(name="author.findAll", query="SELECT c FROM Author c")
public class Author implements Serializable {
 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name="author_id")
 private int author_id;
 
 
 @Column(name="author_name", columnDefinition ="VARCHAR(100) NULL")
 private String author_name;

 
 @Column(name="date_of_birth", columnDefinition ="date NULL")
 private Date date_of_birth;
}