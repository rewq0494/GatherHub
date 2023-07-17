<template>
  <SidebarMenu/>
  <div class="title">合約管理</div>
  <AddContractButton />
  <SearchButton @search="updateSearchQuery" />
  <div class="main-section">
    <ContractData :filter-key="searchQuery" />
  </div>
  <AddMemberDialog v-if="showDialog" @close="closeDialog"/>
  <!-- <AddSuccessDialog @close="closeSuccessDialog" v-if="showSuccessDialog" /> -->
</template>

<script>
import SearchButton from '../components/button/SearchButton.vue';
import AddContractButton from '../components/button/AddContractButton.vue';
import ContractData from '../components/data-list/ContractData.vue';
import AddMemberDialog from '../components/dialog/AddMemberDialog.vue';
import SidebarMenu from '../components/SidebarMenu.vue'


export default {
name: 'MemberList',
components: {
  SearchButton,
  AddContractButton,
  ContractData,
  AddMemberDialog,
  SidebarMenu,

},
data() {
  return {
    showDialog: false,
    searchQuery: '',

  };
},
methods: {
  updateSearchQuery(searchTerm) {
    this.searchQuery = searchTerm;
  },
 
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