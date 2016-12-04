USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[Order_DeliveryMan]    Script Date: 4.12.2016 22:49:20 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Order_DeliveryMan](
	[Order_DeliveryManId] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
	[DeliveryManId] [int] NOT NULL,
 CONSTRAINT [PK_Order_DeliveryMan] PRIMARY KEY CLUSTERED 
(
	[Order_DeliveryManId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Order_DeliveryMan]  WITH CHECK ADD  CONSTRAINT [FK_Order_DeliveryMan_DeliveryMan] FOREIGN KEY([DeliveryManId])
REFERENCES [dbo].[DeliveryMan] ([DeliveryManId])
GO

ALTER TABLE [dbo].[Order_DeliveryMan] CHECK CONSTRAINT [FK_Order_DeliveryMan_DeliveryMan]
GO

ALTER TABLE [dbo].[Order_DeliveryMan]  WITH CHECK ADD  CONSTRAINT [FK_Order_DeliveryMan_Order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([OrderId])
GO

ALTER TABLE [dbo].[Order_DeliveryMan] CHECK CONSTRAINT [FK_Order_DeliveryMan_Order]
GO


