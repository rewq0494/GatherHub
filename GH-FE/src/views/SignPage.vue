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
            <h3>線上簽約</h3>
            <div class="text-area">

              <div>
    <canvas ref="canvas" id="canvas" class="canvas" width="540" height="260" @mousedown="startPosition"
      @mouseup="finishedPosition" @mouseleave="finishedPosition" @mousemove="draw" @touchstart="startPosition"
      @touchend="finishedPosition" @touchcancel="finishedPosition" @touchmove="draw"></canvas>

    <!-- <img class="show-img" width="250" height="150" style="border: 1px solid" :src="imageSrc" /> -->

    <div class="btn-group">
      <button class="clear" @click="reset">清除</button>
      <button class="save" @click="saveImage">完成</button>
    </div>
    <button class="next">下一步></button>
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
  mounted() {
    this.initializeCanvas();
  },
  data() {
    return {
      isPainting: false,
      imageSrc: "",
    };
  },
  methods: {
    initializeCanvas() {
      const canvas = this.$refs.canvas;
      const ctx = canvas.getContext("2d");

      // 設定線條的相關數值
      ctx.lineWidth = 4;
      ctx.lineCap = "round";
    },
    getPaintPosition(e) {
      const canvasSize = this.$refs.canvas.getBoundingClientRect();

      if (e.type === "mousemove") {
        return {
          x: e.clientX - canvasSize.left,
          y: e.clientY - canvasSize.top,
        };
      } else {
        return {
          x: e.touches[0].clientX - canvasSize.left,
          y: e.touches[0].clientY - canvasSize.top,
        };
      }
    },
    startPosition(e) {
      e.preventDefault();
      this.isPainting = true;
    },
    finishedPosition() {
      this.isPainting = false;
      const ctx = this.$refs.canvas.getContext("2d");
      ctx.beginPath();
    },
    draw(e) {
      if (!this.isPainting) return;
      const ctx = this.$refs.canvas.getContext("2d");
      const paintPosition = this.getPaintPosition(e);
      ctx.lineTo(paintPosition.x, paintPosition.y);
      ctx.stroke();
    },
    reset() {
      const ctx = this.$refs.canvas.getContext("2d");
      ctx.clearRect(0, 0, this.$refs.canvas.width, this.$refs.canvas.height);
    },
    saveImage() {
      const canvas = this.$refs.canvas;


      // 圖片儲存的類型選擇 png ，並將值放入 img 的 src
      const newImg = canvas.toDataURL("image/png");
      this.imageSrc = newImg;
      localStorage.setItem('img', newImg)
    },
  },
};


  // export default {
  
  //   components: {
  //     LogNavbarMenu,
  //     FooterArea,
  //   }
  // }
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
.canvas{
   border: 1px solid #777373;
   border-radius: 10px;
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
  .clear{
    background-color: #adacab;
    border: none;
    border-radius: 10px;
    width: 60px;
    height: 30px;
    cursor: pointer;
    position: relative;
    left: 200px;
  }
  .clear:hover{
    background-color: #bdbcba;
    transition: background-color 0.5s;
  }
  .save{
    background-color: #eda75c;
    border: none;
    border-radius: 10px;
    width: 60px;
    height: 30px;
    cursor: pointer;
    position: relative;
    left: 220px;
  }
  .save:hover{
    background-color: #fbc081;
    transition: background-color 0.5s;
  }
  .save:active{
    background-color: #d67526 ;
    transition: background-color 0.05s;
    
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