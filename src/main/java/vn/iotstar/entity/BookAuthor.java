package vn.iotstar.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book_author")  // Tên bảng kết nối
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthor implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BookAuthorId id; // Composite key

    @ManyToOne
    @MapsId("author_id") // Link to the authorId in the embedded ID
    @JoinColumn(name = "author_id", nullable = false) // Liên kết tới tác giả
    private Author author; // Đối tượng Author

    @ManyToOne
    @MapsId("bookid") // Link to the bookId in the embedded ID
    @JoinColumn(name = "bookid", nullable = false) // Liên kết tới sách
    private Book books; // Đối tượng Book
    
}
