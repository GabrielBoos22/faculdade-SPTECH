
#FILME 6 STARWARS -----------------------------------------------------------------------------------
# Word Cloud personagens
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/again/Downloads/starWars6.txt", sep="")
personagens <- starWars6$personagem
docs <- Corpus(VectorSource(personagens))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","cetax",
                                    "ver","ser"))

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))
wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#Word cloud diálogo
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/again/Downloads/starWars6.txt", sep="")
dialogo <- starWars6$diálogo
docs <- Corpus(VectorSource(dialogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#subset personagens luke, han e threepio

#HAN
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/again/Downloads/starWars6.txt", sep="")
han <- subset(starWars6, starWars6$personagem == "HAN")
docs <- Corpus(VectorSource(han$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#luke
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/again/Downloads/starWars6.txt", sep="")
luke <- subset(starWars6, starWars6$personagem == "LUKE")
docs <- Corpus(VectorSource(luke$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#threepio
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/again/Downloads/starWars6.txt", sep="")
threepio <- subset(starWars6, starWars6$personagem == "THREEPIO")
docs <- Corpus(VectorSource(threepio$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)


#FILME 4 STARWARS ----------------------------------------------------------------------------------------
# Word Cloud personagens
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
personagens <- starWars4$personagem
docs <- Corpus(VectorSource(personagens))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","cetax",
                                    "ver","ser"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#Word cloud diálogo
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
dialogo <- starWars4$diálogo
docs <- Corpus(VectorSource(dialogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "pode", "tão", "lá", "ter"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)



wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#subset personagens luke, han e threepio

#HAN
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
han <- subset(starWars4, starWars4$personagem == "HAN")
docs <- Corpus(VectorSource(han$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "aí", "então", "vamos", "lá"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#luke
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
luke <- subset(starWars4, starWars4$personagem == "LUKE")
docs <- Corpus(VectorSource(luke$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "aí", "então"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#threepio
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
threepio <- subset(starWars4, starWars4$personagem == "THREEPIO")
docs <- Corpus(VectorSource(threepio$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#BEN
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
ben <- subset(starWars4, starWars4$personagem == "BEN")
docs <- Corpus(VectorSource(ben$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)
#LEIA

library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars4 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeIV_ptBR.txt", sep="")
leia <- subset(starWars4, starWars4$personagem == "LEIA")
docs <- Corpus(VectorSource(leia$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "aí", "lá"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#FILME 5
# Word Cloud personagens
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
personagens <- starWars5$personagem
docs <- Corpus(VectorSource(personagens))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","cetax",
                                    "ver","ser"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#Word cloud diálogo
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
dialogo <- starWars5$diálogo
docs <- Corpus(VectorSource(dialogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "pode", "tão", "lá", "ter", "vai", "vou", "acho","vamos","sabe","nada","vai","algo","vou"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)



wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#subset personagens luke, han e threepio

#HAN
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
han <- subset(starWars5, starWars5$personagem == "HAN")
docs <- Corpus(VectorSource(han$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "aí", "então", "vamos", "lá", "vai", "acho", "tudo"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#luke
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
luke <- subset(starWars5, starWars5$personagem == "LUKE")
docs <- Corpus(VectorSource(luke$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "aí", "então"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#threepio
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
threepio <- subset(starWars5, starWars5$personagem == "THREEPIO")
docs <- Corpus(VectorSource(threepio$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#LANDO
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
ben <- subset(starWars5, starWars5$personagem == "LANDO")
docs <- Corpus(VectorSource(ben$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "tudo"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)
#LEIA

library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars5 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeV_ptBR.txt", sep="")
leia <- subset(starWars5, starWars5$personagem == "LEIA")
docs <- Corpus(VectorSource(leia$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "aí", "lá", "quê", "então","achei"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)#

#FILME 6 ------------------------------------------------------------------------------------------------------
# Word Cloud personagens
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
personagens <- starWars6$personagem
docs <- Corpus(VectorSource(personagens))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","cetax",
                                    "ver","ser"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)

wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#Word cloud diálogo
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
dialogo <- starWars6$diálogo
docs <- Corpus(VectorSource(dialogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "pode", "tão", "lá", "ter", "vai", "vou", "acho","vamos","sabe","nada","vai","algo","vou", "tudo","então"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)



wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#subset personagens luke, han e threepio

#HAN
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
han <- subset(starWars6, starWars5$personagem == "HAN")
docs <- Corpus(VectorSource(han$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "aí", "então", "vamos", "lá", "vai", "acho", "tudo"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#luke
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
luke <- subset(starWars6, starWars6$personagem == "LUKE")
docs <- Corpus(VectorSource(luke$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "bem", "aí", "então"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#threepio
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
threepio <- subset(starWars6, starWars6$personagem == "THREEPIO")
docs <- Corpus(VectorSource(threepio$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)

#VADER
library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
vader <- subset(starWars5, starWars5$personagem == "VADER")
docs <- Corpus(VectorSource(vader$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "tudo"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)
#LEIA

library(tm)
library(wordcloud)
library(RColorBrewer)
library(wordcloud2)
starWars6 <- read.csv("C:/Users/Vayon24/Desktop/sptech/2-sem-SPTech/Calculo Computacional/Aula17/SW_EpisodeVI_ptBR.txt", sep="")
leia <- subset(starWars6, starWars6$personagem == "LEIA")
docs <- Corpus(VectorSource(leia$diálogo))
docs <- tm_map(docs, tolower)
docs <- tm_map(docs, removePunctuation)
docs <- tm_map(docs, removeWords, stopwords("pt"))
docs <- tm_map(docs, removeNumbers)
docs <- tm_map(docs, stripWhitespace)
docs <- tm_map(docs, removeWords, c("mim","deve","posso",
                                    "aqui","sim","bom","coisa","parte",
                                    "todas","per","etc","abaixo","outros",
                                    "pode","aqui","pode",
                                    "ver","ser", "sei", "aí", "lá", "quê", "então","achei", "vamos", "vai"))
dtm <- TermDocumentMatrix(docs)
matrix <- as.matrix(dtm)
words <- sort(rowSums(matrix), decreasing = TRUE)
df <- data.frame(word=names(words), freq=words)


wordcloud(words=df$word, freq=df$freq, min.freq=1,
          max.words=50, random.order=FALSE, rot.per=0.35,
          colors=brewer.pal(8, "Dark2"), scale=c(2,1))

wordcloud2(data=df, size=0.7, color="random-light", backgroundColor="black",
           minRotation=-pi/6, maxRotation=-pi/6, rotateRatio=0)