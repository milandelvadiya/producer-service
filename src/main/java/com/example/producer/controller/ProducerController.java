package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProducerController {

    @Autowired
    Environment environment;

    @Value("${text.message}")
    String textMessage;

    @GetMapping("/producer")
    public String getData(){
        return " Hello from producer :"+environment.getProperty("server.port");
    }

    @GetMapping("/config")
    public String getConfigData(){
        return " Configuration message :"+textMessage;
    }


//    @GetMapping("/producer/data")
//    public ResponseEntity getPdfData() throws IOException {
//
//        String filename = getClass().getResource("/static/CreditCardStatement.pdf").getFile();
//        File file = new File(filename);
//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] pdf1Bytes = new byte[(int) file.length()];
//        fileInputStream.read(pdf1Bytes);
//        fileInputStream.close();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/pdf"));
//        headers.add("content-disposition", "inline;filename=" + filename);
//        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdf1Bytes, headers, HttpStatus.OK);
//        return response;
//    }
}
