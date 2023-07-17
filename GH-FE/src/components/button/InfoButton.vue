<template>
    <div>
      <button type="button" class="info-btn" @click="openDialog">詳細資訊
      </button>
      <div v-if="showEditMbDialog">
        <dialog-box @close="closeDialog" @confirm="openSuccessDialog" />
      </div>
      <edit-success-dialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
    </div>
  </template>
  
  <script>
  import EditMemberDialog from '../dialog/EditMemberDialog.vue';
  import EditSuccessDialog from '../dialog/EditSuccessDialog.vue';
  
  export default {
    components: {
      'dialog-box': EditMemberDialog,
      'edit-success-dialog': EditSuccessDialog,
    },
    data() {
      return {
        showDialog: false,
        showSuccessDialog: false,
        showEditMbDialog: false,
      };
    },
    methods: {
      openDialog() {
        console.log('按鈕反應');
        this.showEditMbDialog = true;
      },
      closeDialog() {
        this.showEditMbDialog = false;
      },
      openSuccessDialog() {
        this.showEditMbDialog = false;
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
   
     button{
        color: #fff;
        width: 90px;
        height: 25px;
        border: 0px;
        border-radius: 20px;
        background-color:#F8B470 ;
        cursor: pointer;
     }
    </style>