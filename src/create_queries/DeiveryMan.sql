USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[DeliveryMan]    Script Date: 4.12.2016 22:48:53 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[DeliveryMan](
	[DeliveryManId] [int] NOT NULL,
	[Available] [int] NOT NULL,
 CONSTRAINT [PK_DeliveryMan] PRIMARY KEY CLUSTERED 
(
	[DeliveryManId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


