# draco
## core-device

### model
* 产品（product）：某一类设备\网关的抽象，产品下的设备\网关拥有共同的属性变量和消息类型。
  包含字段：ID、名称、描述、产品属性变量列表、产品的消息类型列表
* （产品）属性变量（attribute)： ID、代码、名称、数据类型、上限值、下限值、属性分组，组内顺序号、描述、启用标识
* （产品）属性变量分组（attribute_group）: ID、组代码、组名称、数据类型、启用标识
* （产品）消息类型(message_type)：ID、代码、名称、描述、启用标识、归类
* 设备(device)：ID、代码、名称、所属产品、所属网关、属性map、topic集合
* 网关(gateway)：ID、代码、名称、描述、所属产品、绑定用户、绑定用户密码，IP地址

### contact
* 设备topic的组成： 网关代码\产品代码\设备代码\消息类型
* 网管topic: 网关代码\消息类型
* 威纶通网关的数据组包规则：



### interface

* /api/product  产品条件查询
* /api/product/{id} 按ID查询产品详情
* /api/product/add  新增一个产品
* /api/product/{id}/update	修改产品信息
* /api/product/{id}/delete  删除产品
* /api/product/{id}/attribute	查询产品属性变量
* /api/product/{id}/attribute/{aid}	查询产品属性变量详情
* /api/product/{id}/attribute/add  给产品增加属性变量
* /api/product/{id}/attribute/{aid}/remove 删除产品的属性变量
* /api/product/{id}/attribute/{aid}/update 修改产品的指标
* /api/product/{id}/message_type 查看产品的消息类型
* /api/product/{id}/message_type/add 增加一种消息类型
* /api/product/{id}/message_type/{tid}/remove 删除制定的消息类型
* /api/product/{id}/message_type/{tid}/update 修改产品的消息类型
* /api/product/{id}/device 查询产品下的设备

* /api/device  查询设备， 条件： 产品Id，网关Id，设备名称关键字
* /api/device/{id}  按ID查询设备详情
* /api/device/add 创建设备
* /api/device/{id}/delete 删除设备
* /api/device/{id}/update 修改设备
* /api/device/{id}/topic 查询设备的topic

* /api/gateway 查询网关
* /api/gateway/{id} 按ID查询网关详情
* /api/gateway/add 创建网关
* /api/gateway/{id}/delete 删除网关
* /api/gateway/{id}/update 修改网关信息
* /api/gateway/{id}/device  查询网关下的设备
* /api/gateway/{id}/topic 查询网关的topic
* /api/gateway/{id}/validate 网关验证





