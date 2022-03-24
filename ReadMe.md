### 一、如何遍历流程节点
####1、外部如何传入：
#####①、传入构造好的root节点，去遍历子节点和右节点 
#####②、传入nodeId的序列，根据规则如栈，重新组装构造
#####③、传入一个栈的List，弹出遍历
### 二、如何持久化节点和还原节点
####1、持久化方案确认：存储每个节点的长子节点ID，右节点ID,分离节点和节点信息字段
借用栈的方式，后入先出的顺序插入DB
节点关联信息 左节点和父亲节点预留
`nodeID processId DataId parentNodeId firstChildNodeId rightNodeId leftNodeId overTime state delFlag createBy createTime updateBy updateTime`    
节点消息字段     
`DataId operator replyContent operatMethod ...`   
流程表?  
`processId processName? processType state createBy createTime updateBy updateTime`
####2、还原方案：读取DB节点关联关系，由于插入是后入先出，通一个流程下的节点关系逆序排列则是流程节点顺序。
##### ①List/Map读取节点关联对象，可以根据DataId加载节点消息字段。
##### ②内存存在方式1:通过Map</key:nodeId,value:节点>/节点保存关联关系。有利于指定NodeId直接查询，指定NodeId插入删除
##### ②内存存在方式2:通过ROOT节点保存所有对象的引用关系。
### 三、代码优化
#### 1、去掉左节点，有stackOver的风险，省空间
#### 2、所有节点的操作方法封装到INodeOperation
#### 3、什么情况try catch、什么情况throw..自己封装的异常打印log，throw可读的异常信息出去，由外层封装，系统的异常也Log堆栈，再封装自己的可读异常出去
### 四、思考前端