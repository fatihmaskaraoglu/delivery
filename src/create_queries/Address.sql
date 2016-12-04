USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[Address]    Script Date: 4.12.2016 22:47:22 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Address](
	[AddressId] [int] NOT NULL,
	[StreetId] [int] NOT NULL,
	[Number] [int] NOT NULL,
	[x] [float] NOT NULL,
	[y] [float] NOT NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[AddressId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [FK_Address_Street] FOREIGN KEY([StreetId])
REFERENCES [dbo].[Street] ([StreetId])
GO

ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [FK_Address_Street]
GO


