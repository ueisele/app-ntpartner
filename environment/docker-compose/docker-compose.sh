#!/usr/bin/env bash
set -e
pushd . > /dev/null
cd $(dirname ${BASH_SOURCE[0]})
YAML_DIR=$(pwd)
popd > /dev/null

function docker_compose_in_env() {
    (cd ${YAML_DIR}; docker-compose $(for file in $(ls *.yml); do echo "-f ${file}"; done) $@)
}