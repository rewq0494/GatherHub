<template>
     
   <img src="../assets/meeting-img/柴切會議教室公共空間.jpg" id="bgImg" />
  <div id="bgImgCover"></div>
  <div id="bgColor">
      <img src="../assets/logo/透明图-01.png" id="logo">
      <h2>會員註冊</h2>
      <div class="logBg">
        <div class="form-area">
        <label for="name">
          <p>姓名：</p>
          <input type="text" id="name" name="name" v-model="name">
        </label>
        <label for="phone">
          <p>電話：</p>
          <input type="text" id="phone" name="phone" v-model="phone">
        </label>
        <label for="userId">
          <p>帳號：</p>
          <input type="text" id="userId" name="userId" v-model="userId">
        </label>
        <label for="password">
          <p>密碼：</p>
          <input type="password" id="password" name="password" v-model="password">
        </label>
        <label for="email">
          <p>信箱：</p>
          <input type="text" id="email" name="email" v-model="email">
        </label>
        <label for="email">
          <p>地址：</p>
          <input type="text" id="email1" name="email1" v-model="emai1">
        </label>
        </div>
          
        <router-link to="/LoginPage"><button type="submit" class="sign" @click="alert">會員註冊</button></router-link>
        <router-link to="/LoginPage"><button  class="login">會員登入</button></router-link>

        <router-link to="/IndexPage" class="goBack">＜返回首頁</router-link>
            <!-- <router-link to="/LoginPage" class="goToLogin">登入帳號＞</router-link> -->
      </div>
  </div>
</template>
<script>
export default{
   data(){
      return{
         name:"",
         phone:"",
         userId:"",
         password:"",
         email:"",
      }
   },
   methods:{
      alert(){
         alert("註冊成功");
      }
   }
}

</script>
<style scoped>
body {
   margin: 0px;
   padding: 0;
   height: 100%;
 }


#bgImg{
   background-repeat: no-repeat;
   height: 100vh;
   position: absolute;
   top: 0;
   left: 0;
}

#bgImgCover{
   position: absolute;
   width: 25%;
   height: 100vh;
   top: 0;
   left: 0;
   background: rgba(171, 171, 171, 0.42);
}
#bgColor{
   position: absolute;
   width: 75%;
   height: 100vh;
   top: 0;
   right: 0;
   background: #373633;
}

#logo{
   position: absolute;
   top: 3%;
   left: 40%;
   width: 200px;
   height: auto;
}

/* 登入框底 */
.logBg {
position: absolute;
top: 25%;
left: 20%;
width: 700px;
height: 470px;
background: #EEDFC1;
border-radius: 60px;
}

h2 {
   color: #F8D18F;
   position: absolute;
   top: 15%;
   left: 45%;
}
.form-area{
   position: absolute;
   top: 50px;
   right: 200px;
}

label{
   display: flex;
   height: 38px;
   margin-bottom: 16px ;
}
.logBg p {
   color: #787878;
   font-size: 15px;
   margin-bottom: 100px;
   font-weight: 500;
}
.logBg input {
   margin-bottom: 0px;
   border-radius: 20px;
   color: #787878;
   font-size: 16px;
   width: 280px;
   height: 36px;
   border: none;
   padding-left: 12px;
   outline: none;

}
/* 註冊紐 */
.sign{
   border: none;;
   background:#E29E55; 
   position: absolute;
   width: 150px;
   height: 40px;
   left: 53%;
   bottom:30px;
   border-radius: 30px;
   transition: 0.5s;
   cursor: pointer;
}

.sign:hover {
   background:#f1c08c ;
}


/* 登入紐 */
.login{
    border: none;
    background-color:#BDAA94; 
    position: absolute;
    width: 150px;
    height: 40px;
    left: 28%;
    bottom:30px;
    border-radius: 30px;
    transition: 0.5s;
    cursor: pointer;
}

.login:hover {
    background:#ccc0b3 ;
}


.goBack{
    font-size: 14px;
    position: absolute;
    bottom: 16px;
    left:35px;
    color: #373633;
    text-decoration-line: none;
}
.goToLogin{
    font-size: 14px;
    position: absolute;
    bottom: 16px;
    right: 35px;
    color: #373633;
    text-decoration-line: none;

}
</style>