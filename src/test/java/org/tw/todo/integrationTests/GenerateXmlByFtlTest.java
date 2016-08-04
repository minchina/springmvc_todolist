package org.tw.todo.integrationTests;


import com.tw.todolist.service.TemplateService;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class GenerateXmlByFtlTest {

    private static final String TEMPLATE_NAME = "xmlTest.ftl";

    @Autowired
    private TemplateService templateService;

    @Test
    public void shouldGenerateXML() throws IOException, TemplateException {

        Map<String,Object> model = new HashMap<String , Object>();
        model.put("name", "hello,world");
        String result = templateService.populateTemplate(TEMPLATE_NAME, model);
        assertTrue(result.contains("hello,world"));
    }
}
