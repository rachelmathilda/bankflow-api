# TODO: 
# 1. build (base image, set working dir, copy pom.xml, copy src, build jar)
# 2. runtime (base image, copy jar hasil stage build, user non-root, expose 8080, entrypoint java - jar)

FROM eclipse-temurin:17-jre
