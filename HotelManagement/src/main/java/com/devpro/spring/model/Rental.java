package com.devpro.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

@Entity
@Table(name = "rental")
public class Rental implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rental_id")
	private Long rentalId;
	
	@Column(name = "discount")
	private String discount;
	
	@Column(name = "check_in_date")
	private Date checkInDate;
	
	@Column(name = "check_out_date")
	private Date checkOutDate;
	
	@Column(name = "paid")
	private String paid;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "guest_id",nullable = false)
	private Guest guest;
	
    @ManyToMany
    @JoinTable(name = "rental_chamber", joinColumns = @JoinColumn(name = "rental_id"), inverseJoinColumns = @JoinColumn(name = "chamber_id"))
    private Set<Chamber> chambers;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payment_id", nullable=false)
    private Payment payment;
	
	@OneToMany(mappedBy = "rental")
	private Set<OrderFood> orderFoods;

	@OneToMany(mappedBy = "rental")
	private Set<ServiceBill> serviceBills;

}
