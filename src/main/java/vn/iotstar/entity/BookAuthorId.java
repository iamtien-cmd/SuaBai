package vn.iotstar.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class BookAuthorId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int author_id;
    private int bookid;

    // Getters and setters, equals(), and hashCode() methods
}
