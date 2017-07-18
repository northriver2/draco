draco
========

## Intro

* DP-{\d}-{\d+}: 标识将要开发的功能点, DP=Develop Plan


## 数据传输服务（transport）


* [DP-1-1] 实现 mqtt 协议, 支持定义 topic，同时根据 topic 类型支持不同数据格式的消息，例如在 topic 中添加关键字
    * /productKey/deviceKey/data
    * /raw/projectKey/deviceKey/data

* [DP-1-2] 实现 http 协议收集数据，不支持服务器推送数据，可实现 pull 模式数据下发
* [DP-1-3] 实现 mtp 协议，支持点对点数据采集和下发（mtp为之前定的传输协议）
* [DP-1-4] 定义 RPC，在各协议上实现
* [DP-1-5] 考虑多节点模式，消除接入单点故障(*)

## 设备管理(devices)

* [DP-2-1] 单个设备增删查改，包括设备属性
    * 设备可以上传或者服务器可以下发对应的属性值，如 sn，hardware_version, firmware_version
    * 仅通过服务端修改，如设备密钥
    * 不可变内容，设备 ID

* [DP-2-2] 产品管理，对设备进行分组，同一个产品下的设备，可以共享部分属性


## 数据处理(telemetry)

* [DP-3-1] 数据存储和查询(cassandra)
* [DP-3-2] filter/process/action: 支持基本的数据规则处理逻辑，如大于一个值则发邮件报警
* [DP-3-3] 自定义二进制数据流的解析


## 用户管理

* [DP-4-1] 支持多用户
* [DP-4-2] 每个用户可以有对应的产品和设备


## 基础功能服务

包括业务无关的基础功能服务

### 服务发现(core-discovery)

强调 AP 特性的服务发现服务，为所有微提供注册和发现能力(eureka)

### 服务配置(core-config)

为所有微服务提供在线配置管理能力

### 边界服务(core-edge)

为外接服务提供 RESTful 接口服务

### uuid 生成器(snowflake)

单节点每秒可生成 409.6w 个(理论值)单调递增的长度为 64 位（8个字节）的 uuid，可作为关系数据库的主键以便让数据聚簇

## 扩展功能

* 发短信/电话服务
* 邮件服务
* 支付服务
* 日志处理服务



