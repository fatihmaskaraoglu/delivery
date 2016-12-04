USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[Cost]    Script Date: 4.12.2016 22:48:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Cost](
	[CostId] [int] NOT NULL,
	[Distance] [float] NOT NULL,
	[AddressId1] [int] NOT NULL,
	[AddressId2] [int] NOT NULL,
 CONSTRAINT [PK_Cost] PRIMARY KEY CLUSTERED 
(
	[CostId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Cost]  WITH CHECK ADD  CONSTRAINT [FK_Cost_Address] FOREIGN KEY([AddressId1])
REFERENCES [dbo].[Address] ([AddressId])
GO

ALTER TABLE [dbo].[Cost] CHECK CONSTRAINT [FK_Cost_Address]
GO

ALTER TABLE [dbo].[Cost]  WITH CHECK ADD  CONSTRAINT [FK_Cost_Address1] FOREIGN KEY([AddressId2])
REFERENCES [dbo].[Address] ([AddressId])
GO

ALTER TABLE [dbo].[Cost] CHECK CONSTRAINT [FK_Cost_Address1]
GO


