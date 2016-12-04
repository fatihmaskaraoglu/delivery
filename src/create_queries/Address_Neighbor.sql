USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[Address_Neighbor]    Script Date: 4.12.2016 22:48:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Address_Neighbor](
	[Address_NeighborId] [int] NOT NULL,
	[AddressId1] [int] NOT NULL,
	[AddressId2] [int] NOT NULL,
 CONSTRAINT [PK_Address_Neighbor] PRIMARY KEY CLUSTERED 
(
	[Address_NeighborId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[Address_Neighbor]  WITH CHECK ADD  CONSTRAINT [FK_Address_Neighbor_Address] FOREIGN KEY([AddressId1])
REFERENCES [dbo].[Address] ([AddressId])
GO

ALTER TABLE [dbo].[Address_Neighbor] CHECK CONSTRAINT [FK_Address_Neighbor_Address]
GO

ALTER TABLE [dbo].[Address_Neighbor]  WITH CHECK ADD  CONSTRAINT [FK_Address_Neighbor_Address1] FOREIGN KEY([AddressId2])
REFERENCES [dbo].[Address] ([AddressId])
GO

ALTER TABLE [dbo].[Address_Neighbor] CHECK CONSTRAINT [FK_Address_Neighbor_Address1]
GO


