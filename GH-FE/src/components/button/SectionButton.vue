<template>
  <div class="custom-select">
    <div class="select-box" @click="toggleOptions">
      <div class="selected-option">
        {{ selectedDepartment || '館別'  }}
      </div>
      <ul class="option-list" :class="{ 'show-options': showOptions }">
        <li v-for="department in departments" :key="department" @click="selectDepartment(department)">
          {{ department }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      departments: ['全部','一館', '二館', '三館', '四館', '五館'],
      selectedDepartment: '',
      showOptions: false
    };
  },
  methods: {
    toggleOptions() {
      this.showOptions = !this.showOptions;
    },
    selectDepartment(department) {
      this.selectedDepartment = department;
    },
    closeOptions() {
      this.showOptions = false;
    }
  }
};
</script>

<style scoped>
*{
  font-size: 14px;
}
.custom-select {
  position: fixed;
  right: 18%;
  top: 12.2%;
  z-index: 9999;

}

.select-box {
  width: 80px;
  height: 34px;
  border: 1px solid #A4947C;
  border-radius: 20px;
  cursor: pointer;
  background-color: #FFF;
}
.select-box:hover {
  background-color: #f4f4f4;
}

.selected-option {
  padding: 7px 22px;
  color: #A4947C;

}

.option-list {
  position: absolute;
  top: 65%;
  left: 0;
  width: 80px;
  max-height: 220px;
  overflow-y: auto;
  border: 0.5px solid #A4947C;
  border-top: none;
  border-radius: 10px 10px 20px 20px;
  background-color: #FFF;
  display: none;
  list-style-type: none;
  padding-left: 0;

}

.show-options {
  display: block;
  
}

.option-list li {
  padding: 5px 22px;
  color: #A4947C;
  cursor: pointer;
  height: 24px;
  /* margin-bottom: 5px; */
}

.option-list li:hover {
  background-color: #F0F0F0;
}
</style>
