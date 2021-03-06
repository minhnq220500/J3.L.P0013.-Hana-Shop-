USE [Hana_Shop]
GO
ALTER TABLE [dbo].[tblUser] DROP CONSTRAINT [FK__tblUser__roleID__4F7CD00D]
GO
ALTER TABLE [dbo].[tblProductHistory] DROP CONSTRAINT [FK__tblProduc__userI__412EB0B6]
GO
ALTER TABLE [dbo].[tblProductHistory] DROP CONSTRAINT [FK__tblProduc__produ__4D94879B]
GO
ALTER TABLE [dbo].[tblProduct] DROP CONSTRAINT [FK__tblProduc__categ__4CA06362]
GO
ALTER TABLE [dbo].[tblOrderDetail] DROP CONSTRAINT [FK__tblOrderD__produ__4BAC3F29]
GO
ALTER TABLE [dbo].[tblOrderDetail] DROP CONSTRAINT [FK__tblOrderD__produ__3E52440B]
GO
ALTER TABLE [dbo].[tblOrderDetail] DROP CONSTRAINT [FK__tblOrderD__order__4AB81AF0]
GO
ALTER TABLE [dbo].[tblOrder] DROP CONSTRAINT [FK__tblOrder__userID__49C3F6B7]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblUser]
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblRole]
GO
/****** Object:  Table [dbo].[tblProductHistory]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblProductHistory]
GO
/****** Object:  Table [dbo].[tblProduct]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblProduct]
GO
/****** Object:  Table [dbo].[tblOrderDetail]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblOrderDetail]
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblOrder]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 4/10/2021 3:40:01 PM ******/
DROP TABLE [dbo].[tblCategory]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [nvarchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [nvarchar](100) NOT NULL,
	[userID] [nvarchar](10) NULL,
	[orderDate] [datetime] NULL,
	[totalPrice] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblOrderDetail]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderDetail](
	[detailID] [nvarchar](100) NOT NULL,
	[orderID] [nvarchar](100) NULL,
	[productID] [nvarchar](10) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblProduct]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProduct](
	[productID] [nvarchar](10) NOT NULL,
	[productName] [nvarchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[status] [bit] NULL,
	[image] [nvarchar](max) NULL,
	[description] [nvarchar](500) NULL,
	[createDate] [date] NULL,
	[counter] [int] NULL,
	[categoryID] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblProductHistory]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProductHistory](
	[historyID] [int] IDENTITY(1,1) NOT NULL,
	[type] [nvarchar](10) NULL,
	[recordTime] [datetime] NULL,
	[productID] [nvarchar](10) NULL,
	[userID] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[historyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[roleID] [nvarchar](10) NOT NULL,
	[roleName] [nvarchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 4/10/2021 3:40:01 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[userID] [nvarchar](10) NOT NULL,
	[password] [nvarchar](50) NULL,
	[name] [nvarchar](50) NULL,
	[email] [nvarchar](100) NULL,
	[roleID] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'D', N'Drink')
INSERT [dbo].[tblCategory] ([categoryID], [categoryName]) VALUES (N'F', N'Food')
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-1', N'congtt', CAST(N'2021-01-23 20:16:17.653' AS DateTime), 40000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-10', N'congtt', CAST(N'2021-03-04 09:49:24.340' AS DateTime), 1250000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-11', N'congtt', CAST(N'2021-03-04 09:58:44.677' AS DateTime), 2705000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-2', N'congtt', CAST(N'2021-01-24 15:56:17.137' AS DateTime), 100000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-3', N'congtt', CAST(N'2021-01-24 15:56:33.833' AS DateTime), 70000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-4', N'congtt', CAST(N'2021-01-27 20:24:36.287' AS DateTime), 90000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-5', N'congtt', CAST(N'2021-02-08 22:10:06.407' AS DateTime), 40000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-6', N'congtt', CAST(N'2021-03-04 08:32:13.647' AS DateTime), 150000000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-7', N'congtt', CAST(N'2021-03-04 08:49:00.163' AS DateTime), 50000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-8', N'congtt', CAST(N'2021-03-04 08:50:17.863' AS DateTime), 1075000)
INSERT [dbo].[tblOrder] ([orderID], [userID], [orderDate], [totalPrice]) VALUES (N'Ord-congtt-9', N'congtt', CAST(N'2021-03-04 09:38:14.937' AS DateTime), 45000)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-10-1', N'Ord-congtt-10', N'P003', 25000, 50)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-1-1', N'Ord-congtt-1', N'P003', 25000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-11-1', N'Ord-congtt-11', N'P003', 25000, 50)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-11-2', N'Ord-congtt-11', N'P002', 15000, 97)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-1-2', N'Ord-congtt-1', N'P002', 15000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-2-1', N'Ord-congtt-2', N'P003', 25000, 4)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-3-1', N'Ord-congtt-3', N'P005', 30000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-3-2', N'Ord-congtt-3', N'P006', 25000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-3-3', N'Ord-congtt-3', N'P002', 15000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-4-1', N'Ord-congtt-4', N'P005', 30000, 2)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-4-2', N'Ord-congtt-4', N'P002', 15000, 2)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-5-1', N'Ord-congtt-5', N'P003', 25000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-5-2', N'Ord-congtt-5', N'P002', 15000, 1)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-6-1', N'Ord-congtt-6', N'P002', 15000, 10000)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-7-1', N'Ord-congtt-7', N'P003', 25000, 2)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-8-1', N'Ord-congtt-8', N'P003', 25000, 43)
INSERT [dbo].[tblOrderDetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (N'Ord-congtt-9-1', N'Ord-congtt-9', N'P002', 15000, 3)
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P001', N'Banh cuon', 20000, 100, 1, N'https://songkhoe.medplus.vn/wp-content/uploads/2020/03/banh-cuon-cach-lam-1.png', N'Rất ngon', CAST(N'2000-05-22' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P002', N'Banh uot', 15000, 0, 1, N'https://image.thanhnien.vn/1080/uploaded/2014/saigonamthuc.thanhnien.com.vn/pictures20135/tan_nhan/banh_cuon_3_thang_2_tb_02.jpg', N'Ngon', CAST(N'2000-01-01' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P003', N'Hu tieu', 25000, 0, 1, N'https://media.cooky.vn/recipe/g1/1552/s640/recipe1552-635684240661925692.jpg', N'Ngonn', CAST(N'2000-02-02' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P004', N'Pho', 30000, 50, 1, N'https://upload.wikimedia.org/wikipedia/commons/5/53/Pho-Beef-Noodles-2008.jpg', N'Ngon', CAST(N'2000-03-03' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P005', N'Bun bo', 30000, 47, 1, N'https://i.ytimg.com/vi/OSGiO2lMkis/maxresdefault.jpg', N'Ngon', CAST(N'2000-04-04' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P006', N'Bun rieu', 25000, 49, 1, N'https://cdn.tgdd.vn/2020/11/CookRecipe/Avatar/bun-rieu-cua-dong-thumbnail.jpg', N'Ngon', CAST(N'2000-05-05' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P007', N'Canh bun', 25000, 50, 1, N'https://vcdn-dulich.vnecdn.net/2016/12/07/1-canh-bun-6351-1481087571.jpg', N'Ngon', CAST(N'2000-06-06' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P008', N'Banh bao', 15000, 50, 1, N'https://thucthan.com/media/2018/04/cach-lam-banh-bao/banh-bao.jpg', N'Ngon', CAST(N'2000-07-07' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P009', N'Banh bao chien', 5000, 50, 1, N'https://cdn.tgdd.vn/Files/2020/03/05/1240300/cach-lam-banh-bao-chien-gion-thom-ngon-dai-khach.jpg', N'Ngon', CAST(N'2000-08-08' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P010', N'Banh gio', 10000, 50, 1, N'https://ngonaz.com/wp-content/uploads/2020/08/banh-gio.jpg', N'Ngon', CAST(N'2000-09-09' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P011', N'Chao long', 20000, 50, 1, N'https://cdn.tgdd.vn/2020/06/CookProduct/Untitled-2-1200x676.jpg', N'Ngon', CAST(N'2000-10-10' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P012', N'Banh nam', 15000, 50, 1, N'https://songhuongfood.com/wp-content/uploads/2018/07/banhnam1.jpeg', N'Ngon', CAST(N'2000-11-11' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P013', N'Banh bot loc', 3000, 50, 1, N'https://cdn.daylambanh.edu.vn/wp-content/uploads/2018/11/banh-bot-loc-goi-la-hap-dan-600x375.jpg', N'Ngon', CAST(N'2000-12-12' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P014', N'Lau mam', 200000, 50, 1, N'https://daubepgiadinh.vn/wp-content/uploads/2018/12/lau-mam-mien-tay-600x400.jpg', N'Tôm, thit ba chỉ, mực, bạch tuột, cá, nước dùng, cà tím, các loại rau', CAST(N'2020-01-01' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P015', N'Lau bo', 250000, 50, 1, N'https://www.chudu24.com/wp-content/uploads/2018/05/4-126.jpg', N'Các loại thịt trong con bò, nước dùng, các loại rau ăn kèm', CAST(N'2020-02-02' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P016', N'Lau thai', 150000, 50, 1, N'https://cdn.daotaobeptruong.vn/wp-content/uploads/2018/09/nau_lau_thao_tai_nha_de_dang-600x400.jpg', N'Ngon', CAST(N'2020-03-03' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P017', N'Lau cua dong', 150000, 50, 1, N'https://thucthan.com/media/2018/07/lau-cua-dong/cach-nau-lau-cua-dong.jpg', N'Ngon', CAST(N'2020-04-04' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P018', N'Lau bao tu', 150000, 50, 1, N'https://cdn.cet.edu.vn/wp-content/uploads/2019/05/bao-tu-ham-tieu-cay-nong.jpg', N'Ngon', CAST(N'2020-05-05' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P019', N'Mi hao hao', 3500, 100, 1, N'https://product.hstatic.net/1000148058/product/upload_8834d14b37b940569ca7e68fd9e37f2d.jpg', N'Nóng nhưng ngon', CAST(N'2020-06-06' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P020', N'Mi omachi', 5000, 100, 1, N'https://cdn.tgdd.vn/Products/Images/2565/77630/bhx/mi-khoai-tay-omachi-xot-bo-ham-goi-80g-201912081333568103.JPG', N'Ngon', CAST(N'2020-07-07' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P021', N'Bia Heniken', 20000, 50, 1, N'https://cdn.tgdd.vn/Products/Images/2282/83641/bhx/bia-heineken-330ml-201904250917293255.JPG', N'Mát', CAST(N'2020-08-08' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P022', N'Bia Tiger', 16000, 50, 1, N'https://product.hstatic.net/1000174127/product/bia-tiger-lon-01_83e4faa81a4a4789828001e8edf24ebe.jpg', N'Mát', CAST(N'2020-09-09' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P023', N'Strongbow', 16000, 50, 1, N'https://salt.tikicdn.com/cache/w1200/ts/product/e8/77/ab/bcfcf18b28c8a38dcc50f0b9dd3bc4f6.jpg                                           ', N'Mát', CAST(N'2020-10-10' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P024', N'Tra sua', 300000, 50, 1, N'https://dayphache.edu.vn/wp-content/uploads/2020/02/mon-tra-sua-tran-chau.jpg                                           ', N'Ngon', CAST(N'2020-11-11' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P025', N'Tra nhiet doi trai cay', 350000, 502, 1, N'https://sieuthinguyenlieu.com/assets/uploads/images/I0615bu8D0OY_tra-trai-cay-nhiet-doi.jpg                                                                                                                                                                                                                                                                                                                                                                                                                                              ', N'Ngonnn', CAST(N'2020-12-12' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P026', N'Matcha da xay', 350000, 50, 1, N'https://product.hstatic.net/1000304357/product/1_8c8a1120a1564fcbaa6dd386b9c047fe_1024x1024.jpg', N'Ngon', CAST(N'2018-01-01' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P027', N'Ca phe den', 12000, 50, 1, N'https://caphenguyenchat.vn/wp-content/uploads/2017/12/tac-dung-cua-ca-phe-sach-doi-voi-suc-khoe-con-nguoi.jpg', N'Đắng, ngon', CAST(N'2018-02-02' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P028', N'Ca phe sua', 15000, 50, 1, N'https://f5cafe.com/wp-content/uploads/2020/06/ca_phe_sua_da.jpg', N'Ngọt, ngon', CAST(N'2018-03-03' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P029', N'Sinh to', 20000, 50, 1, N'https://www.hoidaubepaau.com/wp-content/uploads/2015/12/sinh-to-dau.jpg', N'Ngonn', CAST(N'2018-04-04' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P030', N'Rau ma', 10000, 50, 1, N'https://bizweb.dktcdn.net/100/161/323/files/sinh-to-rau-ma-dau-xanh-ngon-e2b48159-2078-466f-bf3c-cca8f9a9e771.jpg?v=1510997017856', N'Ngon', CAST(N'2018-05-05' AS Date), 0, N'D')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P031', N'Bun moc', 25000, 50, 1, N'https://nghebep.com/wp-content/uploads/2018/08/bun-moc-gio-heo.png', N'Ngon', CAST(N'2018-06-06' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P032', N'Com hen ', 10000, 100, 1, N'https://lh3.googleusercontent.com/proxy/Bas0nbXUS7s7gFlMQNZwx-ZQbtkxmhiQ4obtb5JkihImH-UkoI2SjH4mbBJ8TI5zYFsrQHogomWeqT5NUxXJY3Wg83UM27IO7bsLxz6VIZyk7F6c8nIYxbQVwn2r4KJxX-7R', N'Ngonnn', CAST(N'2018-07-07' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P033', N'Com suon', 25000, 50, 1, N'https://cdn.beptruong.edu.vn/wp-content/uploads/2018/06/cach-uop-thit-nuong-com-tam.jpg', N'Ngon', CAST(N'2018-08-08' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P034', N'Mi quang', 25000, 50, 1, N'https://danang.huongnghiepaau.com/images/mon-ngon-mien-trung/mi-quang-ga.jpg', N'Ngon', CAST(N'2018-09-09' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P035', N'Nui', 25000, 50, 1, N'https://cdn.tgdd.vn/2020/10/CookProduct/nuixuongheothitvien-1200x676.jpg', N'Ngon', CAST(N'2018-10-10' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P036', N'Pha lau', 30000, 50, 1, N'https://click49.vn/wp-content/uploads/2020/05/5f23c7a5a4015e5f0710-1.jpg', N'Ngon', CAST(N'2018-11-11' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P037', N'Rau cau', 10000, 50, 1, N'https://thatlangon.com/wp-content/uploads/2020/04/rau-cau-4.jpg', N'Ngon', CAST(N'2018-12-12' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P038', N'Banh plan', 5000, 50, 1, N'https://ameovat.com/wp-content/uploads/2016/01/cach-lam-banh-flan.jpg', N'Ngon', CAST(N'2019-01-01' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P039', N'Trai cay dia', 25000, 50, 1, N'https://dulichvietnam.com.vn/vnt_upload/news/08_2019/trai_cay_7.jpg', N'Ngon', CAST(N'2019-02-02' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P040', N'Tra atiso', 25000, 50, 1, N'https://bazantravel.com/cdn/medias/uploads/28/28776-tra-atiso-670x446.jpg', N'Ngon', CAST(N'2019-03-03' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P041', N'Sua', 10000, 50, 1, N'data:image/jpeg;base64,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', N'Ngon', CAST(N'2019-04-04' AS Date), 0, N'F')
INSERT [dbo].[tblProduct] ([productID], [productName], [price], [quantity], [status], [image], [description], [createDate], [counter], [categoryID]) VALUES (N'P042', N'abc', 2000, 50, 1, N'aa', N'Ngon', CAST(N'2020-04-04' AS Date), 0, N'D')
SET IDENTITY_INSERT [dbo].[tblProductHistory] ON 

INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (1, N'Update', CAST(N'2021-01-23 20:16:53.163' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (2, N'Update', CAST(N'2021-01-23 23:51:35.453' AS DateTime), N'P002', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (3, N'Delete', CAST(N'2021-01-24 15:50:52.807' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (4, N'Delete', CAST(N'2021-01-24 16:16:27.957' AS DateTime), N'P024', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (5, N'Delete', CAST(N'2021-01-24 16:19:56.663' AS DateTime), N'P023', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (6, N'Delete', CAST(N'2021-01-24 16:24:03.880' AS DateTime), N'P023', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (7, N'Update', CAST(N'2021-01-24 16:32:10.200' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (8, N'Update', CAST(N'2021-01-24 16:32:14.107' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (9, N'Update', CAST(N'2021-01-24 16:32:20.677' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (10, N'Update', CAST(N'2021-01-24 16:33:42.473' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (11, N'Update', CAST(N'2021-01-24 16:37:45.917' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (12, N'Delete', CAST(N'2021-01-25 09:01:00.847' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (13, N'Delete', CAST(N'2021-01-25 09:01:00.853' AS DateTime), N'P024', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (14, N'Update', CAST(N'2021-01-25 09:01:43.290' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (15, N'Update', CAST(N'2021-01-25 09:02:11.023' AS DateTime), N'P024', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (16, N'Update', CAST(N'2021-01-27 20:27:14.887' AS DateTime), N'P023', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (17, N'Update', CAST(N'2021-02-24 19:01:26.323' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (18, N'Update', CAST(N'2021-02-24 19:01:34.370' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (19, N'Delete', CAST(N'2021-03-01 09:41:22.757' AS DateTime), N'P025', N'minhnq')
INSERT [dbo].[tblProductHistory] ([historyID], [type], [recordTime], [productID], [userID]) VALUES (20, N'Update', CAST(N'2021-03-01 09:43:27.957' AS DateTime), N'P025', N'minhnq')
SET IDENTITY_INSERT [dbo].[tblProductHistory] OFF
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[tblRole] ([roleID], [roleName]) VALUES (N'US', N'User')
INSERT [dbo].[tblUser] ([userID], [password], [name], [email], [roleID]) VALUES (N'congtt', N'2', N'Trần Thành Công', N'congtt@gmail.com', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [name], [email], [roleID]) VALUES (N'datdt', N'1', N'Đàm Tiến Đạt', N'datdt@fpt.edu.vn', N'US')
INSERT [dbo].[tblUser] ([userID], [password], [name], [email], [roleID]) VALUES (N'minhnq', N'2205', N'Nguyễn Quang Minh', N'minhnqse140536@fpt.edu.vn', N'AD')
ALTER TABLE [dbo].[tblOrder]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[tblUser] ([userID])
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD FOREIGN KEY([productID])
REFERENCES [dbo].[tblProduct] ([productID])
GO
ALTER TABLE [dbo].[tblOrderDetail]  WITH CHECK ADD FOREIGN KEY([productID])
REFERENCES [dbo].[tblProduct] ([productID])
GO
ALTER TABLE [dbo].[tblProduct]  WITH CHECK ADD FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblProductHistory]  WITH CHECK ADD FOREIGN KEY([productID])
REFERENCES [dbo].[tblProduct] ([productID])
GO
ALTER TABLE [dbo].[tblProductHistory]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[tblUser] ([userID])
GO
ALTER TABLE [dbo].[tblUser]  WITH CHECK ADD FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRole] ([roleID])
GO
