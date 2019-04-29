package com.app.messagingservice.repository;

import java.util.Random;

public interface OTP_intefarce {
	
	default int getOpt()
	{
		return new Random().nextInt(999999);
	}

}
