FROM centos
# Update CentOS 7
RUN yum update -y && yum upgrade -y

# Install packages
RUN yum install -y unzip wget curl git

RUN yum install -y java-1.8.0-openjdk-devel

RUN yum clean all

VOLUME /tmp
ADD target/GonnectChatter-0.0.1.jar gonnectchatter.jar
RUN sh -c 'touch /gonnectchatter.jar'


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/gonnectchatter.jar"]