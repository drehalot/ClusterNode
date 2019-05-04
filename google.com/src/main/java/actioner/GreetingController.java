package actioner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@Controller
public class GreetingController {

    @RequestMapping(path = "/index")
    @ResponseBody
    public ArrayList<Greeting> greeting(@RequestParam(required = false, defaultValue = "10") Integer size) {
        ArrayList<Greeting> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Greeting(new Random().nextInt(Integer.MAX_VALUE),
                    "d", new Random().nextBoolean()));
        }
        return arrayList;
    }

}
