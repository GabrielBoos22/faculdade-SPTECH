plot(base.r.wege.fulll$Open, base.r.wege.full$Close)

modelo <- lm(base.r.wege.full$Open~base.r.wege.full$Close)
summary(modelo)


par(mfrow=c(2,2))
plot(modelo, which = 1:4)

