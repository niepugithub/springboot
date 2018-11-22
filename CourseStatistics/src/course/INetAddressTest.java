package course;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2018/11/14 23:15
 **/
public class INetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress me = InetAddress.getLocalHost();
        System.out.println(me);
        System.out.println(me.getCanonicalHostName());
        System.out.println(me.getAddress().length);
        System.out.println(me.getHostAddress());
    }
}
