package system.node;

import com.sun.management.OperatingSystemMXBean;

public abstract class MemoryAbstract {

    protected long sizeInGb = 1024 * 1024;

    protected OperatingSystemMXBean osMBean;

    public final static String PATTER_FOR_USEGE = "###.####";

    public MemoryAbstract(OperatingSystemMXBean osMBean) {
        this.osMBean = osMBean;
    }

    public abstract double getUsed();
}
