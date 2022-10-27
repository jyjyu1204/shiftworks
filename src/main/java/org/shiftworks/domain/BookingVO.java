package org.shiftworks.domain;


import java.util.Date;

import lombok.Data;

@Data
public class BookingVO {
	private int book_id;
	private String rsc_id;
	private String emp_id;
	private String dept_id;
	private Date book_date;
	private int book_begin;
	private int book_end;
	private String book_title;
	private String book_content;
	
}
