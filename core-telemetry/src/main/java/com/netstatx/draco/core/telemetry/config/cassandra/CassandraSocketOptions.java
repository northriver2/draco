package com.netstatx.draco.core.telemetry.config.cassandra;

import com.datastax.driver.core.SocketOptions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Configuration
@Data
public class CassandraSocketOptions {

    @Value("${cassandra.socket.connect_timeout}")
    private int connectTimeoutMillis;
    @Value("${cassandra.socket.read_timeout}")
    private int readTimeoutMillis;
    @Value("${cassandra.socket.keep_alive}")
    private Boolean keepAlive;
    @Value("${cassandra.socket.reuse_address}")
    private Boolean reuseAddress;
    @Value("${cassandra.socket.so_linger}")
    private Integer soLinger;
    @Value("${cassandra.socket.tcp_no_delay}")
    private Boolean tcpNoDelay;
    @Value("${cassandra.socket.receive_buffer_size}")
    private Integer receiveBufferSize;
    @Value("${cassandra.socket.send_buffer_size}")
    private Integer sendBufferSize;

    private SocketOptions opts;

    @PostConstruct
    public void initOpts() {
        opts = new SocketOptions();
        opts.setConnectTimeoutMillis(connectTimeoutMillis);
        opts.setReadTimeoutMillis(readTimeoutMillis);
        if (keepAlive != null) {
            opts.setKeepAlive(keepAlive);
        }
        if (reuseAddress != null) {
            opts.setReuseAddress(reuseAddress);
        }
        if (soLinger != null) {
            opts.setSoLinger(soLinger);
        }
        if (tcpNoDelay != null) {
            opts.setTcpNoDelay(tcpNoDelay);
        }
        if (receiveBufferSize != null) {
            opts.setReceiveBufferSize(receiveBufferSize);
        }
        if (sendBufferSize != null) {
            opts.setSendBufferSize(sendBufferSize);
        }
    }
}
