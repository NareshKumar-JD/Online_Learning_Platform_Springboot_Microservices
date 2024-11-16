package com.micro.Service;

import com.micro.Entity.Payment;

public interface PaymentMailService {
	Payment savePaymentAndSendEmail(Payment savedPayment);

}