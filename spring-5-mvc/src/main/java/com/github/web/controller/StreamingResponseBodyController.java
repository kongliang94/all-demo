package com.github.web.controller;

import com.github.constant.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.Date;

/**
 * @description: 3
 * @author: KL
 * @create: 2019-08-02
 */
@Controller
public class StreamingResponseBodyController {

    @GetMapping(Constants.API_SRB)
    public ResponseEntity<StreamingResponseBody> handleRbe() {
        StreamingResponseBody stream = out -> {
            String msg = Constants.API_SRB_MSG + " @ " + new Date();
            out.write(msg.getBytes());
        };
        return new ResponseEntity(stream, HttpStatus.OK);
    }

}