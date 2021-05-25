package com.study.spring;

import com.study.spring.board.domain.Board;
import com.study.spring.board.enums.SocialType;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.domain.User;
import com.study.spring.board.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.IntStream;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootStudyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception {
		return (args) -> {
			User user = userRepository.save(User.builder().name("민성").password("test").email("luv.mins99@gmail.com").principal("").socialType(SocialType.GOOGLE).build());

			IntStream.rangeClosed(1, 10).forEach(index ->
					boardRepository.save(Board.builder().title("제목"+index).contents("내용").writer(user.getName()).build()));
		};
	}

}
