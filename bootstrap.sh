#!/bin/bash

# Install dependencies
cd ./config/spotless || exit
npm install || colorEcho "npm install failed. Make sure, you have installed node with npm package manager." red
