package com.backend.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	void contextLoads() {
		ChallengeApplication challengeApplication = new ChallengeApplication();
		challengeApplication.main("");
	}

}
