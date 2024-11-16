package com.micro.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	    private int user_id;
	    private String name;
	    private String password;
	    private String email; 
	    private Long phone;
	    private String address;
	   
}
