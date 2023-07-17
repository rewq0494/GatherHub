<template>
  <div><NavbarMenu/></div>
  <div class="aa">
  <img src="../assets/office/4.jpg" alt="">
  <img src="../assets/office/擷取1.png" alt="">
  <img class="a" src="../assets/office/擷取2.png" alt=""></div>
  <div class="footer"><FooterArea/></div>
  
  </template>
  <!-- ----------------------------------------------------- -->
<script>
import NavbarMenu from '../components/NavbarMenu.vue'

import FooterArea from '../components/FooterArea.vue'

export default {

  components: {
    NavbarMenu,

    FooterArea,
  }
}
</script>


<style scoped >

html, body {
  background-color: #524e4e49;
  margin: 0;
  padding: 0;
}
div{
  position: relative;
}
img{
  width: 100%;
}
.aa{
  background-color: #373737;
}
.footer{
  position: absolute;
  top: 1600px;
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