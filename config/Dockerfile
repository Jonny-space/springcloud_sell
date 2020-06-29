FROM java:8
EXPOSE 33561
VOLUME /tmp
ADD /target/config-server.jar config-server.jar
RUN bash -c 'touch /config-server.jar'
RUN /sbin/ip route|awk '/default/ { print  $3,"\tdockerhost" }' >> /etc/hosts
ENTRYPOINT ["java","-jar","/config-server.jar"]