package class101.foo.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// 크론 표현식을 이용해서 스케줄링을 사용할 수 있음
@EnableScheduling
@SpringBootApplication
public class IoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoApplication.class, args);
	}

}
