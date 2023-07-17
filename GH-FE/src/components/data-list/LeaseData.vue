
<!-- 第二版有排序 -->
<template>
    <div >
        <table class="thead-table">
            <thead>
                <tr>
                  <th @click="sortBy('office')" :class="{ active: sortKey === 'name' }">辦公室
                      <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('company')" :class="{ active: sortKey === 'company' }">公司
                    <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('startDate')" :class="{ active: sortKey === 'startDate' }">起租日期
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('endDate')" :class="{ active: sortKey === 'endDate' }">約期
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('rent')" :class="{ active: sortKey === 'rent' }">租金
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('status')" :class="{ active: sortKey === 'status' }">繳納狀態</th>
                    <th></th>
                </tr>
            </thead>
        </table>
        <table class="tbody-table">
            <tbody>
                <tr v-for="member in filteredMembers" :key="member.id">
                    <td>{{ member.office }}</td>
                    <td>{{ member.company }}</td>
                    <td>{{ member.startDate }}</td>
                    <td>{{ member.endDate }}</td>
                    <td>{{ member.rent }}</td>
                    <td>{{ member.status }}</td>
                    <td> <component :is="getButtonComponent(member)"/></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
  
<script>
  import InfoButton from '../button/InfoButton.vue';
  import AddInfoButton from '../button/AddInfoButton.vue';
  export default {
    props: {
    filterKey: String,
  },
  components:{
    InfoButton,
    AddInfoButton,
  },
    data() {
      return {
        members: [
        {
          "office": "A206",
          "company": "迪士尼有限公司",
          "startDate": "2021/09/17",
          "endDate": "一年",
          "rent": "$17000",
          "status": "租金已繳"
        },
        {
          "office": "B102",
          "company": "微軟有限公司",
          "startDate": "2021/01/01", 
          "endDate": "一年",
          "rent": "$15000",
          "status": "租金已繳"
        },
        {
          "office": "C304",
          "company": "亞馬遜企業",
          "startDate": "2021/02/15", 
          "endDate": "二年",
          "rent": "$18000",
          "status": "尚未繳納"
        },
        {
          "office": "D501",
          "company": "華碩有限公司",
          "startDate": "2021/03/10", 
          "endDate": "六個月",
          "rent": "$20000",
          "status": "租金已繳"
        },
        {
          "office": "E202",
          "company": "河堤國際商旅",
          "startDate": "2021/04/20",
          "endDate": "六個月",
          "rent": "$17000",
          "status": "尚未繳納"
        },
        {
          "office": "F403",
          "company": "凱悅國際股份有限公司",
          "startDate": "2021/05/05", 
          "endDate": "一年",
          "rent": "$15000",
          "status": "租金已繳"
        },
        {
          "office": "G601",
          "company": "IHG國際有限公司",
          "startDate": "2021/06/15", 
          "endDate": "二年",
          "rent": "$18000",
          "status": "租金已繳"
        },
        {
          "office": "H304",
          "company": "勝瑋科技股份有限公司",
          "startDate": "2021/07/25", 
          "endDate": "一年",
          "rent": "$20000",
          "status": "尚未繳納"
        },
        {
          "office": "I505",
          "company": "資展國際有限公司",
          "startDate": "2023/07/10", 
          "endDate": "一年",
          "rent": "$10700",
          "status": "本月已繳"
        },
        {
          "office": "H304",
          "company": "勝瑋科技股份有限公司",
          "startDate": "2021/09/18", 
          "endDate": "六個月",
          "rent": "$20000",
          "status": "尚未繳納"
        },
        {
          "office": "I505",
          "company": "光泉股份有限公司",
          "startDate": "2021/10/30", 
          "endDate": "六個月",
          "rent": "$17000",
          "status": "租金已繳"
        }
      ],
        sortKey: '',
        sortOrders: {
            company: 1,
            name: 1,
            phone: 1,
            email: 1,
            address: 1
        },
        searchQuery: ''
      };
    },
    computed: {
    filteredMembers() {
      const filterKey = this.filterKey.toLowerCase();
      let data = this.members;

      if (filterKey) {
        data = data.filter((row) => {
          return Object.keys(row).some((key) => {
            return String(row[key]).toLowerCase().includes(filterKey);
          });
        });
      }

      if (this.sortKey) {
        const sortKey = this.sortKey;
        const sortMultiplier = this.sortOrders[sortKey] > 0 ? 1 : -1;
        data = data.slice().sort((a, b) => {
          const valueA = a[sortKey];
          const valueB = b[sortKey];

          if (typeof valueA === 'string') {
            return valueA.localeCompare(valueB) * sortMultiplier;
          } else {
            return (valueA - valueB) * sortMultiplier;
          }
        });
      }

      return data;
    }
  },
  methods: {
    sortBy(key) {
      this.sortKey = key;
      this.sortOrders[key] = this.sortOrders[key] === 1 ? -1 : 1;
    },
    getButtonComponent(member) {
      if (this.isEmpty(member.company) || this.isEmpty(member.office) || this.isEmpty(member.startDate)|| this.isEmpty(member.endDate) || this.isEmpty(member.rent) || this.isEmpty(member.status)) {
        return 'AddInfoButton';
      } else {
        return 'InfoButton';
      }
    },
    isEmpty(value) {
      return value === null || value === undefined || value === '';
    },
  }
};
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
    width: 10%;
    }
  
  .thead-table th:nth-child(2) {
    width: 21%;
  }
  .thead-table th:nth-child(3) {
    width: 14%;
  }
  
  .thead-table th:nth-child(4) {
    width: 16%;
  }
  .thead-table th:nth-child(5) {
    width: 12%;
  }
  .thead-table th:nth-child(6) {
    width: 10%;
  }
  
  .thead-table th:nth-child(7) {
    width: 18%;
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
    width: 4%;
  }
  
  .tbody-table td:nth-child(2) {
    width: 10%;
  }
  .tbody-table td:nth-child(3) {
    width: 5%;
  }
  
  .tbody-table td:nth-child(4) {
    width: 5%;
  }
  .tbody-table td:nth-child(5) {
    width: 5%;
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
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #9e5a5a;
 }

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #a44a4a;
 }

/* 設置整個滾動條的寬度和高度 */
::-webkit-scrollbar {
width: 7px;
background-color: rgba(98, 83, 65, 0.4);

}

/* 滾動條的按鈕部分（上下箭頭按鈕） */
::-webkit-scrollbar-button {
background: transparent;
border-radius: 4px;
height: 0px;
}

/* 動條軌道的樣式 */
::-webkit-scrollbar-track-piece {
background: transparent;
}

/* 滾動條滑塊的樣式 */
::-webkit-scrollbar-thumb {
border-radius: 4px;
background-color: rgba(83, 60, 34, 0.4);
} 
</style> 
   
