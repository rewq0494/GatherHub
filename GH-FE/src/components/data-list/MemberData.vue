
<!-- 第二版有排序 -->
<template>
    <div >
        <table class="thead-table">
            <thead>
                <tr>
                    <th @click="sortBy('company')" :class="{ active: sortKey === 'company' }">公司
                    <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('name')" :class="{ active: sortKey === 'name' }">姓名
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('phone')" :class="{ active: sortKey === 'phone' }">電話
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('email')" :class="{ active: sortKey === 'email' }">信箱
                        <span class="arrow" :class="{ 'asc': sortKey === 'company' && sortOrders[sortKey] === 1, 'dsc': sortKey === 'company' && sortOrders[sortKey] === -1 }"></span></th>
                    <th @click="sortBy('address')" :class="{ active: sortKey === 'address' }">地址</th>
                    <th>編輯</th>
                    <th>刪除</th>
                </tr>
            </thead>
        </table>
        <table class="tbody-table">
            <tbody>
                <tr v-for="member in filteredMembers" :key="member.id">
                    <td>{{ member.company }}</td>
                    <td>{{ member.name }}</td>
                    <td>{{ member.phone }}</td>
                    <td>{{ member.email }}</td>
                    <td>{{ member.address }}</td>
                    <!-- <td><button @click="openEditDialog"><img class="edit-icon" src="../../assets/list-icon/edit.png"></button></td> -->
                    <td><EditMbButton/></td>
                    <td><DeleteMbButton/></td>
                    <!-- <td><button><img class="delete-icon" src="../../assets/list-icon/delete.png"></button></td> -->
                </tr>
            </tbody>
        </table>
    </div>
</template>
  
<script>
  import EditMbButton from '../button/EditMbButton.vue';
  import DeleteMbButton from '../button/DeleteMbButton.vue';
  export default {
    props: {
    filterKey: String,
  },
  components:{
    EditMbButton,
    DeleteMbButton,
  },
    data() {
      return {
        members: [
          {
            company: '迪士尼有限公司',
            name: '米奇',
            phone: '123-456-7890',
            email: 'john@example.com',
            address: '桃園市桃園區中正路300號'
          },
          {
            company: '皮克斯有限公司',
            name: '毛怪',
            phone: '523-456-7890',
            email: 'john@example.com',
            address: '台南市中西區民族路155號'
          },
          {
            company: '幼幼有限公司',
            name: '屁屁偵探',
            phone: '123-456-7890',
            email: 'ejohn@example.com',
            address: '台北市信義區信義路五段7號89樓'
          },
          {
            company: '默默有限公司',
            name: '波利',
            phone: '04-555-5555',
            email: 'happy@example.com',
            address: '新竹'
          },
          {
            company: '東森有限公司',
            name: '米妮',
            phone: '123-456-7890',
            email: 'john@example.com',
            address: '花蓮'
          },
          {
            company: 'GTV有限公司',
            name: '安寶',
            phone: '123-456-2590',
            email: 'ajohn@example.com',
            address: '屏東'
          },
          {
            company: '緯來有限公司',
            name: '阿奇',
            phone: '123-456-7890',
            email: 'john@example.com',
            address: '台北市文山區新光路2號'
          },
          {
            company: 'HBO有限公司',
            name: '獅子丸',
            phone: '123-456-7890',
            email: 'jowhn@example.com',
            address: '台中市南區工業區一路3號'
          },
          {
            company: '緯來有限公司',
            name: '阿奇',
            phone: '123-456-7890',
            email: 'john@example.com',
            address: '高雄市左營區博愛二路757號'
          },
          {
            company: 'HBO有限公司',
            name: '獅子丸',
            phone: '123-456-7890',
            email: 'jowhn@example.com',
            address: '台東'
          },
          // {
          //   company: '資展國際有限公司',
          //   name: '郭哲偉',
          //   phone: '04-5489-4321',
          //   email: 'abcd1234@gmail.com',
          //   address: '台中市南屯區文心南三路47號'
          // }
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
    width: 20%;
    }
  
  .thead-table th:nth-child(2) {
    width: 10%;
  }
  .thead-table th:nth-child(3) {
    width: 15%;
  }
  
  .thead-table th:nth-child(4) {
    width: 18%;
  }
  .thead-table th:nth-child(5) {
    width: 26%;
  }
  
  .thead-table th:nth-child(6) {
    width: 5%;
    text-align: center;
  }
  .thead-table th:nth-child(7) {
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
    /* border:1px solid #FFE4D0;
    border-collapse: separate;
    border-spacing: 5px;
    box-shadow: 1px 1px 2px rgba(139, 104, 54, 0.079); */
  }
  .tbody-table td:nth-child(1) {
    width: 20%;
  }
  
  .tbody-table td:nth-child(2) {
    width: 12%;
  }
  .tbody-table td:nth-child(3) {
    width: 15%;
  }
  
  .tbody-table td:nth-child(4) {
    width: 20%;
  }
  .tbody-table td:nth-child(5) {
    width: 27%;
  }
  
  .tbody-table td:nth-child(6) {
    width: 3%;
    text-align: center;
  }
  .tbody-table td:nth-child(7) {
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
   
