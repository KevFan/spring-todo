package com.todo.base;

import com.todo.domain.Todo;
import com.todo.domain.User;
import com.todo.repository.TodoRepository;
import com.todo.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTestBase {
    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected TodoRepository todoRepository;

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        User user = new User("user", "$2a$10$y.9Bnm2HX2XBI4grbjjBZesi5ntrw2ICT4g5Ad3YjqKHoQhi5AZPq");
        userRepository.save(user);
        userRepository.save(new User("user2", "$2a$10$y.9Bnm2HX2XBI4grbjjBZesi5ntrw2ICT4g5Ad3YjqKHoQhi5AZPq"));

        todoRepository.save(new Todo("My inserted todo", user));
        todoRepository.save(new Todo("My inserted todo 2", user));
        todoRepository.save(new Todo("My inserted todo 3", user));
    }

    @After
    public void cleanup() {
        todoRepository.deleteAll();
        userRepository.deleteAll();
    }
}
