<template>
   <div class="news-area" id="services">
    <div class="content-we">
      <h2><span class="we-are"> </span> 最新消息</h2></div>
      <br><hr>
      <div class="row1">
      <img  src="../../assets/news-img/1.jpg" >
      <img  src="../../assets/news-img/2.jpg" >
      <img  src="../../assets/news-img/3.jpg" ></div>
      <div class="row2">
      <img  src="../../assets/news-img/4.jpg" >
      <img  src="../../assets/news-img/1.jpg" >
      <img  src="../../assets/news-img/2.jpg" ></div>
  


  </div>
</template>
<script>

</script>
<style scoped>
hr{
  background-color: #e29e55;
}
.news-area{
  position: absolute;
    background-color: #373737;
    top: 0;
    height: 1200px;
    width: 100%;
}
img{
  height: 400px;
  margin-top: 100px;
  margin-left: 20px;
  margin-right: 20px;
  border-radius: 10px;
  cursor: pointer;
}
.row1{
  top: 20px;
  left: 105px;
}
.row2{
  left: 105px;
}

.content-we {
  position: absolute;
  left: -550px;
  padding:4em 0em 3em 0em;
   margin-bottom: 20px;
   margin-top: -20px;
    float: left;
    margin-left: 50px;
   width: 80%;
 }
/* .content-we {
  padding:4em 0em 3em 0em;
   margin-bottom: 20px;
   margin-top: -20px;
    float: left;
    margin-left: 50px;
   width: 80%;
 } */
 .content-we  h2 span{
  background:#e29e55;
  padding: 0px 8px;
  margin-right: 0.5em;
   
 }
 .content-we h2{
  color: #ffffff;
  font-size:24px;
  font-weight:400;
  text-transform: uppercase;
   text-align: center;
   margin-bottom: 2px;
 }

</style>