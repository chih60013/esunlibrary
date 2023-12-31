USE [esun]
GO
INSERT [dbo].[book] ([book_ISBN], [book_Author], [book_Introduction], [book_Name], [fk_bookStatusId], [fk_bookInventoryId]) VALUES (N'123456', N'Robert C. Martin', N'cleancode', N'cleancode', NULL, NULL)
INSERT [dbo].[book] ([book_ISBN], [book_Author], [book_Introduction], [book_Name], [fk_bookStatusId], [fk_bookInventoryId]) VALUES (N'654321', N'Kathy Sierra', N'深入淺出 Java', N'深入淺出 Java 程式設計 第二版', NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[bookInventory] ON 

INSERT [dbo].[bookInventory] ([book_InventoryId], [book_PurchaseDate], [fk_bookISBN], [fk_bookStatusId]) VALUES (1, CAST(N'2023-08-12T12:52:00.000' AS DateTime), N'123456 ', 4)
INSERT [dbo].[bookInventory] ([book_InventoryId], [book_PurchaseDate], [fk_bookISBN], [fk_bookStatusId]) VALUES (2, CAST(N'2023-08-01T16:45:00.000' AS DateTime), N'654321 ', 2)
SET IDENTITY_INSERT [dbo].[bookInventory] OFF
GO
SET IDENTITY_INSERT [dbo].[bookStatus] ON 

INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (1, N'借閱中', N'借閱中')
INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (2, N'在庫', N'在庫')
INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (3, N'歸還後未入庫', N'整理中')
INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (4, N'遺失', N'遺失')
INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (5, N'損毀', N'損毀')
INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (6, N'廢棄', N'廢棄')
INSERT [dbo].[bookStatus] ([book_StatusId], [book_StatusDesc], [book_StatusName]) VALUES (7, N'跨館', N'跨館轉移中')
SET IDENTITY_INSERT [dbo].[bookStatus] OFF
GO
SET IDENTITY_INSERT [dbo].[member] ON 

INSERT [dbo].[member] ([member_Id], [member_LastLoginTime], [member_Name], [member_Password], [member_PhoneNumber], [member_RegistrationTime], [member_Token]) VALUES (1, CAST(N'2023-08-13T20:00:15.297' AS DateTime), N'jeff', N'123456', N'0912345678', CAST(N'2023-08-12T15:44:55.760' AS DateTime), NULL)
INSERT [dbo].[member] ([member_Id], [member_LastLoginTime], [member_Name], [member_Password], [member_PhoneNumber], [member_RegistrationTime], [member_Token]) VALUES (2, CAST(N'2023-08-12T15:52:01.767' AS DateTime), N'丁丁', N'778899', N'0912332132', CAST(N'2023-08-12T15:52:01.767' AS DateTime), NULL)
INSERT [dbo].[member] ([member_Id], [member_LastLoginTime], [member_Name], [member_Password], [member_PhoneNumber], [member_RegistrationTime], [member_Token]) VALUES (4, CAST(N'2023-08-13T16:20:45.860' AS DateTime), N'tom', N'123456', N'0977665544', CAST(N'2023-08-13T16:20:45.860' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[member] OFF
GO
