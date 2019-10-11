package com.mortgage.mortgage.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Laxman
 * @date 11-10-2019
 *
 */
@Setter
@Getter
public class TransactionDto {

	private Integer id;
	private Long accountNumber;
	private Double instalment;
	private LocalDateTime dataTime;
	private String remarks;
}
