import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@Controller
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

//    @RequestMapping(path = "/")
//    @ResponseBody
////    MainObject home(@RequestParam(required = false, defaultValue = "Dear User") String user) throws ClassNotFoundException, SQLException {
////        return new MainObject(user);
//    }

    @RequestMapping(path = "/index")
    @ResponseBody
    ArrayList<Greeting> greeting(@RequestParam(required = false, defaultValue = "10") Integer size) {
        System.out.println("==== in greeting ====");
        ArrayList<Greeting> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Greeting(new Random().nextInt(Integer.MAX_VALUE),
                    new RandomStringUtils().randomAlphabetic(10), new Random().nextBoolean()));
        }
        return arrayList;
    }

    @RequestMapping(path = "/getstatusofnode")
    @ResponseBody
    InfoNode getInfo() throws IOException {
        return new InfoNode();
    }
}