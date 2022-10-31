DROP database Project1
create database Project1 
use Project1

CREATE TABLE tblRole(
	role varchar(3) Primary key ,
	name nvarchar(20) 
) 

CREATE TABLE tblAccount(
	rID nvarchar(10) PRIMARY KEY NOT NULL,
	userID varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	fullName nvarchar(255) NOT NULL , 
	role varchar(3) FOREIGN KEY REFERENCES tblRole(role) ,  
 	status decimal(2)
)

create table tblCategory(
	cateID decimal(2) PRIMARY KEY,
	name nvarchar(50) 
)

create table tblProduct (
	ID decimal(5) PRIMARY KEY, 
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[price] [money] NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL, 
	[quantity] decimal(3) ,
	cateID decimal(2) FOREIGN KEY REFERENCES tblCategory(cateID) ,
	status decimal(2) 
)

create table tblOrder(
	orderID varchar(5) PRIMARY KEY , 
	rID nvarchar(10) NOT NULL FOREIGN KEY REFERENCES tblAccount(rID) , 
	total decimal(10) ,
	order_Date [date] NOT NULL 
)

CREATE TABLE tblOrderDetail ( 
	detailID varchar(5) PRIMARY KEY , 
	orderID varchar(5) FOREIGN KEY REFERENCES tblOrder(orderID) , 
	productID decimal(5) FOREIGN KEY REFERENCES tblProduct(ID) , 
	price [money] NULL ,
	quantity decimal(3) 
)

INSERT INTO tblCategory VALUES (1,'Baby Shirt')
INSERT INTO tblCategory VALUES (2,'Baby Shorts')
INSERT INTO tblCategory VALUES (3,'Baby Balo')
INSERT INTO tblCategory VALUES (4,'Baby Shoes')

--1 Baby Shirt
INSERT INTO tblProduct VALUES (1,N'We Bare Bears','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-ss-dai-tay-hong-5.jpg',50000,N'We Bare Bears','...',50,1,1) 
INSERT INTO tblProduct VALUES (2,N'We Bare Bears Blue','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-ss-cg-dtbt-wbb-bibos-in-tran-xanh-133908-1.jpg',40000,N'We Bare Bears Blue','...',50,1,1) 
INSERT INTO tblProduct VALUES (3,N'Dile Bare','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-dile-bibos-vang-1.jpg',55000,N'Dile Bare','...',50,1,1) 
INSERT INTO tblProduct VALUES (4,N'Gile Mommy Baby','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-gile-momma-baby-tho-mau-xanh-dam.jpg',65000,N'Gile Mommy Baby','...',50,1,1) 
INSERT INTO tblProduct VALUES (5,N'Gile Mommy Baby Slime','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-gile-momma-baby-tho-mau-xanh-nhat.jpg',35000,N'Gile Mommy Baby Slime','...',50,1,1) 
INSERT INTO tblProduct VALUES (6,N'Rapi Petit','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-dai-tay-rabi-petit-133939-12.jpg',47000,N'Rapi Petit','...',50,1,1) 
INSERT INTO tblProduct VALUES (7,N'Rapi Petit Yellow','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-dai-tay-tabi-len-tam-133989-8.jpg',35000,N'Rapi Petit Yellow','...',50,1,1) 
INSERT INTO tblProduct VALUES (8,N'Dile Bare Pink','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-dile-hong-bibos-1.jpg',50000,N'Dile Bare Pink','...',50,1,1) 
INSERT INTO tblProduct VALUES (9,N'Dile Bare Blue Slime','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-dile-bibos-xanh-1.jpg',50000,N'Dile Bare Blue Slime','...',50,1,1)
INSERT INTO tblProduct VALUES (10,N'Dile Bare White Slime','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-ba-lo-rabi-trang.jpg',50000,N'Dile Bare White Slime','...',50,1,1)
INSERT INTO tblProduct VALUES (11,N'Dile Bare 2021','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/1/3/130312c-16-10-2021-15.jpg',50000,N'Dile Bare 2021','...',50,1,1)
INSERT INTO tblProduct VALUES (12,N'Dile Bare 2021 Blue','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/1/3/130702c-16-10-2021-29.jpg',50000,N'Dile Bare 2021 Blue','...',50,1,1)
INSERT INTO tblProduct VALUES (13,N'Dile Bare 2021 Smile','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/1/3/130357c-16-10-2021-18.jpg',130000,N'Dile Bare 2021 Smile','...',50,1,1)

