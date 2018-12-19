
package com.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity			
@Table(name = "trading_calendar")
public class Trading_Calendar implements Serializable {			
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    @Column(name = "date")
	private String recordDate;
    
    @Column(name = "tradingdate")
	private String paymentDate;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getPaymentDate() {
		return  paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Trading_Calendar() {
		super();
	}
	public Trading_Calendar( String recordDate, String paymentDate) {
		super();
		
		this.recordDate = recordDate;
		this.paymentDate = paymentDate;

	}
	
	
}
