package com.aws.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class AwsProjectApplication {

    public static final List<String> values = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Aws project";
    }

    @GetMapping("/values")
    public List<String> showValues() {
        return values;
    }

    @PostMapping("/setValue")
    public String addValue (@RequestBody String val) {
        try {
            values.add(val);
            return "Added " + val + " to the list";
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail adding " + val + " to list";
        }
    }
    public static class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

    public static void main(String[] args) {
       SpringApplication.run(AwsProjectApplication.class, args);
    }
}
