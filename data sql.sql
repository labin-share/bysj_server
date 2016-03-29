-- create customer record
-- show columns from customer;
insert into customer(phone,psw,name)
values(10086,'password','10086');
insert into customer(phone,psw,name)
values(1363122,'password','Deliwib');

-- create mantainer record
-- show columns from mantainer
-- select * from mantainer
-- delete from mantainer where mtn_id>=1
insert into mantainer(MTN_ID,address,SIGNATURE,phone,name,psw,LONGITUDE,LATITUDE)
values(1,'guangzhou','大家好才是真的好','13631225776','alibaba','password',12.2,12.2);
insert into mantainer(MTN_ID,address,SIGNATURE,phone,name,psw,LONGITUDE,LATITUDE)
values(2,'shenzhen','this is baidu','13631225789','baidu','password',10,10);
insert into mantainer(MTN_ID,address,SIGNATURE,phone,name,psw,LONGITUDE,LATITUDE)
values(3,'lufeng','hi, i am tengxun','13631227776','tenxun','password',100.12,100.12);

-- create mantain_type record
-- show columns from mantain_type
-- select * from mantain_type
-- delete from mantain_type where mtn_id>=1
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(1,'2016','2016','冰箱');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(1,'2016','2016','电视');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(1,'2016','2016','手机');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(2,'2016','2016','空调');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(2,'2016','2016','笔记本电脑');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(3,'2016','2016','冰箱');


-- create sheet record
-- show columns from sheet;
-- select * from sheet;
-- delete from sheet where id>=1
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE)
values(1,'冰箱','zhuhai','20160325121212','10086',1,0,1,'态度还不错，准时到达，最后把冰箱改造成了微波炉，技术真棒','20161008111111',1,2,3);
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE)
values(2,'洗衣机','shanghai','20160325121212','13800138000',1,1,1,'his skill so good ! i will come next time','20161008111111',2,4,5);
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE)
values(3,'电视','shenzheng','20160325121212','1008611',1,2,1,'一般般','20161008111111',1,0,3);
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE)
values(6,'电视','shenzheng','20160325121212','1008611',1,2,1,null,null,1,0,3);
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE)
values(4,'烤箱','lufeng','20160325121212','1363122',1,0,2,'技术还行，服务态度不好','20161008111111',2,2,2);
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE)
values(5,'电视','shangwei','20160325121212','1363122',2,0,2,'迟到了半个钟','20161008111111',1,1,1);

-- create sheet_progress record
-- show columns from sheet_progress
insert into sheet_progress(id,content,CREATE_DATE,SHEET_ID)
values(1,'just do it','20160328111111',1);
insert into sheet_progress(id,content,CREATE_DATE,SHEET_ID)
values(2,'just do it agian','20160328111011',1);
insert into sheet_progress(id,content,CREATE_DATE,SHEET_ID)
values(3,'i have do third times','20160328081111',1);



-- set global general_log = on





