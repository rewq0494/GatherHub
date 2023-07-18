<template>
  <div class="overlay"></div>
  <div class="meetint-info-dialog">
    <h2>訂單資訊</h2>
    <button class="btn-close" @click="closeDialog">╳</button>
    <div class="info-area">
      <h3 id="od-number">訂單編號：{{ tradeNo }}</h3>
      <label v-for="(field, index) in fields" :key="index">
        <div :class="['h3-box', field.label === '備註' ? 'note-div' : '']">
          <h3 :class="field.label === '備註' ? 'note-h3-box' : ''">{{ field.label }}</h3>
        </div>
        <div :class="['data-box', field.label === '備註' ? 'note-box' : '']" v-if="!field.editing">{{ field.value }}</div>
        <input v-else type="text" v-model="field.inputValue"
          :class="['input-field', field.label === '備註' ? 'note-input' : '']" />
      </label>

      <div class="total">
        <h3>總額：</h3>
        <p>{{ total }}</p>
      </div>
    </div>
    <button v-if="!editing" class="btn-edit" @click="startEditing">修改訂單</button>
    <button v-else class="btn-confirm" @click="confirmEdit">確認修改</button>
    <button class="btn-cancle" @click="cancleOrder">取消訂單</button>
    <CancleOrderButton :tradeNo="tradeNo" />
    <EditSuccessDialog v-if="showSuccessDialog" @close="closeSuccessDialog" />
  </div>
</template>

<script>
import axios from 'axios';
import CancleOrderButton from '../button/CanaleOrderButton.vue';
import moment from 'moment';
import EditSuccessDialog from './EditSuccessDialog.vue';

