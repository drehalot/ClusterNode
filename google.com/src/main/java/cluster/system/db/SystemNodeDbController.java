package cluster.system.db;

import charts.Chart;
import charts.ChartData;
import cluster.system.db.entity.SystemNodeDbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@ComponentScan
@Controller
public class SystemNodeDbController {
    @Autowired
    private SystemNodeRbItemRepository systemNodeRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/gettableresult")
    @ResponseBody
    public String getTableResult() {

        ArrayList<ChartData> chartData = new ArrayList<>();

        Iterable<SystemNodeDbItem> nodes = systemNodeRepository.findAll();
        for (SystemNodeDbItem str : nodes) {
            float coef = str.getCoefficientOfReliabilityOfNode() * (str.getRealTimeOfCalculation() / str.getTotalTimeOfCalculation())
                    * ((float) str.getRealNumberOfTasks() / (float) str.getTotalNumberOfTasks());
            chartData.add(new ChartData(str.getNameOfNode(), coef));
        }
        return new Chart("fffff", chartData).getChart().toString();
    }
}
