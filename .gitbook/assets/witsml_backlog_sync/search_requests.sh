#!/bin/bash

data_dir=$1
source_name=$2
parent_uuid=$3

if [ $# -ge 3 ]; then
    echo
    echo "Liverig data dir: $data_dir"
    echo "Source: $source_name"
    echo "Parent request UUID: $parent_uuid"
else
    echo "Usage: $0 <liverig_data_dir> <source_name> <parent_uuid>"
    exit 1
fi

requests_dir=$data_dir/sources/$source_name/historyrequests

echo
echo -e "Looking for WITSML backlog sync requests in: $requests_dir"
echo
echo -e "Result:"
echo
grep -Rwl $requests_dir -e "\"parentUID\": \"$parent_uuid\"" | awk -F"/" '{print substr($0, 1, length($0) - length($NF) - 1)}'
