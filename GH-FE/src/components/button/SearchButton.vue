<template>
  <div class="search">
    <input class="search-box" type="text" v-model="searchTerm" placeholder="搜尋">
    <button type="button" id="search-btn" @click="searchClick">
      <img class="icon-search" src="../../assets/button-icon/search.png">
    </button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTerm: '',
    };
  },
  methods: {
    searchClick() {
      this.$emit('search', this.searchTerm);
    },
  },
};
</script>
<style>
.search-box{
width: 160px;
height: 34px;
background: #FBF8F8;
border: 1px solid #A4947C;
color: #A4947C;
border-radius: 20px;
position: fixed;
right: 6%;
top: 12%;
padding-left: 12px;
outline: none;


}
.search-box::placeholder{
    margin-left: 20%;
    color: #A4947C;
    
}

#search-btn{
    width: 54px;
    height: 36px;
    position: fixed;
    right: 6%;
    top: 12%;
    background:none;
    border: none;
    border-radius: 10px;
    cursor: pointer;
}

.icon-search{
    width: 22px;
    height: 22px;
    margin: 6px;
}
</style>