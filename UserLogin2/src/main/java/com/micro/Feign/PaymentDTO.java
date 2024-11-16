package com.micro.Feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
		private int studentId;
	    private String name;
	    private String password;
	    private String email;
	    private int amount;

}
