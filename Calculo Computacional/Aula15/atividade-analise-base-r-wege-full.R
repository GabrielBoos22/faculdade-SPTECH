par(mfrow = c(3, 2))  

plot(base.r.wege.full$Open, base.r.wege.full$Close, main = "Open vs Close")
plot(base.r.wege.full$Open, base.r.wege.full$High, main = "Open vs High")
plot(base.r.wege.full$Open, base.r.wege.full$Low, main = "Open vs Low")
plot(base.r.wege.full$High, base.r.wege.full$Low, main = "High vs Low")
plot(base.r.wege.full$High, base.r.wege.full$Close, main = "High vs Close")
plot(base.r.wege.full$High, base.r.wege.full$Open, main = "High vs Open")

plot(base.r.wege.full$Open, base.r.wege.full$High, main = "Open vs High")

modelo <- lm(base.r.wege.full$Open~base.r.wege.full$Close)
summary(modelo)


par(mfrow=c(2,2))
plot(modelo, which = 1:4)


