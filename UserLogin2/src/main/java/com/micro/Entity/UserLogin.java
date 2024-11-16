package com.micro.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loginId;
	private int studentId;
	private String password;

}
