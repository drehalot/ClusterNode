package system.node;

import com.sun.management.OperatingSystemMXBean;

import java.text.DecimalFormat;

public class SwapItem extends MemoryAbstract {
    public SwapItem(OperatingSystemMXBean osMBean) {
        super(osMBean);
    }

    public double getSwapTotal() {
        return osMBean.getTotalSwapSpaceSize() / sizeInGb;
    }

    public double getSwapFree() {
        return osMBean.getFreeSwapSpaceSize() / sizeInGb;
    }

    @Override
    public double getUsed() {
        return (double) 1 - getSwapFree() / getSwapTotal();
    }
}
