#!/usr/bin/env bash
set -e
pushd . > /dev/null
cd $(dirname ${BASH_SOURCE[0]})
source ./env.sh
source ./docker-compose.sh
popd > /dev/null

function down() {
    docker_compose_in_env down --remove-orphans $@
}

function main() {
    down $@
}

if [ "${BASH_SOURCE[0]}" == "$0" ]; then
    main $@
fi