<template>
  <div>
    <button type="button" class="info-btn" @click="openDialog">新增資訊</button>
    <div v-if="showAddLeaseDialog">
      <dialog-box @close="closeDialog" @confirm="openSuccessDialog" />
    </div>
    <add-success-dialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
  </div>
</template>

<script>
import AddLeaseDialog from '../dialog/AddLeaseDialog.vue';
import AddSuccessDialog from '../dialog/AddSuccessDialog.vue';

export default {
  components: {
    'dialog-box': AddLeaseDialog,
    'add-success-dialog': AddSuccessDialog,
  },
  data() {
    return {
      showAddLeaseDialog: false,
      showSuccessDialog: false,
    };
  },
  methods: {
    openDialog() {
      console.log('按鈕反應');
      this.showAddLeaseDialog = true;
    },
    closeDialog() {
      this.showAddLeaseDialog = false;
    },
    openSuccessDialog() {
      this.showAddLeaseDialog = false;
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
        background-color:#59B462 ;
        cursor: pointer;
     }
    </style>