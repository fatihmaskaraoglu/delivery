USE [LivraisondePizza]
GO

/****** Object:  Table [dbo].[Street]    Script Date: 4.12.2016 22:49:50 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Street](
	[StreetId] [int] NOT NULL,
	[StreetName] [nvarchar](50) NULL,
	[x1] [float] NOT NULL,
	[y1] [float] NOT NULL,
	[x2] [float] NOT NULL,
	[y2] [float] NOT NULL,
 CONSTRAINT [PK_Street] PRIMARY KEY CLUSTERED 
(
	[StreetId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


