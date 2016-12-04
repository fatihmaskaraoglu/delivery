USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[Restaurant]    Script Date: 4.12.2016 22:49:35 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Restaurant](
	[RestaurantId] [int] NOT NULL,
	[ListOfOrders] [int] NULL,
	[AddressId] [int] NOT NULL,
	[NumberOfAvailableDeliveryMan] [int] NOT NULL,
 CONSTRAINT [PK_Restaurant] PRIMARY KEY CLUSTERED 
(
	[RestaurantId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Restaurant]  WITH CHECK ADD  CONSTRAINT [FK_Restaurant_Address] FOREIGN KEY([ListOfOrders])
REFERENCES [dbo].[Address] ([AddressId])
GO

ALTER TABLE [dbo].[Restaurant] CHECK CONSTRAINT [FK_Restaurant_Address]
GO


