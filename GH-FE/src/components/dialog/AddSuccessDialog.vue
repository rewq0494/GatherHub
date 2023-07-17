<template>
    <div class="overlay"></div>
    <div class="add-success-dialog">
      <img class="success-icon" src="../../assets/dialog-icon/success.png" >
    <h2>新增成功！</h2>
  </div>
</template>
<script>
export default {
  emits: ['close', 'confirm'], // 声明 close 事件
  // 其他組件程式碼
  data() {
    return {
      showDialog: false
    }
  }
};
</script>

<style scoped>
*{
  font-family: '微軟正黑體';
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 设置半透明的黑色背景 */
  z-index: 9999; /* 确保遮罩层在其他内容之上 */
}
.add-success-dialog{
  width: 280px;
  height: 140px;;
  background-color: #ffffff;
  position: fixed;
  z-index: 999999;
  top: 36%;
  left: 43%;
  display: flex;
  align-items: center;
  border-radius: 20px;
}

.add-success-dialog h2{
  position: relative;
  margin-left: 26px;
  text-align: center;
  color: #5C5C5C;
  font-weight:500;
}
.success-icon{
  width: 40px;
  height: 40px;
  margin-left:36px ;

}
</style>