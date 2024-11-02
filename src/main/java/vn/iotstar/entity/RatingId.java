package vn.iotstar.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class RatingId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
    private int bookid;

    // Getters and setters, equals(), and hashCode() methods
}
