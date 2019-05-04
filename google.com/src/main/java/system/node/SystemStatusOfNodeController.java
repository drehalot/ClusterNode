package system.node;

import actioner.InfoNode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@ComponentScan
@RestController
public class SystemStatusOfNodeController {
    @RequestMapping(path = "/getstatusofnode")
    @ResponseBody
    public InfoNode getInfo() throws IOException {
        return new InfoNode();
    }
}
