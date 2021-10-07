FROM julitom1/connectiondb



RUN mkdir keystores

WORKDIR /usrapp/bin/keystores

ENV var1 RUN echo localhost

RUN keytool -genkeypair -alias ecikeypair -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore ecikeystore.p12 -validity 3650 -storepass 123456 -dname "CN=${var1}, OU=AREP, O=ECI, L=Mosquera, S=Cundi, C=co"

RUN keytool -export -keystore ./ecikeystore.p12 -storepass 123456 -alias ecikeypair -file ecicert.cer

RUN keytool -import -file ./ecicert.cer  -storepass 123456 -alias firstCA -keystore myTrustStore -noprompt

WORKDIR /usrapp/bin
