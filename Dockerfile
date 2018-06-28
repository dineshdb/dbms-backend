FROM openjdk
WORKDIR /
ADD src/main/wrapper.sh wrapper.sh
COPY /build/libs/ .
EXPOSE 81
RUN bash -c 'chmod +x /wrapper.sh'
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]
