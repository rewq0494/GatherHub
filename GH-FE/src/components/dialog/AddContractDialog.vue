<template>
  <div class="overlay"></div>
  <div class="add-contract-dialog">
    <h2>新增合約</h2>
    <div class="add-area">
      <label>
        <h3>辦公室
        </h3>
        <input class="add-box" type="text">
      </label>

      <label>
        <h3>統編</h3>
        <input class="add-box" type="text">
      </label>
      
      <label>
        <h3>電話</h3>
        <input class="add-box" type="text">
      </label>
      
      <label>
        <h3>付款方式</h3>
      <select class="add-box" id="select-box">
          <option value="A">現金</option>
          <option value="B">匯款</option>
          <option value="C">線上支付</option>
        </select>
      </label>

      <label>
        <h3>起租日期</h3>
        <!-- <input class="add-box" type="date"> -->
        <vue-flatpickr v-model="selectedDate"></vue-flatpickr>
      </label>

      <label>
        <h3>結束日期</h3>
        <!-- <input class="add-box" type="date"> -->
        <vue-flatpickr v-model="selectedDate"></vue-flatpickr>
      </label>

      <label class="note">
        <h3>備註</h3>
        <input class="add-box" type="text">
      </label>
      <UploadBox/>
    </div>
      
    <button class="btn-close" @click="closeDialog">取消</button>
    <button class="btn-confirm" @click="handleConfirm">確定</button>
  </div>
  <AddSuccessDialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
</template>

<script>
import UploadBox from '../box/UploadBox.vue';
import AddSuccessDialog from './AddSuccessDialog.vue';
import VueFlatpickr from 'vue-flatpickr-component';
import 'flatpickr/dist/flatpickr.css';
import flatpickr from 'flatpickr';
import {onMounted } from 'vue';

export default {
  
  emits: ['close', 'confirm'],
  components: {
    UploadBox,
    AddSuccessDialog,
    VueFlatpickr
  },
  data() {
    return {
      showDialog: false,
      showSuccessDialog: false,
      selectedDate: null,
      flatpickrConfig: {
        inline: true,}
    }
  },
  methods: {
    
    closeDialog() {
      this.$emit('close');
    },
    handleConfirm() {
  console.log('新增成功');
  this.$emit('confirm');
  this.showSuccessDialog = true;
},
  },
  mounted() {
    onMounted(() => {
    flatpickr(this.$refs.datePickerInput, {
      monthSelectorType: 'long'
      // 其他Flatpickr的配置選項
    });});
    // 在 mounted 鉤子函數中引入 dark.css 主題樣式表
    require("flatpickr/dist/themes/confetti.css");
    
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
.add-contract-dialog{
  width: 750px;
  height: 480px;;
  background-color: #ffffff;
  position: relative;
  z-index: 99999;
  top: 105px;
  left: 400px;
  border-radius: 20px;
}
.btn-close{
  position: absolute;
  left: 41%;
  bottom: 6%;
  width: 60px;
  height: 38px;
  color: #FFF;
  background-color: #F7AF44;
  border-radius: 40px;
  border: 0px;
  cursor: pointer;
}
.btn-close:hover{
  background-color: #ef9817;
  transition: background-color 0.8s;
}
.btn-confirm{
  position: absolute;
  left: 50%;
  bottom: 6%;
  width: 60px;
  height: 38px;
  color: #FFF;
  background-color: #F7AF44;
  border-radius: 40px;
  border: 0px;
  cursor: pointer;
}
.btn-confirm:hover{
  background-color: #ef9817;
  transition: background-color 0.8s;
}
.add-contract-dialog h2{
  position: relative;
  top: 30px;
  text-align: center;
  color: #5C5C5C;
  font-weight:500;
}
.add-area{
  position: relative;
  top: 30px;
}


.add-contract-dialog label {
  display: flex;
  /* align-items: center; */
  margin-bottom: 12px;
  height: 40px;
}

.add-contract-dialog h3{
  font-size: 16px;
  position: relative;
  top: -5px;
  left: 50px;
  text-align: center;
  color: #777777;
}
.add-box{
  position: absolute;
  background-color: #FFF0DE;
  width: 200px;
  height: 36px;
  left: 130px;
  border-radius: 10px;
  border: 0px;
  outline: none;
  color: #777777;
  font-size: 14px;
  padding-left: 10px;
}
#select-box{
  cursor: pointer;
  width: 210px;
  height: 38px;
}
.note{
  position: absolute;
  width: 200px;
  height: 38px;
  left: 340px;
  top:0px;
}
.note input{
  height:120px;
  width: 220px;
  left: 100px;
}


  /* 日期選擇器 */
  .flatpickr-input {
    position: absolute;
    background-color: #FFF0DE;
    width: 200px;
    height: 36px;
    left: 130px;
    border-radius: 10px;
    border: 0px;
    outline: none;
    padding-left: 10px;
}


.dayContainer{
  background-color: #f2eee9;
}

.flatpickr-input {
border-radius: 10px;
}
.flatpickr-calendar.open{
  background-color: #d8d0c7;
  width: 100px;
}
</style>