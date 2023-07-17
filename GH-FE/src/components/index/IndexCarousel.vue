<template>
      <!-- 首頁三格窗 -->
      <br><br>
  <div class="container">
  <div id="office-section" class="section">
      <div class="content">
        <router-link class="link" to="/OfficePage"><h1>辦公室</h1></router-link>
        <hr>
        <!-- <p>Start Your Business At Gather Hub </p> -->
      </div>
      <div class="overlay"></div>
    </div>
    <div id="class-section" class="section">
      <div class="content">
        <h1>會議教室</h1>
        <hr>
        <!-- <p>Everything could happen in Gather Hub </p> -->
      </div>
      <div class="overlay"></div>
    </div>
    <div id="map-section" class="section">
      <div class="content">
        <h1>交通資訊</h1>
        <hr>
        <!-- <p>Touring Gather Hub, Surprise Everywhere.</p> -->
      </div>
      <div class="overlay"></div>
    </div>
  </div>
</template>
<script>

</script>
<style scoped>
h1 {
  text-align: center;
}
.link{
  text-decoration-line: none;
  color: #fff;
}
.container {
    top: 30px;
  display: flex;
  height: 92vh;
}

.section {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  overflow: hidden;
  background-size: cover;
  background-position: center;
  color: #fff;
  transition: flex .4s ease;
  position: relative;
  cursor: pointer;
}

.section .overlay {
  background-color: rgba(145, 142, 142, 0.547);
  width: 100%;
  height: 100%;
  position: absolute;
  transition: background-color .8s ease;
}

.section .content {
  z-index: 2;
}

.section:hover {
  flex: 2;
}

.section:hover .overlay {
  background-color: rgba(0, 0, 0, 0.95);
}

/* 三格窗的照片開始 */
#office-section {
  background-image: url(../../assets/index-img/固定.jpg);
}
#class-section {
  background-image: url(../../assets/index-img/3D_classC.jpg);
}
#map-section {
  background-image: url(../../assets/index-img/3D_public.jpg);
}
/* 三格窗的照片結束 */
</style>