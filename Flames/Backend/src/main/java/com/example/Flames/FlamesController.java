package com.example.Flames;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class FlamesController {

    @PostMapping("/result")
    public Map<String, String> getResult(@RequestParam String boy,
                                         @RequestParam String girl) {

        boy = boy.toLowerCase().replaceAll("\\s", "");
        girl = girl.toLowerCase().replaceAll("\\s", "");

        char[] a = boy.toCharArray();
        char[] b = girl.toCharArray();

        int len = a.length + b.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    len -= 2;
                    a[i] = '0';
                    b[j] = '0';
                    break;
                }
            }
        }

        if (len == 0) len = 1;

        String f = "flames";
        String res = fun(f, len);
        String res1 = fun(res, len);
        String res2 = fun(res1, len);
        String res3 = fun(res2, len);
        String res4 = fun(res3, len);

        char result = res4.charAt(0);

        String finalResult = "";
        String emoji = "";

        switch (result) {
            case 'f' -> { finalResult = "Friends"; emoji = "🤝"; }
            case 'l' -> { finalResult = "Love"; emoji = "❤️"; }
            case 'a' -> { finalResult = "Affection"; emoji = "😊"; }
            case 'm' -> { finalResult = "Marriage"; emoji = "💍"; }
            case 'e' -> { finalResult = "Enemies"; emoji = "😈"; }
            case 's' -> { finalResult = "Siblings"; emoji = "👫"; }
        }

        Map<String, String> response = new HashMap<>();
        response.put("result", finalResult);
        response.put("emoji", emoji);

        return response;
    }

    static String fun(String str, int len) {
        int index = (len - 1) % str.length();
        return str.substring(index + 1) + str.substring(0, index);
    }
}
