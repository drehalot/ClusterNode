package actioner;

import com.sun.management.OperatingSystemMXBean;
import system.node.MemoryAbstract;
import system.node.RamItem;
import system.node.SwapItem;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DecimalFormat;

public class InfoNode {

    private OperatingSystemMXBean osMBean;

    public InfoNode() throws IOException {
        MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();

        osMBean = ManagementFactory.newPlatformMXBeanProxy(
                mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
    }

    public String getNameOfHost() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    public String getArchitecture() {
        return osMBean.getArch();
    }

    public String getNameOfOs() {
        return osMBean.getName();
    }

    public RamItem getRam() {
        return new RamItem(osMBean);
    }

    public SwapItem getSwap() {
        return new SwapItem(osMBean);
    }

    public double getCpuUsege() {
        return 100 * osMBean.getSystemCpuLoad();
    }

    public String getIp() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

}