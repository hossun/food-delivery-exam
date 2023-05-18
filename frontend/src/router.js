
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import StoreOrderManager from "./components/listers/StoreOrderCards"
import StoreOrderDetail from "./components/listers/StoreOrderDetail"

import DekeveryManager from "./components/listers/DekeveryCards"
import DekeveryDetail from "./components/listers/DekeveryDetail"

import AlertLogManager from "./components/listers/AlertLogCards"
import AlertLogDetail from "./components/listers/AlertLogDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/storeOrders',
                name: 'StoreOrderManager',
                component: StoreOrderManager
            },
            {
                path: '/storeOrders/:id',
                name: 'StoreOrderDetail',
                component: StoreOrderDetail
            },

            {
                path: '/dekeveries',
                name: 'DekeveryManager',
                component: DekeveryManager
            },
            {
                path: '/dekeveries/:id',
                name: 'DekeveryDetail',
                component: DekeveryDetail
            },

            {
                path: '/alertLogs',
                name: 'AlertLogManager',
                component: AlertLogManager
            },
            {
                path: '/alertLogs/:id',
                name: 'AlertLogDetail',
                component: AlertLogDetail
            },



    ]
})
