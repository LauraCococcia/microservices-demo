drop table T_PRODUCT if exists;

create table T_PRODUCT (ID bigint identity primary key, QUANTITY int,
                        NAME varchar(50) not null, IMAGE varchar(50) not null,
                        	WEBID bigint, PRICE int);
                        
ALTER TABLE T_PRODUCT ALTER COLUMN PRICE SET DEFAULT 0.0;