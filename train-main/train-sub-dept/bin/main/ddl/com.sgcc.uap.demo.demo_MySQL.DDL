
    drop table if exists DEPARTMENT;

    create table DEPARTMENT (
        ID varchar(42) not null comment 'id',
        DEPNAME varchar(20) comment '部门名称',
        DEPPARENTID varchar(42) comment '父ID',
        DEPDESC varchar(20) comment '描述',
        primary key (ID)
    ) comment='Department';
