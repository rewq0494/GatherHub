<template>
  <div>
    <button type="button" class="info-btn" @click="openDialog">{{ buttonText }}</button>
    <div v-if="showDialog">
      <dialog-box :tradeNo="tradeNo" @close="closeDialog" @edit="openEditOrderDialog" />
    </div>
    <edit-order-dialog v-if="showEditOrderDialog" @close="closeDialog" @confirm="openSuccessDialog" />
    <edit-success-dialog v-if="showSuccessDialog" @close="closeSuccessDialog" @confirm="editOrderDialog" />
  </div>
</template>

<script>
import OrderDialog from '../dialog/OrderDialog.vue';
import EditOrderDialog from '../dialog/EditOrderDialog.vue';
import EditSuccessDialog from '../dialog/EditSuccessDialog.vue';

export default {
  emits: ['edit', 'close'],
  components: {
    'dialog-box': OrderDialog,
    'edit-order-dialog': EditOrderDialog,
    'edit-success-dialog': EditSuccessDialog,
  },
  props: {
    tradeNo: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      showDialog: false,
      showSuccessDialog: false,
      showEditOrderDialog: false,
    };
  },

  computed: {
    buttonText() {
      return '詳細資訊';
    }
  },
  methods: {
    openDialog(tradeNo) {
      console.log('按鈕反應', tradeNo);
      this.showDialog = true;
    },
    closeDialog() {
      this.showDialog = false;
    },
    openSuccessDialog() {
      this.showDialog = false;
      this.showEditOrderDialog = false;
      this.showSuccessDialog = true;
      setTimeout(() => {
        this.closeSuccessDialog();
      }, 1200);
    },
    closeSuccessDialog() {
      this.showSuccessDialog = false;
    },
    openEditOrderDialog() {
      this.showDialog = false;
      this.showEditOrderDialog = true;
    },
  },
};
</script>

  
<style  scoped>
button {
  color: #fff;
  width: 90px;
  height: 25px;
  border: 0px;
  border-radius: 20px;
  background-color: #F8B470;
  cursor: pointer;
}
</style>