export default {
  emits: ['close', 'confirm', 'edit'],
  components: {
    CancleOrderButton,
    EditSuccessDialog
  },
  props: {
    tradeNo: {
      type: String,
      required: true
    }
  },

  data() {
    return {
      note: '這裡是備註內容',
      total: '',
      showDialog: false,
      eventNameInput: '',
      editing: false,
      showSuccessDialog: false,
      fields: [
        {
          label: '日期',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '時間',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '場地',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '活動名稱',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '聯絡人',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '公司名稱',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '統編',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '電話',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '信箱',
          value: '',
          inputValue: '',
          editing: false
        },
        {
          label: '備註',
          value: '',
          inputValue: '',
          editing: false
        },
      ],
    };
  },
  methods: {

    closeDialog() {
      this.$emit('close');
    },
    closeSuccessDialog() {
      this.showSuccessDialog = false;
    },
    startEditing() {
      this.fields.forEach(field => {
        field.inputValue = field.value;
        field.editing = true;
      });
      this.editing = true;
      this.eventNameInput = this.eventName;
    },
    confirmEdit() {
      this.fields.forEach(field => {
        field.value = field.inputValue;
        field.editing = false;
      });
      this.eventName = this.eventNameInput;
      this.editing = false;

      this.$emit('confirm-with-name', this.eventName); // 觸發帶參數的confirm-with-name事件

      this.showSuccessDialog = true;
      setTimeout(() => {
        this.closeSuccessDialog();
      }, 1200);


      // 更新 API 請求
      const tradeNo = this.tradeNo;
      const updatedData = {
        rentalDate: this.fields[0].value,
        rentalTime: this.fields[1].value,
        meetingroomId: this.fields[2].value,
        activityName: this.fields[3].value,
        companyName: this.fields[5].value,
        companyTaxid: this.fields[6].value,
        memberName: this.fields[4].value,
        memberPhone: this.fields[7].value,
        memberEmail: this.fields[8].value,
        remark: this.fields[9].value,
        totalAmount: this.total
      };

      axios.put(`http://localhost:8080/meetings/update/${tradeNo}`, updatedData)
        .then(response => {
          // 成功處理更新回應
          console.log(response);
          // 可以執行一些成功更新後的操作
        })
        .catch(error => {
          // 處理更新失敗
          console.error(error);
        });
    },
    cancleOrder() {

    },
    fetchData() {
      const tradeNo = this.tradeNo;
      axios
        .get(`http://localhost:8080/meetings/details/${tradeNo}`)
        .then(response => {
          console.log(this.fetchData);
          const data = response.data;
          this.fields[0].value = moment(data.rentalDate).format('YYYY-MM-DD');
          this.fields[1].value = data.rentalTime;
          this.fields[2].value = data.meetingroomId;
          this.fields[3].value = data.activityName;
          this.fields[4].value = data.member.memberName;
          this.fields[5].value = data.company.companyName;
          this.fields[6].value = data.company.companyTaxId;
          this.fields[7].value = data.member.memberPhone;
          this.fields[8].value = data.member.memberEmail;
          this.fields[9].value = data.remark;
          this.total = data.totalAmount;
        })
        .catch(error => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.fetchData();
  },
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

.meetint-info-dialog {
  width: 920px;
  height: 600px;
  ;
  background-color: #ffffff;
  position: fixed;
  z-index: 99999;
  top: 9%;
  left: 20%;
  border-radius: 20px;
}

.btn-close {
  background-color: #ffffff;
  position: absolute;
  top: 10px;
  right: 10px;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  color: #949191;
  font-size: 20px;
  border: none;
  cursor: pointer;
}

.btn-close:hover {
  color: #676565;
  cursor: pointer;
}

.btn-cancle {
  position: absolute;
  right: 15%;
  bottom: 13%;
  width: 88px;
  height: 34px;
  color: #FFF;
  background-color: #D65151;
  border-radius: 15px;
  border: 0px;
  cursor: pointer;
}

.btn-cancle:hover {
  background-color: #ce6d6d;
  transition: background-color 0.8s;
}

.btn-edit {
  position: absolute;
  right: 15%;
  bottom: 20%;
  width: 88px;
  height: 34px;
  color: #FFF;
  background-color: #BCB0B0;
  border-radius: 15px;
  border: 0px;
  cursor: pointer;
}

.btn-edit:hover {
  background-color: #9c9191;
  transition: background-color 0.8s;
}

.btn-confirm {
  position: absolute;
  right: 15%;
  bottom: 20%;
  width: 88px;
  height: 34px;
  color: #FFF;
  background-color: #f9c06c;
  border-radius: 15px;
  border: 0px;
  cursor: pointer;
}

.btn-confirm:hover {
  background-color: #ffd9a0;
  transition: background-color 0.8s;
}

.meetint-info-dialog h2 {
  font-size: 26px;
  position: relative;
  top: 18px;
  text-align: center;
  color: #7D5F4F;
  font-weight: 500;
}

.info-area {
  position: relative;
  top: 36px;
}


.meetint-info-dialog label {
  display: flex;
  /* align-items: center; */
  margin-bottom: 2px;
  height: 40px;
}

.meetint-info-dialog h3 {
  font-size: 16px;
  font-weight: 600;
  position: relative;
  top: -10px;
  /* left: 80px; */
  text-align: center;
  color: #7d5f4fbe;
}

.data-box {
  text-align: left;
  position: absolute;
  width: 300px;
  height: 36px;
  left: 205px;
  border-radius: 10px;
  border: 0px;
  outline: none;
  color: #777777;
  font-size: 14px;
  padding-left: 10px;
  margin-top: 8px;
}

.h3-box {
  background-color: #FFF7EA;
  position: absolute;
  left: 110px;
  width: 100px;
  height: 35px;
  border-radius: 5px;
}

input {
  text-align: left;
  position: absolute;
  width: 200px;
  height: 30px;
  left: 200px;
  border-radius: 5px;
  color: #777777;
  font-size: 14px;
  padding-left: 10px;
  margin-left: 12px;
  outline: none;
  border: 0.5px solid #d1c7bf93;
  box-shadow: none;
}

.note-div {
  border: #7d5f4f59 solid 0.5px;
  background-color: #FFF;
  position: absolute;
  left: 500px;
  top: 50px;
  width: 300px;
  height: 150px;
  border-radius: 5px;
}

.note-h3-box {
  background-color: #FFF7EA;
  position: absolute;
  top: 0px;
  right: 0px;
  width: 300px;
  height: 35px;
  border-radius: 5px;
  margin-top: 10px;
}

.note-box {
  position: absolute;
  left: 500px;
  top: 90px;
  width: 300px;
  height: 150px;
  border-radius: 5px;
  color: #D65151;
}

.note-input {
  position: absolute;
  left: 500px;
  top: 87px;
  width: 287px;
  height: 110px;
  border-radius: 5px;
  color: #D65151;
  margin-left: 0px;
}

.deposit {
  display: flex;
  /* 使用弹性布局 */
  align-items: center;
  /* 垂直居中对齐 */
  text-align: left;
  font-size: 16px;
  position: absolute;
  top: 350px;
  right: 320px;
}

.deposit p {
  color: #D65151;
  position: relative;
  top: -10px;
}

.total {
  display: flex;
  /* 使用弹性布局 */
  align-items: center;
  /* 垂直居中对齐 */
  text-align: left;
  font-size: 16px;
  position: absolute;
  top: 380px;
  right: 320px;
}

.total p {
  color: #D65151;
  position: relative;
  top: -10px;
}

/* 訂單編號 */
#od-number {
  font-size: 18px;
  position: relative;
  left: -285px;
  top: 5px;
  color: #8B827B;
}
</style>