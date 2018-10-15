package com.ealanta;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsTestApplicationTests {

	private @Value("${git.commit.id}") String gitCommitId;
	private @Value("${my.name}") String myName;

	@Test
	public void contextLoads1() {
		System.out.printf("gitCommitId [%s]%n",gitCommitId);
		Assert.assertFalse(gitCommitId.contains("$"));
	}
	
	@Test
	public void contextLoads2() {
		System.out.printf("myName [%s]%n",myName);
		Assert.assertFalse(myName.contains("$"));
	}


}
