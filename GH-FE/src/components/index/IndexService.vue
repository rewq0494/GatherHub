<template>
     
  <div class="content-what" id="services">
    <div class="content-we">
      <h2><span class="we-are"> </span> 關於Gather Hub</h2>
  </div>
    <div class="container-icon">
      <br>
      <div class="row1">
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/call-center.png" />
          <h4>秘書服務</h4>
          <p></p>
        </div>
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/oven.png" />
          <h4>微波冷藏設備</h4>
          <p></p>
        </div>
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/meeting.png" />
          <h4>會議面談空間</h4>
          <p></p>
        </div>
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/technical-support.png" />
          <h4>IT support</h4>
          <p></p>
        </div>
        <div class="clearfix"> </div>
      </div>

      <div class="row2">
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/wifi.png"  />
          <h4>全館Wi-Fi</h4>
          <p></p>
        </div>
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/access-control.png"  />
          <h4>智慧門禁系統</h4>
          <p></p>
        </div>
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/printer.png"  />
          <h4>多功能事務</h4>
          <p></p>
        </div>
        <div class="col-md-3 easy-them">
          <img class="icon-support" src="../../assets/index-icon/bar-counter.png"  />
          <h4>貴賓休憩吧台</h4>
          <p></p>
        </div>
        <div class="clearfix"> </div>
      </div>
    </div>
  </div>
  <!-- -container- -->

</template>
<script>

</script>
<style scoped>
/*設備服務介紹開始*/
.content-what {
    background-color: #383838;
  margin: 0px 0px 0em;
  height: 490px;
 }
 
 .container-icon {
    position: absolute;
    top: 115px;
    left: 150px;
   display: grid;
   grid-template-rows: repeat(2, auto); /* 設定為兩行相等的高度 */
   grid-gap: px; /* 設定列間距 */
 }
 .icon-support{
    margin-right: 200px;
    margin-bottom: 10px;
 }
 
 .content-we {
  padding:4em 0em 3em 0em;
   margin-bottom: 20px;
   margin-top: -20px;
    float: left;
    margin-left: 50px;
   
 }
 .content-we  h2 span{
  background:#e29e55;
  padding: 0px 8px;
  margin-right: 0.5em;
   
 }
 .content-we h2{
  color: #ffffff;
  font-size:22px;
  font-weight:400;
  text-transform: uppercase;
   text-align: center;
   margin-bottom: 2px;
 }
 
 /*---content-we-are---*/
 .content-we-are {
  margin: 0em 0em 7em;
 }
 
 .row1,
 .row2 {
   display: flex;
   justify-content: space-between;
   margin-left: 110px;
   margin-right: 110px;
   margin-bottom: 10px; /* 調整 col-md-3 元素之間的上方間距 */
 }
 
 .easy-them {
   padding-left: 10px;
   padding-right: 10px;
 }

.img-responsive{
	border-radius: 15px 15px 0 0;
}
.image-matter{
	border-radius: 15px;
	background: #e29e55;
	padding: 0em 0 0.2em;
	margin: 15px 17px;
}
.image-matter:hover{
	background:#767268;
}
h4{	
	color:#e2c389;
	text-transform:uppercase;

}
.image-matter img:hover{
	opacity:0.8;
}


</style>