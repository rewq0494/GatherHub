<template>
    <div><LogNavbarMenu/></div>
    <div class="bg"><div class="member">
      <div class="menu-area">
            <router-link class="router-link-active" to="MemberPage"> <div class="option-box">會員資訊</div></router-link>
            <router-link class="router-link-active" to="UserLeasePage"><div class="option-box">租賃狀況</div></router-link>
            <div class="option-box">會議室預約</div>
            <router-link to="UserContract" class="router-link-active"><div class="option-box">線上簽約</div></router-link>
            <div class="option-box">即時客服</div>
        </div>
        <div class="member-area">
            <h3>會員資訊</h3>
            <div class="text-area">
            <p>姓名：王曉明</p>
            <p>帳號：EEIT64</p>
            <p>電話：04-1234-5678</p>
            <p>信箱：EEIT64@gmail.com</p>
            <p>地址：台中市南屯區文心南三路1號</p></div>

        </div>

    </div></div>
    <div class="footer"><FooterArea/></div>
    
    </template>
    <!-- ----------------------------------------------------- -->
  <script>
  import LogNavbarMenu from '../components/LogNavbarMenu.vue'
  import FooterArea from '../components/FooterArea.vue'
  
  export default {
  
    components: {
      LogNavbarMenu,
      FooterArea,
    }
  }
  </script>
  
  
  <style scoped>
  *{
    font-family: "微軟正黑體";
  }

  html, body {
    background-color: #524e4e49;
    margin: 0;
    padding: 0;
  }
  .bg{
    /* background-color: #f1e7d7; */
    background-color: #373737;
    height: 1000px;
  }
  div{
    position: relative;
  }
  h3{
    font-size: 24px;
    color: #383434;
    position: absolute;
    top: 10px;
    left: 50px;
    font-weight: 500;
    
  }
  .text-area{
    position: absolute;
    top: 80px;
    left: 80px;
  }
  .text-area p{
margin-top: 30px;
margin-bottom: 30px;
color: #383434;
}
  .option-box{
    width: 200px;
    height: 36px;
    background-color: rgba(247, 216, 156, 0.807);
    border-radius: 10px;
    text-align: center;
    margin-top: 20px;
    margin-bottom: 10px;
    margin-left: 50px;
    cursor: pointer;
    line-height: 36px;
    color: #373737;
  }
  .option-box:hover{
    background:#edb477 ;
    transition: background-color 0.5s;
  }

  .member{
    width: 80%;
    left: 10%;
    height: 620px;
    border-radius: 30px;
    position: absolute;
    top: 100px;
    background-color: #f1e7d7;
  }
  .menu-area{
    width: 300px;
    height: 300px;
    position: absolute;
    top: 50px;
    left: 80px;
    border-radius: 20px;
    /* background-color: rgba(241, 210, 175, 0.807); */
    background-color: rgba(249, 248, 246, 0.807);
    /* padding-top: 20px; */
  }
  .member-area{
    width: 700px;
    height: 500px;
    position: absolute;
    top: 50px;
    right: 80px;
    border-radius: 20px;
    /* background-color: rgba(241, 210, 175, 0.807); */
    background-color: rgba(249, 248, 246, 0.807);
  }
  .router-link-active {
  text-decoration: none ;
}

  .footer{
    position: absolute;
    bottom: 0;
    width: 100%;
  }
  
  
  /* 設置整個滾動條的寬度和高度 */
  ::-webkit-scrollbar {
    background-color: rgba(46, 43, 40, 0.925);
    width: 7px;
  }
  
  /* 滾動條的按鈕部分（上下箭頭按鈕） */
  ::-webkit-scrollbar-button {
    background: transparent;
    border-radius: 4px;
    height: 0px;
  }
  
  /* 動條軌道的樣式 */
  ::-webkit-scrollbar-track-piece {
    background: transparent;
  }
  
  /* 滾動條滑塊的樣式 */
  ::-webkit-scrollbar-thumb {
    border-radius: 4px;
    background-color: rgba(46, 45, 45, 0.925);
  } 
  </style>