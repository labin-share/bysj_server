-- create customer record
-- show columns from customer;
-- select * from customer
-- delete from customer where customer_id>=1
insert into customer(CUSTOMER_ID,phone,psw,name,SIGNATURE,LAST_UPDATE_DATE,CREATE_DATE)
values(1,10086,'password','10086','SIGNATURE english test','20160401111111','20160401111111');
insert into customer(CUSTOMER_ID,phone,psw,name,SIGNATURE,LAST_UPDATE_DATE,CREATE_DATE)
values(2,1363122,'password','Deliwib','咻咻咻','20160401111111','20160401111111');
insert into customer(CUSTOMER_ID,phone,psw,name,SIGNATURE,LAST_UPDATE_DATE,CREATE_DATE)
values(3,1363,'password','lin wei bin','咻咻咻','20160401111111','20160401111111');

-- create contaction record
-- show columns from contaction
insert into contaction(id,ADDRESS,PHONE,CUSTOMER_ID)
values(1,'beijing','13800',1);
insert into contaction(id,ADDRESS,PHONE,CUSTOMER_ID)
values(2,'zhuhai','13800138000',1);
insert into contaction(id,ADDRESS,PHONE,CUSTOMER_ID)
values(3,'澳门','13800',1);
insert into contaction(id,ADDRESS,PHONE,CUSTOMER_ID)
values(4,'beijing','1008611',2);

-- create mantainer record
-- show columns from mantainer
-- select * from mantainer
-- delete from mantainer where mtn_id>=1
insert into mantainer(MTN_ID,address,SIGNATURE,phone,name,psw,LONGITUDE,LATITUDE,TRADE_NUM,CREDIT)
values(1,'guangzhou','大家好才是真的好','13631225776','alibaba','password',12.2,12.2,3,4);
insert into mantainer(MTN_ID,address,SIGNATURE,phone,name,psw,LONGITUDE,LATITUDE,TRADE_NUM,CREDIT)
values(2,'shenzhen','this is baidu','13631225789','baidu','password',10,10,1,3);
insert into mantainer(MTN_ID,address,SIGNATURE,phone,name,psw,LONGITUDE,LATITUDE,TRADE_NUM,CREDIT)
values(3,'lufeng','hi, i am tengxun','13631227776','tenxun','password',100.12,100.12,4,5);

-- create mantain_type record
-- show columns from mantain_type
-- select * from mantain_type
-- delete from mantain_type where mtn_id>=1
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(1,'20160401111111','20160401111111','冰箱');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(1,'20160401111111','20160401111111','电视');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(1,'20160401111111','20160401111111','手机');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(2,'20160401111111','20160401111111','空调');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(2,'20160401111111','20160401111111','笔记本电脑');
insert into mantain_type(mtn_id,LAST_UPDATE_DATE,CREATE_DATE, tag)
values(3,'20160401111111','20160401111111','冰箱');


-- create customer_coll record
-- show columns from customer_coll 
-- select * from customer_coll
insert into customer_coll(id,customer_id,MANTAINER_ID,LAST_UPDATE_DATE,CREATE_DATE)
values(1,1,1,'20160401111111','20160401111111');
insert into customer_coll(id,customer_id,MANTAINER_ID,LAST_UPDATE_DATE,CREATE_DATE)
values(2,1,2,'20160401111111','20160401111111');
insert into customer_coll(id,customer_id,MANTAINER_ID,LAST_UPDATE_DATE,CREATE_DATE)
values(3,1,3,'20160401111111','20160401111111');
insert into customer_coll(id,customer_id,MANTAINER_ID,LAST_UPDATE_DATE,CREATE_DATE)
values(4,2,1,'20160401111111','20160401111111');
insert into customer_coll(id,customer_id,MANTAINER_ID,LAST_UPDATE_DATE,CREATE_DATE)
values(5,2,2,'20160401111111','20160401111111');

-- create sheet record
-- show columns from sheet;
-- select * from sheet;
-- delete from sheet where id>=1
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE,CREATE_DATE,CONTENT)
values(1,'冰箱','zhuhai','20160325121212','10086',1,0,1,'态度还不错，准时到达，最后把冰箱改造成了微波炉，技术真棒','20161008111111',1,2,3,'20160101111111','来帮我改造冰箱');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE,CREATE_DATE,CONTENT)
values(2,'洗衣机','shanghai','20160325121212','13800138000',1,1,1,'his skill so good ! i will come next time','20161008111111',2,4,5,'20160101111111','洗衣机坏了，可能是内裤洗多了');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE,CREATE_DATE,CONTENT)
values(3,'电视','shenzheng','20160325121212','1008611',1,2,1,'一般般','20161008111111',1,0,3,'20160101111111','罢工了');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE,CREATE_DATE,CONTENT)
values(6,'电视','shenzheng','20160325121212','1008611',1,2,1,null,null,1,0,3,'20160101111111','看不了了，一直在播新闻联播，每个台都一样，咋回事');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE,CREATE_DATE,CONTENT)
values(4,'烤箱','lufeng','20160325121212','1363122',1,0,2,'技术还行，服务态度不好','20161008111111',2,2,2,'20160101111111','火麒麟进去，变成冰淇淋，肯定坏了');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,EVALUATION,EVA_TIME,Attitude,MTN_SPEED,ACHIEVE,CREATE_DATE,CONTENT)
values(5,'电视','shangwei','20160325121212','1363122',2,0,2,'迟到了半个钟','20161008111111',1,1,1,'20160101111111','来吧，看不了了');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,CREATE_DATE,CONTENT)
values(7,'电视','budalagong','20160402121212','13631225776',2,6,2,'20160402121212','来吧，看不了了');
insert into sheet(id,type,address,EXPECTIVE_TIME,PHONE,CUSTOMER_ID,STATE,MTNER_ID,CREATE_DATE,CONTENT)
values(8,'笔记本','budalagong','20160402121212','110',2,6,2,'20160402121212','来吧，换了内存就用不了了');

-- create sheet_progress record
-- show columns from sheet_progress
-- delete From sheet_progress where id>=1
insert into sheet_progress(id,content,CREATE_DATE,SHEET_ID)
values(1,'just do it','20160328111111',1);
insert into sheet_progress(id,content,CREATE_DATE,SHEET_ID)
values(2,'just do it agian','20160328111011',1);
insert into sheet_progress(id,content,CREATE_DATE,SHEET_ID)
values(3,'i have do third times','20160328081111',1);


-- create chargeback record
-- show columns from chargeback
-- select * from chargeback
-- delete from chargeback where id>=1
insert into chargeback(id,reason,sheet_id,state,content,create_date,last_update_date)
values(2,2,7,0,'可能是影响到其他的固件，导致新的问题','20160402111111','20160402111111');
insert into chargeback(id,reason,sheet_id,state,content,create_date,last_update_date)
values(3,2,7,1,'可能是影响到其他的固件，导致新的问题','20160403111111','20160403111111');
insert into chargeback(id,reason,sheet_id,state,content,create_date,last_update_date)
values(4,3,8,0,'本来只有一点问题，现在彻底报废了','20160402111111','20160402111111');
insert into chargeback(id,reason,sheet_id,state,content,create_date,last_update_date)
values(5,3,8,1,'本来只有一点问题，现在彻底报废了','20160403111111','20160403111111');
insert into chargeback(id,reason,sheet_id,state,content,create_date,last_update_date)
values(6,3,8,2,'本来只有一点问题，现在彻底报废了','20160404111111','20160404111111');


-- set global general_log = on

