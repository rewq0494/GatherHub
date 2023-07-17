<!-- 新稱會員資訊 -->
<template>
  <div>
    <button type="button" class="add-btn" @click="openDialog">
      <p>新增</p>
      <img class="icon-add" src="../../assets/button-icon/add.png">
    </button>
    <div v-if="showDialog">
      <dialog-box @close="closeDialog" @confirm="openSuccessDialog" />
    </div>
    <add-success-dialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
  </div>
</template>

<script>
import AddMemberDialog from '../dialog/AddMemberDialog.vue';
import AddSuccessDialog from '../dialog/AddSuccessDialog.vue';

export default {
  components: {
    'dialog-box': AddMemberDialog,
    'add-success-dialog': AddSuccessDialog,
  },
  data() {
    return {
      showDialog: false,
      showSuccessDialog: false,
    };
  },
  methods: {
    openDialog() {
      console.log('按鈕反應');
      this.showDialog = true;
    },
    closeDialog() {
      this.showDialog = false;
    },
    openSuccessDialog() {
      this.showDialog = false;
      this.showSuccessDialog = true;
      setTimeout(() => {
        this.closeSuccessDialog();
      }, 1200);
    },
    closeSuccessDialog() {
      this.showSuccessDialog = false;
    },
  },
};
</script>

  <style  scoped>
 
  .add-btn{
    font-size: 14px;
      width: 90px;
      height: 36px;
      position: fixed;
      right: 18%;
      top: 12%;
      background: #FBF8F8;
      border: 1px solid #A4947C;
      color: #A4947C;
      border-radius: 20px;
      cursor: pointer;
      display: flex;
  align-items: center;
  }
  .add-btn:hover{
    background-color: #ffffff;
    border: 0.5px solid #d2c6b4;
    transition: background-color 0.3s;
    transition: border 0.3s;
  }
  .add-btn:active{
    background-color: #eee9e4;
    border: 0.5px solid #d2c6b4;
    /* background-color: #FBF8F8;
    border: 0.5px solid #d2c6b4; */
    transition: background-color 1s;
    transition: border 0.3s;
  }

  .add-btn p{
    display: inline;
    margin-top: 16px;
    margin-left: 10px;
  }


  
  .icon-add{
      width: 18px;
      height: 18px;
      margin-top: 1px;
      margin-left: 9px;
  }
  </style>