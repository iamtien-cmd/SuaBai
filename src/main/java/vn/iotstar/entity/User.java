package vn.iotstar.entity;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.*;  // Thêm package JPA
import lombok.*; // Thêm để sử dụng @Data, @AllArgsConstructor, @NoArgsConstructor

@SuppressWarnings("serial")
@Entity
@Table(name = "users")  // Đặt tên bảng trong cơ sở dữ liệu
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Thêm để tự động tăng giá trị
	@Column(name = "id") // Đặt tên cho trường trong bảng
	private int id;
	
	@Column(name = "email" , columnDefinition ="VARCHAR(50) NULL") // Đặt tên cho trường trong bảng
	private String email;
	
	@Column(name = "fullname" , columnDefinition ="VARCHAR(50) NULL")
	private String fullname;
	
	@Column(name = "phone" , columnDefinition ="int NULL")
	private int phone;
	
	@Column(name = "passwd" , columnDefinition ="VARCHAR(32) NOT NULL")
	private String passwd;
	
	@Column(name = "signup_date" , columnDefinition ="Datetime NULL")
	private Date signup_date;
	
	@Column(name = "last_login" , columnDefinition ="Datetime NULL")
	private Date last_login;
	
	@Column(name = "is_admin" , columnDefinition ="bit NULL")
	private boolean is_admin;

	
	
}
