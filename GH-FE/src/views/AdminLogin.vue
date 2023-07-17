<template>
    <div>
      <img src="../assets/meeting-img/柴切會議教室公共空間.jpg" id="bgImg" />
      <div id="bgImgCover"></div>
      <div id="bgColor">
        <img src="../assets/logo/透明图-01.png" id="logo">
        <h2>企業後台登入</h2>
        <div class="logBg">
          <p class="user">帳號：</p>
          <input type="text" class="userBox" v-model="username">
          <p class="pw">密碼：</p>
          <input type="password" class="pwBox" v-model="password">
          <button class="login" @click="login">登入</button>
          <router-link to="/IndexPage" class="goBack">＜返回首頁</router-link>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        username: "",
        password: "",
      };
    },
    methods: {
      login() {
        // 執行實際的登入驗證邏輯
        if (this.username === "admin" && this.password === "password") {
          alert("登入成功");
          this.$router.push("/MemberList"); // 登入成功後導航到 MemberList 頁面
        } else {
          alert("帳號或密碼錯誤");
        }
      },
    },
  };
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
top: 30%;
left: 20%;
width: 700px;
height: 380px;
background: #EEDFC1;
border-radius: 60px;
}

h2 {
    color: #F8D18F;
    position: absolute;
    top: 18%;
    left: 43%;
}

.user{
    position: absolute;
    left: 20%;
    top: 20%;
	font-family: Inter;
	font-size: 20px;
	text-align: left;
	color:#787878;
}
.pw{
    position: absolute;
    left: 20%;
    top: 148px;
	font-family: Inter;
	font-size: 20px;
	text-align: left;
	color:#787878;
}

.userBox {
    color: #787878;
    font-size: 16px;
    position: absolute;
    left: 30%;
    top: 23%;
    width: 300px;
    height: 36px;
    border: none;
    border-radius: 20px;
    padding-left: 12px;
}
.pwBox {
    color: #787878;
    font-size: 16px;
    position: absolute;
    left: 30%;
    top: 160px;
    width: 300px;
    height: 36px;
    border: none;
    border-radius: 20px;
    padding-left: 12px;
}


/* 登入紐 */
.login{
    border: none;
    background-color:#E29E55; 
    position: absolute;
    width: 150px;
    height: 40px;
    left: 40%;
    top:260px;
    border-radius: 30px;
    transition: 0.5s;
    cursor: pointer;
}

.login:hover {
    background:#f1c08c ;
}
.goBack{
    font-size: 14px;
    position: absolute;
    bottom: 16px;
    left: 35px;
    color: #373633;
    text-decoration-line: none;
}
.goToRegister{
    font-size: 14px;
    position: absolute;
    bottom: 16px;
    right: 35px;
    color: #373633;
    text-decoration-line: none;

}
</style>