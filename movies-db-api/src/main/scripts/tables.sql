CREATE TABLE [dbo].[movie]
(
  [id] [bigint] PRIMARY KEY IDENTITY(1,1) NOT NULL,
  [backdrop_path] [varchar](255) NOT NULL,
  [overview] [varchar](255) NOT NULL,
  [popularity] [float] NOT NULL,
  [poster_path] [varchar](255) NOT NULL,
  [rating] [float] NOT NULL,
  [release_date] [datetime2](6) NOT NULL,
  [title] [varchar](255) NOT NULL
)
GO

CREATE TABLE [dbo].[genre]
(
	[id] [bigint] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL
)
GO

CREATE TABLE [dbo].[creator]
(
	[id] [bigint] PRIMARY KEY IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL
)
GO

-- Create movie creators table
CREATE TABLE [dbo].[movie_creators]
(
  [movie_id] [bigint] NOT NULL,
  [creator_id] [bigint] NOT NULL
)
GO

ALTER TABLE [dbo].[movie_creators] ADD PRIMARY KEY CLUSTERED
(
	[movie_id] ASC,
	[creator_id] ASC
)
GO

ALTER TABLE [dbo].[movie_creators] WITH CHECK ADD CONSTRAINT [movie_creator_movie_id] FOREIGN KEY([movie_id])
REFERENCES [dbo].[movie] ([id])
GO

ALTER TABLE [dbo].[movie_creators] WITH CHECK ADD CONSTRAINT [movie_creator_creator_id] FOREIGN KEY([creator_id])
REFERENCES [dbo].[creator] ([id])
GO

-- Create movie genres table
CREATE TABLE [dbo].[movie_genres]
(
  [movie_id] [bigint] NOT NULL,
  [genre_id] [bigint] NOT NULL
)
GO

ALTER TABLE [dbo].[movie_genres] ADD PRIMARY KEY CLUSTERED
(
	[movie_id] ASC,
	[genre_id] ASC
)
GO

ALTER TABLE [dbo].[movie_genres]  WITH CHECK ADD  CONSTRAINT [movie_genres_genre_id] FOREIGN KEY([genre_id])
REFERENCES [dbo].[genre] ([id])
GO

ALTER TABLE [dbo].[movie_genres]  WITH CHECK ADD  CONSTRAINT [movie_genres_movie_id] FOREIGN KEY([movie_id])
REFERENCES [dbo].[movie] ([id])
GO