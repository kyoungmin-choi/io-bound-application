package class101.foo.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PostRepository postRepository;

    // 아래의 큐를 계속 컨슘하고 있는 상태. 큐에 메시지가 들어오면 메소드가 호출이되고 스트링을 읽어오고 문자열을 post클래스로 변경
    @RabbitListener(queues = "CREATE_POST_QUEUE")
    public void handler(String message) throws JsonProcessingException {
        Post post = objectMapper.readValue(message, Post.class);
        postRepository.save(post);
    }
}
