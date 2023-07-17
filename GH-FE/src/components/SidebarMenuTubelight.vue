<template>
    <!-- <div class="tubelight" :style="{ top: tubelightTop }"></div> -->
    <div class="tubelight" id="tubelight1" :style="{ top: tubelightTop }"></div>
    <div class="tubelight" id="tubelight2" :style="{ top: tubelightTop }"></div>
    <div class="tubelight" id="tubelight3" :style="{ top: tubelightTop }"></div>
    <div class="tubelight" id="tubelight4" :style="{ top: tubelightTop }"></div>
    <div class="tubelight" id="tubelight5" :style="{ top: tubelightTop }"></div>
    <div class="tubelight" id="tubelight6" :style="{ top: tubelightTop }"></div>
    <div class="tubelight" id="tubelight7" :style="{ top: tubelightTop }"></div>
</template>
  
  <script>


</script>



  
  <style>
  .tubelight {
    position: absolute;
    left: 10%;
    width: 1.5%;
    height: 58px;
    background: #ebca8f;
    box-shadow: 3px 0px 10px 3px #ab8b4c;
    border-radius: 2px;
  }
  #tubelight1{
    position: absolute;
    top: 16%;
  }
  #tubelight2{
    position: absolute;
    top: 26%;
    display: none; /* 初始状态隐藏 */
  }
  #tubelight3{
    position: absolute;
    top: 37%;
    display: none; /* 初始状态隐藏 */
  }
  #tubelight4{
    position: absolute;
    top: 47%;
    display: none; /* 初始状态隐藏 */
  }
  #tubelight5{
    position: absolute;
    top: 58%;
    display: none; /* 初始状态隐藏 */
  }
  #tubelight6{
    position: absolute;
    top: 68%;
    display: none; /* 初始状态隐藏 */
  }
  #tubelight7{
    position: absolute;
    top: 79%;
    display: none; /* 初始状态隐藏 */
  }
  </style>