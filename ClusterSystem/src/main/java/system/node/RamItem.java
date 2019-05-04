package system.node;

import com.sun.management.OperatingSystemMXBean;

import java.text.DecimalFormat;

public class RamItem extends MemoryAbstract {

    public RamItem(OperatingSystemMXBean osMBean) {
        super(osMBean);
    }

    @Override
    public double getUsed() {
        return (double) 1 - getRamFree() / getRamTotal();
    }

    public double getRamTotal() {
        return osMBean.getTotalPhysicalMemorySize() / sizeInGb;
    }

    public double getRamFree() {
        return osMBean.getFreePhysicalMemorySize() / sizeInGb;
    }
}
