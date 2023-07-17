<template>
  <div><LogNavbarMenu/></div>
  <div><IndexCarousel/></div>
  <div><IndexService/></div>
  <div><NewsArea/></div>
  <div class="footer"><FooterArea/></div>
  
  </template>
  <!-- ----------------------------------------------------- -->
<script>
import LogNavbarMenu from '../components/LogNavbarMenu.vue'
import IndexCarousel from '../components/index/IndexCarousel.vue'
import IndexService from '../components/index/IndexService.vue'
import NewsArea from '../components/index/NewsArea.vue'
import FooterArea from '../components/FooterArea.vue'

export default {

  components: {
    LogNavbarMenu,
    IndexCarousel,
    IndexService,
    NewsArea,
    FooterArea,
  }
}
</script>


<style >

html, body {
  background-color: #524e4e49;
  margin: 0;
  padding: 0;
}
div{
  position: relative;
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