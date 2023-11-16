par(mfrow = c(3, 2))  

plot(base.r.wege.full$Open, base.r.wege.full$Close, main = "Open vs Close", type = "l")
plot(base.r.wege.full$Open, base.r.wege.full$High, main = "Open vs High", type = "l")
plot(base.r.wege.full$Open, base.r.wege.full$Low, main = "Open vs Low", type = "l")
plot(base.r.wege.full$High, base.r.wege.full$Low, main = "High vs Low", type = "l")
plot(base.r.wege.full$High, base.r.wege.full$Close, main = "High vs Close", type = "l")
plot(base.r.wege.full$High, base.r.wege.full$Open, main = "High vs Open", type = "l")

modelo <- lm(base.r.wege.full$Open~base.r.wege.full$Close)
summary(modelo)


par(mfrow=c(2,2))
plot(modelo, which = 1:4)


