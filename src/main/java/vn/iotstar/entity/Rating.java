package vn.iotstar.entity;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.*;  // Thêm package JPA
import lombok.*; // Thêm để sử dụng @Data, @AllArgsConstructor, @NoArgsConstructor

@Entity
@Table(name = "rating")  // Đặt tên bảng trong cơ sở dữ liệu
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating implements Serializable {
	
	private static final long serialVersionUID = -8428484720911845401L;

	@EmbeddedId
	private RatingId id;

    @ManyToOne
    @MapsId("userid") // Link to the authorId in the embedded ID
    @JoinColumn(name = "userid", nullable = false) // Liên kết tới tác giả
    private User users; // Đối tượng Author
	
	@ManyToOne
	@MapsId("bookid") // Link to the authorId in the embedded ID
	@JoinColumn(name = "bookid", nullable = false)// Đặt tên cho trường trong bảng
	private Book books;
	
	@Column(name = "rating" , columnDefinition ="tinyint NULL")
	private int rating;
	
	@Column(name = "review_text" , columnDefinition ="text NULL")
	private String review_text;


	
	
}