--2 Baby Short
INSERT INTO tblProduct VALUES (14,N'We Bare Bears Short','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/q/u/quan-bg-trang-in-hinh-gau-1.jpg',50000,N'We Bare Bears Short','...',50,2,1) 
INSERT INTO tblProduct VALUES (15,N'We Bare Short Blue','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/q/u/quan-dai-ss-bibos-xanh-1.jpg',40000,N'We Bare Short Blue','...',50,2,1) 
INSERT INTO tblProduct VALUES (16,N'Rabi Short','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/q/u/quan-dai-rabi-len-tam-133984-4_2.jpg',55000,N'Rabi Short','...',50,2,1) 
INSERT INTO tblProduct VALUES (17,N'Rabi Petit','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/q/u/quan-dai-rabi-petit-133934-5.jpg',65000,N'Rabi Petit','...',50,2,1) 
INSERT INTO tblProduct VALUES (18,N'Rabi Petit White','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/q/u/quan-dai-rabi-cm30-trang-133959.jpg',35000,N'Rabi Petit White','...',50,2,1) 
INSERT INTO tblProduct VALUES (19,N'Rapi Petit Blue Short','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/a/o/ao-ss-cg-dt-bibos-c30-in-tran-ke-xanh-avatar_copy_1.jpg',47000,N'Rapi Petit Blue Short','...',50,2,1) 
INSERT INTO tblProduct VALUES (20,N'Rapi Petit Pink Short','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/2/7/27-10-_2021.jpg',35000,N'Rapi Petit Pink Short','...',50,2,1) 
INSERT INTO tblProduct VALUES (21,N'Dile Bare Skirt','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/q/u/quan-dui-rabi-trang-133983.jpg',50000,N'Dile Bare Skirt','...',50,2,1) 
INSERT INTO tblProduct VALUES (22,N'Skirt Baby Boo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/1/2/129388c-16-10-2021-01-11.jpg',250000,N'Skirt Baby Boo','...',50,2,1)
INSERT INTO tblProduct VALUES (23,N'Skirt Baby Boo Green','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/1/2/129382c-16-10-2021-02.jpg',250000,N'Skirt Baby Boo Green','...',50,2,1)
INSERT INTO tblProduct VALUES (24,N'Rapi WhiteBlue Short','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/1/2/127125c.jpg',50000,N'Rapi WhiteBlue Short','...',50,2,1)

--2 Baby Balo
INSERT INTO tblProduct VALUES (25,N'Baby Hamburger Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-zoy-zoii-hamburger-0.jpg',699000,N'Baby Hamburger Balo','...',50,3,1) 
INSERT INTO tblProduct VALUES (26,N'Baby Matcha Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-matcha.jpg',699000,N'Baby Matcha Balo','...',50,3,1) 
INSERT INTO tblProduct VALUES (27,N'Baby ZoyZoy Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-ban-nguyet-hong-1.jpg',656000,N'Baby ZoyZoy Balo','...',50,3,1) 
INSERT INTO tblProduct VALUES (28,N'Baby Fork Pink Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-cao-hong.jpg',675000,N'Baby Fork Pink Balo','...',50,3,1) 
INSERT INTO tblProduct VALUES (29,N'Baby Tiger Yellow Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-ho-vang.jpg',665000,N'Baby Tiger Yellow Balo','...',50,3,1) 
INSERT INTO tblProduct VALUES (30,N'Baby Umbrella Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-ban-nguyet.jpg',635000,N'Baby Umbrella Balo','...',50,3,1) 
INSERT INTO tblProduct VALUES (31,N'Baby Bear Brown Balo','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/b/a/ba-lo-su-tu-nau_1.jpg',695000,N'Baby Bear Brown Balo','...',50,3,1) 


--Baby Shoes
INSERT INTO tblProduct VALUES (32,N'Baby Brown Shoes','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/g/i/giay-long-gau-nau-2.jpg',130000,N'Baby Brown Shoes','...',50,4,1)
INSERT INTO tblProduct VALUES (33,N'Baby Shoes','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/g/i/giay-long-cun-nau.jpg',130000,N'Baby Shoes','...',50,4,1)
INSERT INTO tblProduct VALUES (34,N'Baby Shoes Pink','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/d/e/dep-long-gau-hong-3.jpg',130000,N'Baby Shoes Pink','...',50,4,1)
INSERT INTO tblProduct VALUES (35,N'Baby Rabit Shoes','https://media.bibomart.com.vn/resize.380x-/media/catalog/product/d/e/dep-rabit-hong.jpg',119000,N'Baby Rabit Shoes','...',50,4,1)

INSERT INTO tblRole VALUES ('AD','Admin') 
INSERT INTO tblRole VALUES ('US','User') 
INSERT INTO tblRole VALUES ('SEL','Seller') 

INSERT INTO tblAccount VALUES ('A01','admin','1',N'Tôi Là AdMin', 'AD',1)
INSERT INTO tblAccount VALUES ('A02','admin123','1',N'Tôi Là AdMin 2', 'AD',1)
INSERT INTO tblAccount VALUES ('A03','admin456','1',N'Tôi Là AdMin 3', 'AD',1)
INSERT INTO tblAccount VALUES ('A04','admin789','1',N'Tôi Là AdMin 4', 'AD',1)


INSERT INTO tblAccount VALUES ('S01','seller1','1',N'Dang Hoang Viet', 'SEL',1)
INSERT INTO tblAccount VALUES ('S02','seller2','1',N'Hoang Anh Khoa', 'SEL',1)
INSERT INTO tblAccount VALUES ('S03','seller3','1',N'Đoan Gia Bao', 'SEL',1)
INSERT INTO tblAccount VALUES ('S04','seller4','1',N'Nguyen Quoc Huy Chuong', 'SEL',1)


INSERT INTO tblAccount VALUES ('U01','user1','1',N'Trang Quoc Đat', 'US',1)
INSERT INTO tblAccount VALUES ('U02','user2','1',N'Tran Nguyen Đat Phu', 'US',1)
INSERT INTO tblAccount VALUES ('U03','user3','1',N'Phung Nguyen Han', 'US',1)
INSERT INTO tblAccount VALUES ('U04','user4','1',N'Tran Nhat Minh', 'US',1)
INSERT INTO tblAccount VALUES ('U05','user5','1',N'Truong Nhat Tuyen', 'US',1)



SELECT * FROM tblProduct
SELECT * FROM tblCategory
SELECT * FROM tblRole
SELECT * FROM tblAccount
SELECT * FROM tblOrder 
SELECT * FROM tblOrderDetail
SELECT top 1 orderID FROM tblOrder 
order by orderID desc
SELECT orderID, rID, total, order_Date FROM tblOrder
