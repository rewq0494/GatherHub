<template>
  <div class="overlay"></div>
  <div class="add-order-dialog">
    <h2>新增訂單</h2>
    <div class="add-area">
      <!-- <label>
        <h3>訂單編號</h3>
        <input class="add-box" type="text" v-model="tradeNo" ref="tradeNoInput">
      </label> -->
      <label>
        <h3>教室</h3>
        <select class="add-box" v-model="meetingroomId" ref="meetingroomIdInput">
          <option value="MR001">20人會議教室</option>
          <option value="MR002">30人會議教室</option>
          <option value="MR003">50人會議教室</option>
        </select>
      </label>
      <label>
        <h3>日期</h3>
        <vue-flatpickr v-model="rentalDate" ref="rentalDateInput"></vue-flatpickr>
      </label>
      <label>
        <h3>時段</h3>
        <select class="add-box" v-model="rentalTime" ref="rentalTimeInput">
          <option value="09:00-12:00">09:00-12:00</option>
          <option value="12:00-15:00">12:00-15:00</option>
          <option value="15:00-18:00">15:00-18:00</option>
        </select>
      </label>
      <label>
        <h3>活動名稱</h3>
        <input class="add-box" type="text" v-model="activityName" ref="activityNameInput">
      </label>
      <label>
        <h3>電話</h3>
        <input class="add-box" type="text" v-model="memberPhone" @blur="fetchContactInfo" ref="memberPhoneInput">
      </label>
      <label>
        <h3 id="note-h3">備註</h3>
        <input class="add-box" id="note-box" type="text" v-model="remark" ref="remarkInput">
      </label>
    </div>

    <button class="btn-close" @click="closeDialog">取消</button>
    <button class="btn-confirm" @click="handleConfirm">確定</button>
  </div>
  <AddSuccessDialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
</template>

<script>
import AddSuccessDialog from './AddSuccessDialog.vue';
import VueFlatpickr from 'vue-flatpickr-component';
import 'flatpickr/dist/flatpickr.css';
import flatpickr from 'flatpickr';
import { onMounted } from 'vue';
import axios from 'axios';

export default {
  emits: ['close', 'confirm'],
  components: {
    AddSuccessDialog,
    VueFlatpickr
  },
  data() {
    return {
      showDialog: false,
      showSuccessDialog: false,
      tradeNo: '', // 新增的訂單編號屬性
      meetingroomId: '',
      rentalDate: null,
      rentalTime: '',
      activityName: '',
      memberName: '',
      memberPhone: '',
      memberEmail: '',
      companyName: '',
      companyTaxid: '',
      remark: ''
    };
  },
  methods: {
    closeDialog() {
      this.$emit('close');
    },
    handleConfirm() {
      const data = {
        tradeNo: this.tradeNo,
        meetingroomId: this.meetingroomId,
        rentalDate: this.rentalDate,
        rentalTime: this.rentalTime,
        activityName: this.activityName,
        memberName: this.memberName,
        memberPhone: this.memberPhone,
        memberEmail: this.memberEmail,
        companyName: this.companyName,
        companyTaxid: this.companyTaxid,
        remark: this.remark
      };

      axios
        .post('http://localhost:8080/meetings/insert', data)
        .then(response => {
          console.log('新增成功', response.data);
          this.$emit('confirm');
          this.showSuccessDialog = true;
          setTimeout(() => {
            location.reload(); // 在這裡重新載入畫面
          }, 1000); // 延遲三秒後執行重新載入畫面
        })
        .catch(error => {
          console.error('新增失敗', error);
        });
    },

    fetchContactInfo() {
      const phoneNumber = this.memberPhone;

      // 使用適當的 API 端點和參數來查詢聯絡人資訊
      axios
        .get(`http://localhost:8080/booking/profile/${phoneNumber}`)
        .then(response => {
          const contactInfo = response.data;
          this.memberName = contactInfo.memberName;
          this.memberEmail = contactInfo.memberEmail;
          this.companyName = contactInfo.company.companyName;
          this.companyTaxid = contactInfo.company.companyTaxId;
        })
        .catch(error => {
          console.error('查詢聯絡人資訊失敗', error);
        });
    }
  },
  mounted() {
    onMounted(() => {
      flatpickr(this.$refs.rentalDateInput, {
        monthSelectorType: 'long'
        // 其他Flatpickr的配置選項
      });
    });
    // 在 mounted 鉤子函數中引入 confetti.css 主題樣式表
    require('flatpickr/dist/themes/confetti.css');
  }
};
</script>




