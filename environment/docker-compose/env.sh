#!/usr/bin/env bash
set -e
pushd . > /dev/null
cd $(dirname ${BASH_SOURCE[0]})
source ./.env
export VERSION_APP=$(git describe --tags --abbrev=7)
popd > /dev/null

PROJECT_NAME="${COMPOSE_PROJECT_NAME}"
PROJECT_NETWORK="${COMPOSE_PROJECT_NAME}_default"