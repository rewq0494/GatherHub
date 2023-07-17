<template>
  <div>
    <SidebarMenu />
    <div class="title">會議教室</div>
    <AddOrderButton />
    <SearchButton @search="updateSearchQuery" />
    <div class="main-section">
      <MeetingData :data="filteredOrders" :sort-key="sortKey" :sort-orders="sortOrders" @sort-by-key="sortBy"
        :filter-key="searchQuery" />
    </div>
  </div>
  <AddMemberDialog v-if="showDialog" @close="closeDialog"/>
</template>

<script>
import SearchButton from '../components/button/SearchButton.vue';
import MeetingData from '../components/data-list/MeetingData.vue';
import SidebarMenu from '../components/SidebarMenu.vue'
import AddOrderButton from '../components/button/AddOrderButton.vue'
import axios from 'axios';

export default {
  name: 'MemberList',
  components: {
    SearchButton,
    MeetingData,
    SidebarMenu,
    AddOrderButton,
  },
  data() {
    return {
      orders: [], // 存儲會議數據
      filteredOrders: [], // 經過搜索和排序後的訂單數據
      searchQuery: '',
      sortKey: '',
      sortOrders: {
        tradeNo: 1,
        rentalDate: 1,
        rentalTime: 1,
        activityName: 1,
        meetingroomId: 1,
        memberName: 1,
      },
      showDialog: false,
    };
  },
  methods: {
    searchAllOrders() {
      axios
        .get('http://localhost:8080/meetings')
        .then((response) => {
          // 處理成功回應的訂單資料
          const orderData = response.data;
          const orders = orderData.map((order) => ({
            tradeNo: order.tradeNo,
            rentalDate: order.rentalDate,
            rentalTime: order.rentalTime,
            activityName: order.activityName,
            meetingroomId: order.meetingroomId,
            memberName: order.member.memberName,
          }));
          // 存儲訂單資料
          this.orders = orders;
          this.filteredOrders = orders;
        })
        .catch((error) => {
          // 處理錯誤
          console.error(error);
        });
    },
    updateSearchQuery(query) {
      this.searchQuery = query;
      this.filterOrders();
    },
    filterOrders() {
      const filterKey = this.searchQuery.toLowerCase();
      this.filteredOrders = this.orders.filter((row) => {
        return Object.keys(row).some((key) => {
          return String(row[key]).toLowerCase().includes(filterKey);
        });
      });
    },
    sortBy(key) {
      if (this.sortKey === key) {
        this.sortOrders[key] *= -1;
      } else {
        this.sortKey = key;
        this.sortOrders[key] = 1;
      }
    },
  },
  mounted() {
    this.searchAllOrders();
  },
};
</script>


<!-- ----------------------------------- -->
<style scoped>
.title{
  font-family: 微軟正黑體 ;
  color: #7D5F4F;
  font-size: 32px;
  font-weight: 500;
  position: fixed;
  right: 68%;
  top: 4%;
}
.main-section{
/* background-color: #FDF4E6; */
position: fixed;
right: 5%;
top: 18%;
width: 74%;
height: 100%;
border-radius: 20px;
}
.section-head{
background-color: #373633;
width: 100%;
height: 8%;
border-radius: 20px 20px 0 0;
display: flex;
justify-content: flex-start;
align-items: center;
}
.section-head p {
font-size: 16px;
margin-left: 50px;
margin-right: 70px;
color: #FFE4D0;
}
</style>