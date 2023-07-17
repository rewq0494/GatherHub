import { createRouter, createWebHashHistory} from 'vue-router';
// import IndexPage from '../views/IndexPage.vue';

const routes = [
    {
        path:'/',
        // component: IndexPage,
        children: [
            {
              path: 'MemberList',
              name: '會員資訊',
              component:() => import('../views/MemberList.vue'),
            },
            {
              path: 'LeaseStatus',
              name: '租賃情況',
              component:() => import('../views/LeaseStatus.vue'),
            },
            {
              path: 'ContractList',
              name: '合約管理',
              component:() => import('../views/ContractList.vue'),
            },
            {
              path: 'MeetingSchedule',
              name: '會議教室',
              component:() => import('../views/MeetingSchedule.vue'),
            },
            {
                path:'RevenueChart',
                name: '營收管理',
                component:() => import('../views/RevenueChart.vue')
              },
            {
                path:'AccessControl',
                name: '權限管理',
                component:() => import('../views/AccessControl.vue')
              },
            {
                path:'ChatWidget',
                name: '線上客服',
                component:() => import('../views/ChatWidget.vue')
              },
            {
                path:'IndexPage',
                name: '首頁',
                component:() => import('../views/IndexPage.vue')
              },
            {
                path:'AdminLogin',
                name: '後台登入頁面',
                component:() => import('../views/AdminLogin.vue')
              },
            {
                path:'IndexPage',
                name: '首頁',
                component:() => import('../views/IndexPage.vue')
              },
            {
                path:'LoginPage',
                name: '登入頁面',
                component:() => import('../views/LoginPage.vue')
              },
            {
                path:'SignUpPage',
                name: '註冊頁面',
                component:() => import('../views/SignUpPage.vue')
              },
            {
                path:'MemberPage',
                name: '會員資訊頁面',
                component:() => import('../views/MemberPage.vue')
              },
            {
                path:'LoginIndexPage',
                name: '登入後首頁',
                component:() => import('../views/LoginIndexPage.vue')
              },
            {
                path:'OfficePage',
                name: '辦公室頁面',
                component:() => import('../views/OfficePage.vue')
              },
            {
                path:'UserLeasePage',
                name: '客戶租賃狀況頁面',
                component:() => import('../views/UserLeasePage.vue')
              },
            {
                path:'UserChat',
                name: '客戶對話頁面',
                component:() => import('../views/UserChat.vue')
              },
            {
                path:'UserContract',
                name: '客戶合約頁面',
                component:() => import('../views/UserContract.vue')
              },
            {
                path:'SignPage',
                name: '客戶簽名頁面',
                component:() => import('../views/SignPage.vue')
              },
            ]
    },
   
    
        
        
    
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;
