package org.tw.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.todolist.domain.ToDo;
import com.tw.todolist.domain.User;
import org.junit.Test;

import java.io.IOException;

public class TestCurrentDirectory {


    @Test
    public void should_Get_current_directory(){

        String property = System.getProperty("user.dir");
        System.out.println(property);
        String path = ToDo.class.getResource("").getPath();
        System.out.println(path);
    }

    @Test
    public void shoudConverterObjToJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setName("test");
        String asString = mapper.writeValueAsString(user);
        System.out.println(asString);
//        mapper.writeValue(new File(ToDo.class.getResource("").getPath() + "user.json"), user);
    }
}
