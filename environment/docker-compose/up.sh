#!/usr/bin/env bash
set -e
pushd . > /dev/null
cd $(dirname ${BASH_SOURCE[0]})
source ./env.sh
source ./docker-compose.sh
source ./docker-ips.sh
popd > /dev/null

function main () {
    log
    docker_compose_in_env build
    start_service "mysql"
    sleep 10
    start_service "ntpartner"

    docker-ips
}

function log() {
    echo "Starting NTPartner ${VERSION_APP}..."
}

function start_service () {
    docker_compose_in_env up -d "${1:-'Specify a service to start'}"
}

if [ "${BASH_SOURCE[0]}" == "$0" ]; then
    main $@
fi