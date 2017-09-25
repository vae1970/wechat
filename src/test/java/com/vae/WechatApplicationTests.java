package com.vae;

import com.vae.wechat.test.TestAtomic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatApplicationTests {

	private static final int MAX_THREADS = 10;
	private static final int TASK_COUNT = 10;
	private static final int TARGET_COUNT = 100 * 10000;

	@Test
	public void contextLoads() {
	}


	@Test
	public void testAtomic() throws InterruptedException {
		ExecutorService exe = Executors.newFixedThreadPool(MAX_THREADS);
		long startTime = System.currentTimeMillis();
		TestAtomic.AtomicThread atomic = new TestAtomic.AtomicThread(startTime);
		for (int i = 0; i < TASK_COUNT; i++) {
			exe.submit(atomic);
		}
		Thread.sleep(10000);
	}

}
