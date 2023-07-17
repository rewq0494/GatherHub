
<!-- 第二版有排序 -->
<template>
    <div >
        <table class="thead-table">
            <thead>
                <tr>
                    <th @click="sortBy('name')" :class="{ active: sortKey === 'name' }">姓名
                    <span class="arrow" :class="{ 'asc': sortKey === 'name' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'name' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('position')" :class="{ active: sortKey === 'position' }">職位
                        <span class="arrow" :class="{ 'asc': sortKey === 'position' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'position' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('email')" :class="{ active: sortKey === 'email' }">信箱
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('note')" :class="{ active: sortKey === 'note' }">備註
                        </th>
                    <th>編輯</th>
                    <th>刪除</th>
                </tr>
            </thead>
        </table>
        <table class="tbody-table">
            <tbody>
                <tr v-for="member in filteredMembers" :key="member.id">
                    <td>{{ member.name }}</td>
                    <td>{{ member.position }}</td>
                    <td>{{ member.email }}</td>
                    <td>{{ member.note }}</td>
                    <td><EditAccessButton/></td>
                    <td><DeleteMbButton/></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
  
<script>
  import EditAccessButton from '../button/EditAccessButton.vue';
  import DeleteMbButton from '../button/DeleteMbButton.vue';
  export default {
    props: {
    filterKey: String,
  },
  components:{
    EditAccessButton,
    DeleteMbButton,
  },
    data() {
      return {
        members: [
          {
            name: '米奇',
            position:'老闆',
            email: 'john@example.com',
            note: '',
          },
          {
            name: '毛怪',
            position:'老闆',
            email: 'john@example.com',
            note: '',
          },
          {
            name: '屁屁偵探',
            position:'營運長',
            email: 'ejohn@example.com',
            note: '',
          },
          {
            name: '波利',
            position:'經理',
            email: 'jfohn@example.com',
            note: '',
          },
          {
            name: '米妮',
            position:'會計',
            email: 'john@example.com',
            note: '123-456-7890',
          },
          {
            name: '安寶',
            position:'櫃台秘書',
            email: 'ajohn@example.com',
            note: '123-456-2590',
          },
          {
            name: '阿奇',
            position:'櫃台秘書',
            email: 'john@example.com',
            note: '123-456-7890',
          },
          {
            name: '獅子丸',
            position:'PT',
            email: 'jowhn@example.com',
            note: '123-456-7890',
          },
          {
            name: '阿奇',
            position:'櫃台秘書',
            email: 'john@example.com',
            note: '123-456-7890',
          },
          {
            name: '獅子丸',
            position:'櫃台秘書',
            email: 'jowhn@example.com',
            note: '123-456-7890',
          }
        ],
        sortKey: '',
        sortOrders: {
            name: 1,
            position:1,
            email: 1,
            note: 1,
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
    }
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
    width: 10%;
  }
  .thead-table th:nth-child(3) {
    width: 20%;
  }
  
  .thead-table th:nth-child(4) {
    width: 20%;
  }
  
  .thead-table th:nth-child(5) {
    width: 5%;
    text-align: center;
  }
  .thead-table th:nth-child(6) {
    width: 5%;
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
    width: 12%;
  }
  
  .tbody-table td:nth-child(2) {
    width: 12%;
  }
  .tbody-table td:nth-child(3) {
    width: 18%;
  }
  
  .tbody-table td:nth-child(4) {
    width: 18%;
  }
  
  .tbody-table td:nth-child(5) {
    width: 3%;
    text-align: center;
  }
  .tbody-table td:nth-child(6) {
    width: 3%;
    text-align: center;
    padding-right: 2px ;
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
   
