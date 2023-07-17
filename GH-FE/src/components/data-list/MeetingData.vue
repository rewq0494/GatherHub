
<!-- 第二版有排序 -->
<template>
  <div>
    <table class="thead-table">
      <thead>
        <tr>
          <th @click="sortBy('tradeNo')" :class="{ active: sortKey === 'tradeNo' }">訂單編號
            <span class="arrow"
              :class="{ 'asc': sortKey === 'tradeNo' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'tradeNo' && sortOrders[sortKey] === -1 }"></span>
          </th>
          <th @click="sortBy('rentalDate')" :class="{ active: sortKey === 'rentalDate' }">日期
            <span class="arrow"
              :class="{ 'asc': sortKey === 'rentalDate' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'rentalDate' && sortOrders[sortKey] === -1 }"></span>
          </th>
          <th @click="sortBy('rentalTime')" :class="{ active: sortKey === 'rentalTime' }">時間
            <span class="arrow"
              :class="{ 'asc': sortKey === 'rentalTime' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'rentalTime' && sortOrders[sortKey] === -1 }"></span>
          </th>
          <th @click="sortBy('activityName')" :class="{ active: sortKey === 'activityName' }">活動名稱
            <span class="arrow"
              :class="{ 'asc': sortKey === 'activityName' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'activityName' && sortOrders[sortKey] === -1 }"></span>
          </th>
          <th @click="sortBy('meetingroomId')" :class="{ active: sortKey === 'meetingroomId' }">場地
            <span class="arrow"
              :class="{ 'asc': sortKey === 'meetingroomId' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'meetingroomId' && sortOrders[sortKey] === -1 }"></span>
          </th>
          <th @click="sortBy('memberName')" :class="{ active: sortKey === 'memberName' }">聯絡人
            <span class="arrow"
              :class="{ 'asc': sortKey === 'memberName' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'memberName' && sortOrders[sortKey] === -1 }"></span>
          </th>
          <th></th>
        </tr>
      </thead>
    </table>
    <table class="tbody-table">
      <tbody>
        <tr v-for="order in filteredOrders" :key="order.tradeNo">
          <td>{{ order.tradeNo }}</td>
          <td>{{ formatRentalDate(order.rentalDate) }}</td>
          <td>{{ order.rentalTime }}</td>
          <td>{{ order.activityName }}</td>
          <td>{{ order.meetingroomId }}</td>
          <td>{{ order.memberName }}</td>
          <td>
            <OrderInfoButton :tradeNo="order.tradeNo" />
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import OrderInfoButton from '../button/OrderInfoButton.vue';
import moment from 'moment';

export default {
  components: {
    OrderInfoButton,
  },
  props: {
    data: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      sortKey: '',
      sortOrders: {
        tradeNo: 1,
        rentalDate: 1,
        rentalTime: 1,
        activityName: 1,
        meetingroomId: 1,
        memberName: 1,
      },
    };
  },
  computed: {
    filteredOrders() {
      return this.data.slice().sort((a, b) => {
        const sortMultiplier = this.sortOrders[this.sortKey] > 0 ? 1 : -1;
        const valueA = a[this.sortKey];
        const valueB = b[this.sortKey];

        if (typeof valueA === 'string') {
          return valueA.localeCompare(valueB) * sortMultiplier;
        } else {
          return (valueA - valueB) * sortMultiplier;
        }
      });
    },
  },
  methods: {
    sortBy(key) {
      this.sortKey = key;
      this.sortOrders[key] = this.sortOrders[key] === 1 ? -1 : 1;
    },
    formatRentalDate(date) {
      const formattedDate = moment(date).format('YYYY-MM-DD');
      return formattedDate;
    }

  },
}
</script>
  
<style scoped>
  .thead-table{
    background-color: #373633;
    height: 50px;
    position: fixed;
    right: 5%;
    top: 18%;
    width: 74%;
    height: 7%;
    border-radius: 20px 20px 0 0;
    text-align: center;
    border-collapse: collapse;
    border-spacing: 0;
  }
  .tbody-table{
    background-color: #FDF4E6;
    text-align: center;
    position: fixed;
    right: 5%;
    top: 25%;
    width: 74%;
    max-height: 500px;
    overflow-y: overlay;; 
    display: block;
    /* border-collapse: separate; 使用独立的边框模型 */
  }

  th {
    font-size: 16px;
    font-family: '微軟正黑體';
    /* border-radius: 10px; */
    color: #FFE4D0;
    cursor: pointer;
   }

    th:first-child {
    border-top-left-radius: 10px;
    }

    th:last-child {
    border-top-right-radius: 10px;
    }
    .thead-table th:nth-child(1) {
    width: 8%;
    }
  
  .thead-table th:nth-child(2) {
    width: 16%;
  }
  .thead-table th:nth-child(3) {
    width: 12%;
  }
  
  .thead-table th:nth-child(4) {
    width: 22%;
  }
  .thead-table th:nth-child(5) {
    width: 13%;
  }
  .thead-table th:nth-child(6) {
    width: 11%;
  }
  
  .thead-table th:nth-child(7) {
    width: 16%;
    text-align: center;
  }


  
  .tbody-table td {
    font-size: 14px;
    color: #706D6C;
    font-family: '微軟正黑體';
    height: 10px; /* 添加行高样式 */
    padding-left: 10px;
    min-width: 40px;
    text-align: left;
  }
  .tbody-table td:nth-child(1) {
    width: 2%;
  }

  .tbody-table td:nth-child(2) {
    width: 7%;
  }
  .tbody-table td:nth-child(3) {
    width: 5%;
  }
  
  .tbody-table td:nth-child(4) {
    width: 10%;
  }
  .tbody-table td:nth-child(5) {
    width: 4%;
  }
  .tbody-table td:nth-child(6) {
    width: 4%;
  }
  
  .tbody-table td:nth-child(7) {
    width: 4%;
    text-align: center;
    /* padding-right: 2px ; */
  }
  
  tr {
    height: 56px;
    box-shadow: 0px 1px 1px rgba(221, 185, 136, 0.538);
  }
  tr:first-child {
  border-top: none;
  }
 button{
  border: 0px;
  background-color:#FDF4E6 ;
  cursor: pointer;
 }
  
  .edit-icon {
    width: 20px;
    height: 20px;
  }
  .delete-icon {
    width: 20px;
    height: 20px;
  }

  .arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 1;
 }

.arrow.asc {
  border-left: 4px solid transpaspace;
  border-right: 4px solid transpaspace;
  border-bottom: 4px solid #9e5a5a;
 }

.arrow.dsc {
  border-left: 4px solid transpaspace;
  border-right: 4px solid transpaspace;
  border-top: 4px solid #a44a4a;
 }

/* 設置整個滾動條的寬度和高度 */
::-webkit-scrollbar {
width: 7px;
background-color: rgba(98, 83, 65, 0.4);

}

/* 滾動條的按鈕部分（上下箭頭按鈕） */
::-webkit-scrollbar-button {
background: transpaspace;
border-radius: 4px;
height: 0px;
}

/* 動條軌道的樣式 */
::-webkit-scrollbar-track-piece {
background: transpaspace;
}

/* 滾動條滑塊的樣式 */
::-webkit-scrollbar-thumb {
border-radius: 4px;
background-color: rgba(83, 60, 34, 0.4);
} 
</style> 
   
