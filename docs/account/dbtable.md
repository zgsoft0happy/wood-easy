数据表


账户表  
```
CREATE TABLE account_tb(
  id bigint not null auto_increment comment "用户ID",
  `username` varchar(56) not null default '' comment "用户名",
  `password` varchar(56) not null default '' comment "密码",
  show_name varchar(90) not null default '' comment "用户昵称",
  real_name varchar(60) not null default '' comment "真实姓名",
  phone varchar(20) not null default '' comment "电话",
  qq varchar(15) not null default '' comment "qq号码",
  wechat varchar(30) not null default '' comment "微信号",
  email varchar(60) not null default '' comment "email",
  education tinyint not null default '0' comment "学历，详见dictionary_tb",
  age tinyint not null default '0' comment "年龄",
  gender tinyint not null default '0' comment "用户性别",
  remark varchar(255) not null default '' comment "备注",
  `delete` tinyint not null default '0' comment "是否删除，1删除，0未删除",
  primary key (`id`),
  index idx_username(`username`)
)Engine=InnoDB default charset=utf8 comment "用户帐号信息表";
```
字典表
```
CREATE TABLE dictionary_tb(
  id bigint not null auto_increment comment "主键ID",
  `type` varchar(48) not null default '' comment "字典数据类型",
  type_name varchar(48) not null default '' comment "字典数据类型名称",
  `value` tinyint not null default '0' comment "字典数据类型的值",
  `description` varchar(56) not null default '' comment "字典数据类型的值的描述",
  remark varchar(255) not null default '' comment "备注",
  primary key(`id`),
  index idx_type (`type`)
  )Engine=InnoDB default charset=utf8 comment "字典数据表";
```

字典表插入数据
```
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 0 , '文盲');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 1 , '小学');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 2 , '初中');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 3 , '高中');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 4 , '本科');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 5 , '硕士');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 6 , '博士');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 7 , '专科');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 8 , '中专');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 9 , '大专');
insert into dictionary_tb(`type`, type_name, `value`, description) values('education','学历', 10 , '其他');
insert into dictionary_tb(`type`, type_name, `value`, description) values('gender','性别', 0 , '未知');
insert into dictionary_tb(`type`, type_name, `value`, description) values('gender','性别', 1 , '男');
insert into dictionary_tb(`type`, type_name, `value`, description) values('gender','性别', 2 , '女');
```
