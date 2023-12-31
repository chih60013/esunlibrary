USE [master]
GO
/****** Object:  Database [esun]    Script Date: 2023/8/13 下午 09:53:22 ******/
CREATE DATABASE [esun]

GO
ALTER DATABASE [esun] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [esun] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [esun] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [esun] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [esun] SET ARITHABORT OFF 
GO
ALTER DATABASE [esun] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [esun] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [esun] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [esun] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [esun] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [esun] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [esun] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [esun] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [esun] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [esun] SET  DISABLE_BROKER 
GO
ALTER DATABASE [esun] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [esun] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [esun] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [esun] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [esun] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [esun] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [esun] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [esun] SET RECOVERY FULL 
GO
ALTER DATABASE [esun] SET  MULTI_USER 
GO
ALTER DATABASE [esun] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [esun] SET DB_CHAINING OFF 
GO
ALTER DATABASE [esun] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [esun] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [esun] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [esun] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'esun', N'ON'
GO
ALTER DATABASE [esun] SET QUERY_STORE = OFF
GO
USE [esun]
GO
/****** Object:  Table [dbo].[book]    Script Date: 2023/8/13 下午 09:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[book_ISBN] [varchar](255) NOT NULL,
	[book_Author] [varchar](255) NOT NULL,
	[book_Introduction] [varchar](255) NULL,
	[book_Name] [varchar](255) NOT NULL,
	[fk_bookStatusId] [int] NULL,
	[fk_bookInventoryId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[book_ISBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bookInventory]    Script Date: 2023/8/13 下午 09:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bookInventory](
	[book_InventoryId] [int] IDENTITY(1,1) NOT NULL,
	[book_PurchaseDate] [datetime] NULL,
	[fk_bookISBN] [varchar](255) NOT NULL,
	[fk_bookStatusId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_InventoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[bookStatus]    Script Date: 2023/8/13 下午 09:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[bookStatus](
	[book_StatusId] [int] IDENTITY(1,1) NOT NULL,
	[book_StatusDesc] [nvarchar](200) NOT NULL,
	[book_StatusName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[book_StatusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[member]    Script Date: 2023/8/13 下午 09:53:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[member](
	[member_Id] [int] IDENTITY(1,1) NOT NULL,
	[member_LastLoginTime] [datetime] NULL,
	[member_Name] [nvarchar](30) NOT NULL,
	[member_Password] [nvarchar](20) NOT NULL,
	[member_PhoneNumber] [varchar](255) NOT NULL,
	[member_RegistrationTime] [datetime] NULL,
	[member_Token] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[member_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UK_og6u767xu2s0nmu4ikof9njfi] UNIQUE NONCLUSTERED 
(
	[member_PhoneNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FKmm5oublakaawtyvo5d16c5bew] FOREIGN KEY([fk_bookStatusId])
REFERENCES [dbo].[bookStatus] ([book_StatusId])
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FKmm5oublakaawtyvo5d16c5bew]
GO
ALTER TABLE [dbo].[book]  WITH CHECK ADD  CONSTRAINT [FKtj11kon9rvrt0ts7jlha23cpl] FOREIGN KEY([fk_bookInventoryId])
REFERENCES [dbo].[bookInventory] ([book_InventoryId])
GO
ALTER TABLE [dbo].[book] CHECK CONSTRAINT [FKtj11kon9rvrt0ts7jlha23cpl]
GO
ALTER TABLE [dbo].[bookInventory]  WITH CHECK ADD  CONSTRAINT [FKgmml2m3jmfmrk2vb8bv0me00w] FOREIGN KEY([fk_bookStatusId])
REFERENCES [dbo].[bookStatus] ([book_StatusId])
GO
ALTER TABLE [dbo].[bookInventory] CHECK CONSTRAINT [FKgmml2m3jmfmrk2vb8bv0me00w]
GO
ALTER TABLE [dbo].[bookInventory]  WITH CHECK ADD  CONSTRAINT [FKo00pxd4m6kkouqkh5doaxfg6t] FOREIGN KEY([fk_bookISBN])
REFERENCES [dbo].[book] ([book_ISBN])
GO
ALTER TABLE [dbo].[bookInventory] CHECK CONSTRAINT [FKo00pxd4m6kkouqkh5doaxfg6t]
GO
USE [master]
GO
ALTER DATABASE [esun] SET  READ_WRITE 
GO
