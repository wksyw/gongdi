drop database if exists db_gongdi;
create database db_gongdi;

use db_gongdi;
/* 用户表 */
drop table if exists t_user;
create table t_user
(
  id                        int              not null				AUTO_INCREMENT,         -- 编号
											 
  username                  varchar(20)      not null,                                      -- 用户名
  
  type		        		tinyint      	 not null,                                      -- 用户类型		
 
  data				        text		     null,								            -- 用户其余数据
  
  primary key(id)
);


/* 发单表 */
drop table if exists t_order;
create table t_order
(
  id                        int              not null				AUTO_INCREMENT,			-- 编号					        
					        
  name                      varchar(50)      not null,                                      -- 发单名称  																			            															            
					        
  status 			        tinyint          not null,						    			-- 状态																	
  																						    				        
  data				        text		     not null,								        -- 发单其余数据，发单表单数据
					        
  userId			        int              not null,						                -- 用户表id
  
  primary key(id)
);