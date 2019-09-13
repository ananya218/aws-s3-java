FROM ubuntu:18.04
MAINTAINER john.nguyen@prisma-capacity.eu

COPY target/S3BucketFetcher-1.0-SNAPSHOT-shaded.jar /home

WORKDIR "/home"

RUN echo "Update OS and install Python" && \
    apt-get -y update && \
    apt-get -y upgrade && \
    echo "${LOG_TAG} Install java8" && \
    apt-get install --no-install-recommends -y openjdk-8-jdk wget && \
    rm -rf /var/lib/apt/lists/*

CMD ["java","-jar","/home/S3BucketFetcher-1.0-SNAPSHOT-shaded.jar"]