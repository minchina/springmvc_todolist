package com.tw.todolist.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(value = "/file")
public class FileController {

    public static String FILE_PATH= "/Users/ncmao/dev/workspace/java_wp";

    private static final Logger logger = LoggerFactory
            .getLogger(FileController.class);


    @RequestMapping(value = "/show", method = GET)
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("upload");
        return modelAndView;
    }


    @RequestMapping(value = "/uploadFile", method = POST)
    public String upload(@RequestParam("name") String fileName, @RequestParam("file") MultipartFile file) {

        if(!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File dir = new File(FILE_PATH + File.separator + "tempfiles");
                if(!dir.exists()) {
                    dir.mkdirs();
                    File serverFile = new File(dir.getAbsolutePath()
                            + File.separator + fileName);
                    BufferedOutputStream stream = new BufferedOutputStream(
                            new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();

                    logger.info("Server File Location="
                            + serverFile.getAbsolutePath());

                    return "You successfully uploaded file=" + fileName;
                }

            } catch (IOException e) {
                return "You failed to upload " + fileName + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + fileName
                    + " because the file was empty.";
        }
        return fileName;
    }
}
