<template>
    <div class="main-section-bg">
  <div class="sidebar">
    <!-- 側邊欄的內容 -->
    <img class="logo" src="../assets/logo/透明logo.png">
   
    <ul>
       
       <li><router-link to="/MemberList"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/member.png">
        會員資訊</router-link></li> 
      <li><router-link to="/LeaseStatus"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/rent.png">
        租賃情況</router-link></li>
      <li><router-link to="/ContractList"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/contract.png">
        合約管理</router-link></li>
      <li><router-link to="/MeetingSchedule"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/meeting.png">
        會議教室</router-link></li>
      <li><router-link to="/RevenueChart"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/revenue.png">
        營收管理</router-link></li>
      <li><router-link to="/AccessControl"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/access-control.png">
        權限管理</router-link></li>
      <li><router-link to="/ChatWidget"  class="nav-link" active-class="active-link">
        <img src="../assets/sidebar-icon/communication.png">
        即時客服</router-link></li>
    </ul>
    <button type="button" class="lagout-but" @click="lagout">登出</button>
    
  </div>
  <div class="components">
  </div>

  <div class="main-section"></div>
</div>
  <router-view></router-view>
</template>


<script>

  // 側邊欄組件的邏輯和行為
 
export default {
  
  mounted() {
    
      
  },
  methods:{
    lagout(){

    },
    
  }
  
}


</script>



<style scoped>

  /* 側邊欄的樣式 */
.sidebar {
  background-color: #373633;
  position: fixed;
  left: 0;
  top: 0;
  width: 16%;
  height: 100%;
  margin-top: 0px;
}

.logo{
  margin-top: 16px;
  margin-left: 22%;
  width: 56%;
}
.sidebar li {
  list-style: none;
  margin-top: 40px;
  margin-left: 10%;
}
.nav-link{
  font-size: 18px;
  color:#F5CF91 ;
  font-size: 14px;
  align-items: center;
  display: flex;
  text-decoration: none;
  letter-spacing: 1px;
}

.sidebar ul img{
  width: 36px;
  height: 36px;
  margin-right: 16px;
}

.lagout-but{
  background-color: #F7AF44;
  font-size: 14px;
  color: #fff;
  width: 30%;
  height: 28px;
  margin-left: 35%;
  margin-top: 40px;
  border-radius: 10px;
  border-width: 0;
}
.lagout-but:hover{
    background-color: #cea25f;
    border: 0.5px solid #c2a171;
    transition: background-color 0.3s;
    transition: border 0.3s;
  }
  .lagout-but:active{
    background-color: #947658;
    border: 0.5px solid #716d67;
    transition: background-color 1s;
    transition: border 0.2s;
  }
.main-section{
  background-color:rgb(244, 241, 237);
  width: 84%;
  height: 100%;
  position: fixed;
  right:0;
  top:0;
  border-radius: 50px 0 0 50px;
}
.main-section-bg{
  background-color:#373633;
  width: 100%;
  height: 100%;
  position: fixed;
  right:0;
  top:0;
}
</style>
