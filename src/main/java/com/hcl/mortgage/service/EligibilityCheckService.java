/**
 * @author User1
 * @name EligibilityCheckService.java
 * @date Oct 10, 2019
 */
package com.hcl.mortgage.service;

import org.springframework.stereotype.Service;

import com.hcl.mortgage.dto.EligibilityCheckRequestDto;
import com.hcl.mortgage.dto.EligibilityCheckResponseDto;

/**
 * @author User1
 *
 */
@Service
public interface EligibilityCheckService {
	
	public EligibilityCheckResponseDto checkEligibility(EligibilityCheckRequestDto eligibilityCheckRequestDto);
}
