package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController()
@RequestMapping("/math")
public class TestController {
    private String fileUrl = "C:\\Users\\hank\\Desktop\\result.txt";


    @PostMapping("/add")
    public Integer addMethod(@RequestBody AddData data) {
        Integer target = this.add(data.getTargetA(), data.getTargetB());
        File file = new File(fileUrl);
        this.writeToFile(file, target);
        return target;
    }

    public int add(Integer targetA, Integer targetB) {
        return Math.addExact(targetA, targetB);
    }

    public void writeToFile(File file, Integer target) {
        if (file.exists()) {
            OutputStream outputStream = null;
            OutputStreamWriter writer = null;
            try {
                outputStream = new FileOutputStream(file);
                writer = new OutputStreamWriter(outputStream);
                writer.write(target.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    outputStream.flush();
                    writer.flush();
                    outputStream.close();
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}