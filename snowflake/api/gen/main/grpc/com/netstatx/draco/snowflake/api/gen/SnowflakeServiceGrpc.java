package com.netstatx.draco.snowflake.api.gen;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: snowflake.proto")
public final class SnowflakeServiceGrpc {

  private SnowflakeServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.SnowflakeService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest,
      com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID> METHOD_GET_UUID =
      io.grpc.MethodDescriptor.<com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest, com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.SnowflakeService", "GetUUID"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SnowflakeServiceStub newStub(io.grpc.Channel channel) {
    return new SnowflakeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SnowflakeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SnowflakeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SnowflakeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SnowflakeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SnowflakeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUUID(com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_UUID, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_UUID,
            asyncUnaryCall(
              new MethodHandlers<
                com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest,
                com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID>(
                  this, METHODID_GET_UUID)))
          .build();
    }
  }

  /**
   */
  public static final class SnowflakeServiceStub extends io.grpc.stub.AbstractStub<SnowflakeServiceStub> {
    private SnowflakeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SnowflakeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnowflakeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SnowflakeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUUID(com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest request,
        io.grpc.stub.StreamObserver<com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_UUID, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SnowflakeServiceBlockingStub extends io.grpc.stub.AbstractStub<SnowflakeServiceBlockingStub> {
    private SnowflakeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SnowflakeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnowflakeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SnowflakeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID getUUID(com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_UUID, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SnowflakeServiceFutureStub extends io.grpc.stub.AbstractStub<SnowflakeServiceFutureStub> {
    private SnowflakeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SnowflakeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SnowflakeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SnowflakeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID> getUUID(
        com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_UUID, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_UUID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SnowflakeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SnowflakeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_UUID:
          serviceImpl.getUUID((com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.Snowflake.UUID>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class SnowflakeServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.netstatx.draco.snowflake.api.gen.SnowflakeProtos.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SnowflakeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SnowflakeServiceDescriptorSupplier())
              .addMethod(METHOD_GET_UUID)
              .build();
        }
      }
    }
    return result;
  }
}
