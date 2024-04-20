CREATE TABLE [dbo].[SensitiveWords] (
    [Word] NVARCHAR (50) NULL,
    [ID]   INT           IDENTITY (1, 1) NOT NULL,
    CONSTRAINT [PK_SensitiveWords] PRIMARY KEY CLUSTERED ([ID] ASC)
);


GO

