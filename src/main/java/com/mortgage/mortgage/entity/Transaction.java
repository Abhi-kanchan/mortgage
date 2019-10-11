package com.mortgage.mortgage.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 * @date 11-10-2019
 *
 */
@Setter
@Getter
@Entity
@Table
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long accountNumber;
	private Double instalment;
	private LocalDateTime dataTime;
	private String remarks;
}
