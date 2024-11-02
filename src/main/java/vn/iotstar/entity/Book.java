package vn.iotstar.entity;
import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="books")
@NamedQuery(name="books.findAll", query="SELECT v FROM Book v")
public class Book implements Serializable {
 private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm để tự động tăng giá trị
 @Column(name="bookid")
 private int bookid;
 @Column(name="isbn", columnDefinition ="INT NULL")
 private int isbn;
 @Column(name="title", columnDefinition ="VARCHAR(200) NULL")
 private String title;
 @Column(name="publisher", columnDefinition ="VARCHAR(100) NULL")
 private String publisher;
 @Column(name="price", columnDefinition ="decimal(6,2) NULL")
 private double price;
 @Column(name="description", columnDefinition ="text NULL")
 private String description;
 @Column(name="publish_date", columnDefinition ="date NULL")
 private Date publish_date;
 @Column(name="quantity", columnDefinition ="int NULL")
 private int quantity;
 
 
}