<style scoped>
* {
  font-family: '微軟正黑體';
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  /* 设置半透明的黑色背景 */
  z-index: 9999;
  /* 确保遮罩层在其他内容之上 */
}

.add-order-dialog {
  width: 800px;
  height: 500px;
  ;
  background-color: #ffffff;
  position: fixed;
  z-index: 99999;
  top: 18%;
  left: 25%;
  border-radius: 20px;
}

.btn-close {
  position: absolute;
  left: 42%;
  bottom: 6%;
  width: 60px;
  height: 38px;
  color: #FFF;
  background-color: #F7AF44;
  border-radius: 40px;
  border: 0px;
  cursor: pointer;
}

.btn-close:hover {
  background-color: #ef9817;
  transition: background-color 0.8s;
}

.btn-confirm {
  position: absolute;
  left: 51%;
  bottom: 6%;
  width: 60px;
  height: 38px;
  color: #FFF;
  background-color: #F7AF44;
  border-radius: 40px;
  border: 0px;
  cursor: pointer;
}

.btn-confirm:hover {
  background-color: #ef9817;
  transition: background-color 0.8s;
}

.add-order-dialog h2 {
  position: relative;
  top: 30px;
  text-align: center;
  color: #5C5C5C;
  font-weight: 500;
}

.add-area {
  position: relative;
  top: 60px;
  left: 30px;
}


.add-order-dialog label {
  display: flex;
  /* align-items: center; */
  margin-bottom: 3px;
  height: 40px;
}

.add-order-dialog h3 {
  font-size: 16px;
  position: relative;
  top: -5px;
  left: 30px;
  text-align: center;
  color: #777777;
}

.add-box {
  position: absolute;
  background-color: #FFF0DE;
  width: 220px;
  height: 33px;
  left: 115px;
  border-radius: 10px;
  border: 0px;
  outline: none;
  color: #777777;
  font-size: 14px;
  padding-left: 10px;
}

#class-box {
  width: 232px;
  height: 35px;
}

#time-box {
  width: 232px;
  height: 35px;
}

#note-h3 {
  color: #777777;
  position: absolute;
  left: 390px;
  top: -10px;
}

#note-box {
  background-color: #FFF0DE;
  position: absolute;
  left: 430px;
  top: 0px;
  width: 280px;
  height: 130px;
  border-radius: 5px;
}

.deposit {
  display: flex;
  /* 使用弹性布局 */
  align-items: center;
  /* 垂直居中对齐 */
  text-align: left;
  font-size: 16px;
  position: absolute;
  top: 300px;
  right: 320px;
}

.deposit p {
  color: #D65151;
  position: relative;
  top: -5px;
  left: 75px;
}

.total {
  display: flex;
  /* 使用弹性布局 */
  align-items: center;
  /* 垂直居中对齐 */
  text-align: left;
  font-size: 16px;
  position: absolute;
  top: 330px;
  right: 320px;
}

.total p {
  color: #D65151;
  position: relative;
  left: 75px;
  top: -5px;
}

/* 日期選擇器 */
.flatpickr-input {
  position: absolute;
  background-color: #FFF0DE;
  width: 220px;
  height: 30px;
  left: 115px;
  border-radius: 10px;
  border: 0px;
  outline: none;
  padding-left: 10px;
  color: #777777;
}


.dayContainer {
  background-color: #f2eee9;
}

.flatpickr-input {
  border-radius: 10px;
}

.flatpickr-calendar.open {
  background-color: #d8d0c7;
  width: 100px;
}
</style>