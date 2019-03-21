
    drop table if exists EMPLOYEE;

    create table EMPLOYEE (
        ID varchar(50) not null comment 'id',
        DEPID varchar(50) comment '部门ID',
        NAME varchar(50) comment '员工姓名',
        NUM varchar(50) comment '员工编号',
        AGE varchar(10) comment '年龄',
        SEX varchar(10) comment '性别',
        ADDRESS varchar(255) comment '地址',
        TEL varchar(50) comment '电话',
        INDUCTIONTIME varchar(50) comment '入职时间',
        primary key (ID)
    ) comment='Employee';
