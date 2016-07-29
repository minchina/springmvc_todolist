package com.tw.todolist.service;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class TemplateService {

    private final Configuration configuration;

    public TemplateService(Configuration configuration) {
        this.configuration = configuration;
    }
    public String populateTemplate(String templateName, Map<String, Object> modelMap) throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        Writer writer = new StringWriter();
        template.process(modelMap, writer);
        return writer.toString();
    }



}
