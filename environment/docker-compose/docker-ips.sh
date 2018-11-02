#!/usr/bin/env bash
set -e
pushd . > /dev/null
cd $(dirname ${BASH_SOURCE[0]})
source ./env.sh
popd > /dev/null

NETWORK="${PROJECT_NETWORK}"

function docker-ips() {
    docker ps -f network="${NETWORK}" | while read line; do
        if `echo $line | grep -q 'CONTAINER ID'`; then
			printf "%-25s\t%-25s\n" 'Name' 'IP Address'
        else
            CID=$(echo $line | awk '{print $1}');
            NAME=$(docker inspect --format '{{ .Name }}' $CID);
            IP=$(docker inspect --format "{{ .NetworkSettings.Networks.${NETWORK}.IPAddress }}" $CID);
			printf "%-25s\t%-25s\n" ${NAME} ${IP}
        fi
    done;
}

if [ "${BASH_SOURCE[0]}" == "$0" ]; then
    docker-ips
fi
