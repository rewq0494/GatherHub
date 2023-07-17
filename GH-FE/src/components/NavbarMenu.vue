<template>
   <div class="navigation">
    <div class="nav-container">
      <div class="logo" ><a href="./index.html"><img class="logo-img" src="../assets/logo/透明logo.png" ></a></div>
      <nav>
          <div class="nav-mobile"><a id="nav-toggle" href="#!"><span></span></a></div>
          <ul class="nav-list">
              <li><a href="">品牌理念</a></li>
              <li><a href="">課程資訊</a></li>
              <li><a href="">交通資訊</a></li>
              <li><router-link to="/LoginPage">會員登入</router-link></li>
          </ul>
          </nav>
      </div>
    </div>
  <router-view></router-view>
</template>


<script>
import $ from 'jquery';
export default {
  mounted() {
    $('.dropdown').click((e) => {
      e.stopPropagation();
      $('.nav-dropdown').toggle();
    });

    $('html').click(() => {
      $('.nav-dropdown').hide();
    });

    $('#nav-toggle').on('click', function() {
      this.classList.toggle('active');
    });

    $("#nav-toggle").click(() => {
      $("nav ul").toggle();
    });
  }
}


</script>



<style scoped>
/* 網頁背景 */
body {
  margin: 0;
  padding: 0;
  background-color: #373633;
}

/* 導覽列 開始*/
.logo-img{
  margin-top: 10px;
  vertical-align: middle; 
  width:12%;
  min-width: 100px
}

/* 整個nav的section */
.navigation {
  height: 70px;
  background-color: #373633;
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 9999;
}

/* nav容器 */
.nav-container {
  max-width: 1000px;
  margin: 0 auto;
  
}

/* logo物件 */
.brand {
  width: 30%;
  float: left;
  line-height: 70px;
  padding-left: 20px;
  /* margin-top: 10px; */
 }

.brand a {
  text-decoration: none;
  text-transform: uppercase;
}

nav {
  float: right;
  position: absolute;
  top: 0;
  right: 0px;
}

nav ul {
  margin: 0;
  padding: 0;
  list-style: none;
}

nav ul li {
  float: left;
  position: relative;
}

nav ul li a {

  display: block;
  color: #fff;
  padding: 0 20px;
  background: #373633;
  text-decoration: none;
  line-height: 70px;
}

nav ul li a:hover {
          background: #4e4c48; /*滑鼠碰到的顏色*/
          color: #ffffff;
          transition: .4s;
}

nav ul li a:not(:only-child):after {
          padding-left: 4px;
          content: '  ▾'; }

nav ul li ul li {
  min-width: 160px;
  }

nav ul li ul li a {
  padding: 15px;
  line-height: 20px;
  
  
}

   /* 導覽列下拉選單(如果有就新增class) */
.nav-dropdown {
  position: absolute;
  z-index: 1;
  box-shadow: 0 3px 12px rgba(0, 0, 0, 0.15);
  display: none;  } 



/* Mobile Hamburger Menu */

.nav-mobile {
  display: none;
  height: 70px;
  width: 70px;
  position: absolute;
  top: 0;
  right: 0;
  background-color: #373633;
}

/* 響應式 */
/* Media Query for Navigation */

 @media only screen and (max-width: 800px) {

  .nav-mobile {
    display: block;
  }
  
  nav {
    width: 100%;
    padding: 0 15px;
  }

  #navlogo{
    vertical-align: middle; /*垂直居中logo*/
  }
  
  nav ul {
    display: none;
  }
  
  nav ul li {
    float: none;
  }
  
   nav ul li a {
          padding: 15px;
          line-height: 20px; 
  }

  nav ul li ul li a {
          padding-left: 40px;
          background-color: gray;
  }
  
  .nav-dropdown {
    position: static;
  }
}

@media screen and (min-width: 800px) {
  .nav-list {
    display: block !important; } }
#nav-toggle {
  position: absolute;
  left: 18px;
  top: 22px;
  cursor: pointer;
  padding: 10px 35px 16px 0; }
  #nav-toggle span,
  #nav-toggle span:before,
  #nav-toggle span:after {
    cursor: pointer;
    border-radius: 1px;
    height: 4px;
    width: 30px;

    /* 選單列的三條線 */
    background: rgb(245, 205, 127);
    position: absolute;
    display: block;
    content: '';
    transition: all 300ms ease-in-out; }
  #nav-toggle span:before {
    top: -10px; }
  #nav-toggle span:after {
    bottom: -10px; }
  #nav-toggle.active span {
    background-color: transparent; }
    #nav-toggle.active span:before, #nav-toggle.active span:after {
      top: 0; }
    #nav-toggle.active span:before {
      transform: rotate(45deg); }
    #nav-toggle.active span:after {
      transform: rotate(-45deg); } 


      * {
          box-sizing: border-box;
        }
        
      
</style>
