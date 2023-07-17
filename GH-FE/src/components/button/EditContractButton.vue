<template>
    <div>
      <button type="button" class="edit-btn" @click="openDialog">
        <img class="edit-icon" src="../../assets/list-icon/edit.png">
      </button>
      <div v-if="showEditContractDialog">
        <dialog-box @close="closeDialog" @confirm="openSuccessDialog" />
      </div>
      <edit-success-dialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
    </div>
  </template>
  
  <script>
  import EditContractDialog from '../dialog/EditContractDialog.vue';
  import EditSuccessDialog from '../dialog/EditSuccessDialog.vue';
  
  export default {
    components: {
      'dialog-box': EditContractDialog,
      'edit-success-dialog': EditSuccessDialog,
    },
    data() {
      return {
        showDialog: false,
        showSuccessDialog: false,
        showEditContractDialog: false,
      };
    },
    methods: {
      openDialog() {
        console.log('按鈕反應');
        this.showEditContractDialog = true;
      },
      closeDialog() {
        this.showEditContractDialog = false;
      },
      openSuccessDialog() {
        this.showEditContractDialog = false;
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
        border: 0px;
        background-color:#FDF4E6 ;
        cursor: pointer;
 }
    .edit-icon{
        width: 20px;
        height: 20px;
        margin-left: -3px;
    }
    </style>