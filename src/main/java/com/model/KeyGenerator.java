package com.model;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class KeyGenerator {

    private int hostOfInt;//主机名字符 的 ascii码叠加 和
    private int ip;//ip后两位 叠加的和
    private Random random;
    private static KeyGenerator single = null;

    private KeyGenerator() {
        init();
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static synchronized KeyGenerator instance() {
        if (single == null) {
            single = new KeyGenerator();
        }
        return single;
    }

    public Long generator() {
        String luuid = (int) (hostOfInt * (1 - Math.random())) + "";//前4位
        luuid += ((int) (ip * (1 - Math.random())));
        luuid += String.valueOf(System.currentTimeMillis()).substring(3);
        //long型最长为19位，补齐后面的位数
        while (luuid.length() != 18) {
            int tmp = 18 - luuid.length();
            int seed = (int) Math.pow(10, tmp) - 1;
            luuid += random.nextInt(seed);
        }
        luuid = (8 - random.nextInt(8)) % 9 + luuid;
        return Long.valueOf(luuid);
    }

    /**
     * 根据系统信息初始化
     */
    private void init() {
        try {
            random = new Random();//随机数
            //ip
            byte[] ipbyte = InetAddress.getLocalHost().getAddress();
            if (ipbyte != null && ipbyte.length == 4) {
                ip = ipbyte[2] + ipbyte[3];
                if (ip > 512) {
                    ip = ip % 512;
                }
            } else {
                ip = random.nextInt(512);
            }
            ip = Math.abs(ip);
            //hostname
            String host = InetAddress.getLocalHost().getHostName();
            byte[] hostByte = host.getBytes("iso-8859-1");
            hostOfInt = 0;
            for (byte b : hostByte) {
                hostOfInt += b;
            }
            hostOfInt = Math.abs(hostOfInt);
            if (hostOfInt > 8192) {
                hostOfInt = hostOfInt % 8192;
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException("fetch hostname failed!", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("not support encoding", e);
        }
    }

    public static Long id() {
        return KeyGenerator.instance().generator();
    }
}
