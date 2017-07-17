package com.netstatx.draco.snowflake.client;



/**
 * @author wangle<thisiswangle@gmail.com>
 */
public class SnowflakeClientTest {
    public static void main(String[] args) {
        SnowflakeClient client = new SnowflakeClient("127.0.0.1", 8982);
        System.out.println(client.getUUID());
    }
}