package com.hcl.mortgage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class LoanCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loan_type_id;
	private String typeOfLoan;
	private int minAge;
	private int maxAge;
	private int exposure;
}
