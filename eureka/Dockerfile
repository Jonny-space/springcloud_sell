FROM java:8
EXPOSE 33560
VOLUME /tmp
ADD /target/eureka-server.jar eureka-server.jar
RUN bash -c 'touch /eureka-server.jar'
RUN /sbin/ip route|awk '/default/ { print  $3,"\tdockerhost" }' >> /etc/hosts
ENTRYPOINT ["java","-jar","/eureka-server.jar"]