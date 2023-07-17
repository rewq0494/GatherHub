<template>
  <div class="overlay"></div>
  <div class="delete-mb-dialog">
    <img class="alert-icon" src="../../assets/dialog-icon/alert.png" >
    <h2>您確定要刪除嗎？</h2>
   
    <button class="btn-close" @click="closeDialog">取消</button>
    <button class="btn-confirm" @click="handleConfirm">確定</button>
  </div>
  <DeleteSuccessDialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
</template>

<script>
import DeleteSuccessDialog from './DeleteSuccessDialog.vue';

export default {
  emits: ['close', 'confirm'],
  components: {
    DeleteSuccessDialog
  },
  data() {
    return {
      showDialog: false,
      showSuccessDialog: false
    }
  },
  methods: {
    closeDialog() {
      this.$emit('close');
    },
    handleConfirm() {
  console.log('刪除成功');
  this.$emit('confirm');
  this.showSuccessDialog = true;
},
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
.delete-mb-dialog{
  width: 320px;
  height: 200px;;
  background-color: #ffffff;
  position: fixed;
  z-index: 99999;
  top: 30%;
  left: 40%;
  border-radius: 20px;
  display: flex;
  align-items: center;
}
.btn-close{
  position: absolute;
  left: 30%;
  bottom: 10%;
  width: 60px;
  height: 38px;
  color: #FFF;
  background-color: #C8C4BE;
  border-radius: 40px;
  border: 0px;
  cursor: pointer;
}
.btn-close:hover{
  background-color: #b5b2ad;
  transition: background-color 0.8s;
}
.btn-confirm{
  position: absolute;
  left: 52%;
  bottom: 10%;
  width: 60px;
  height: 38px;
  color: #FFF;
  background-color: #D54A4A;
  border-radius: 40px;
  border: 0px;
  cursor: pointer;
}
.btn-confirm:hover{
  background-color: #ca6565;
  transition: background-color 0.8s;
}
.delete-mb-dialog h2{
  position: relative;
  top:-12px;
  left: 20px;
  text-align: center;
  color: #5C5C5C;
  font-weight:500;
}
.alert-icon{
  width: 48px;
  height: 48px;
  margin-left: 10%;
  margin-top: -10%;
}
</style>