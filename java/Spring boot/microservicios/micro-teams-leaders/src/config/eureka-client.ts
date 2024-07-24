import { Eureka } from 'eureka-js-client'

const client = new Eureka({
    instance:{
        app: 'team-leader-service',
        instanceId: 'team-leader-service-instance',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        statusPageUrl: 'http://localhost:8000/info',
        port: {
            '$': 7000,
            '@enabled': true,
        },
        vipAddress: 'team-leader-service',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn'
        }
    },
    eureka: {
        host: 'localhost',
        port: 8761,
        servicePath: '/eureka/apps/'
    }
})