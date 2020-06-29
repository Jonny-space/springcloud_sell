FROM java:8
EXPOSE 33563
VOLUME /tmp
ADD /target/admin-server.jar admin-server.jar
RUN bash -c 'touch /admin-server.jar'
RUN /sbin/ip route|awk '/default/ { print  $3,"\tdockerhost" }' >> /etc/hosts
ENTRYPOINT ["java","-jar","/admin-server.jar"]