<template>
    <div><LogNavbarMenu/></div>
    <div class="bg"><div class="member">
      <div class="menu-area">
        <router-link class="router-link-active" to="MemberPage"> <div class="option-box">會員資訊</div></router-link>
            <router-link class="router-link-active" to="UserLeasePage"><div class="option-box">租賃狀況</div></router-link>
            <div class="option-box">會議室預約</div>
            <router-link to="SignPage" class="router-link-active"><div class="option-box">線上簽約</div></router-link>
            <div class="option-box">即時客服</div>
        </div>
        <div class="member-area">
            <h3>待簽文件</h3>
            <div class="text-area">
              <div>

                <div class="table-container">
    <table>
      <thead>
        <tr>
          <th>合約名稱</th>
          <th>日期</th>
          <th>審閱天數</th>
          <th>檔案</th>
          <th>簽名</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(contract, index) in contracts" :key="index">
          <td>{{ contract.name }}</td>
          <td>{{ contract.date }}</td>
          <td>{{ contract.reviewDays }}</td>
          <td><img src="../assets/dialog-icon/pdf.png" ></td>
          <td><router-link to="SignPage"><button>簽名</button></router-link></td>
        </tr>
      </tbody>
    </table>
  </div>
   
  </div>


        </div></div>

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
    },
    data() {
    return {
      contracts: [
        {
          name: 'I505辦公室合約',
          date: '2023/07/14',
          reviewDays: 3,
          file: 'path/to/image1.jpg',
        },
        {
          name: 'I506辦公室合約',
          date: '2023/08/01',
          reviewDays: 5,
          file: 'path/to/image2.jpg',
        },
      ],
    };
    },
    methods: {
    signContract(index) {
      // 在這裡處理簽名操作，可以使用適合的方法和邏輯
      console.log('簽名合約:', this.contracts[index]);
    },
  },
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
  .router-link-active {
  text-decoration: none ;
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
.next{
  background-color: rgba(249, 248, 246, 0.807);;
  border: 0;
  cursor: pointer;
  position: relative;
  left: 500px;
  top: 40px;
  font-size: 16px;
}
  .footer{
    position: absolute;
    bottom: 0;
    width: 100%;
  }

  .table-container {
  width: 100%;
}

table {
  width: 550px;
  border-collapse: collapse;
  
}

th,
td {
  padding: 6px 8px 6px 8px;
  border: 1px solid #ccc;
  text-align: center;
  color: #515151;
  
}


th {
  background-color: #f3d4b9;
}

img {
  max-width: 25px;
  max-height: 25px;
  cursor: pointer;
}
  button{
    cursor: pointer;
    border:none;
    background-color: #cbc9c4;
    border-radius: 5px;
    width: 46px;
    height: 24px;
  }
  button:hover{
    background-color: #dddcda;
    transition: background-color 0.8s;
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