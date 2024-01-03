#!/usr/bin/env bash

# Builds application and docker image using Dockerfile and tags it based on org.opencontainers.image.version label in
# Dockerfile.

#######################################
# Script main function. Builds application and docker image using Dockerfile and tags it based on
# org.opencontainers.image.version label in Dockerfile.
# Arguments:
#   None.
#######################################
function main() {
    export JAVA_HOME="/c/Program Files/Java/jdk-17"  

    # Extracting title and version directly from Dockerfile using awk
    title=$(awk -F= '/org.opencontainers.image.title/ {print $2}' Dockerfile | xargs)
    version=$(awk -F= '/org.opencontainers.image.version/ {print $2}' Dockerfile | xargs)

    # Ensure the variables are set and not empty
    if [ -z "$title" ] || [ -z "$version" ]; then
        echo "Error: Failed to extract title or version from Dockerfile."
        read -p "Press Enter to continue..."
        exit 1
    fi

    mvn clean verify

    docker build \
      --label "org.opencontainers.image.created=$(date +%Y-%m-%dT%H:%M:%S%:z)" \
      --label "org.opencontainers.image.ref.name=$(git rev-parse HEAD)" \
      --label "org.opencontainers.image.revision=$(git rev-parse HEAD)" \
      -t "${title}:${version}" .
}

main "$@"