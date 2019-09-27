#!/bin/bash

cf d gateway -f -r
cf d user-service -f -r
cf d order-service -f -r
cf d product-service -f -r
cf ds eureka -f

