<template>
  <div>
    <SidebarMenu/>
    <div class="chat-member-title">訪客</div>
    <div class="chat-member">
      <div
        class="select-member-box"
        v-for="member in members"
        :key="member.id"
        @click="selectMember(member)"
        :class="{ active: selectedMember && selectedMember.id === member.id }"
      >
        <span class="member-name">{{ member.name }}</span>
        <div class="member-message">{{ getLastMessage(member) }}</div>
        <div class="member-time">{{ getLastMessageTime(member) }}</div>


      </div>
    </div>
    <div class="chat-container" v-if="selectedMember">
      <div class="selected-member">{{ selectedMember.name }}</div>
      <div class="chat-messages">
        <div v-for="message in getMessagesForSelectedMember" :key="message.id" :class="{'message-container': true, 'sender-container': message.sender === '你', 'receiver-container': message.sender !== '你'}">
  <div :class="{'sender':true, 'sender-name':message.sender === '你','receiver-name': message.sender !== '你'}">{{ message.sender }}</div>
  <!-- <div class="flex-container"> -->
  <div :class="{'message': true, 'sender-message': message.sender === '你', 'receiver-message': message.sender !== '你'}">
    <div class="content">{{ message.content }}</div>
  </div>
  <div :class="{'time': true, 'sender-time': message.sender === '你', 'receiver-time': message.sender !== '你'}" v-if="message.time">{{ message.time }}</div> <!-- 添加显示时间的元素 -->
</div>
<!-- </div> -->
      </div>
      <div class="chat-input">
        <input v-model="inputMessage" @keydown.enter="sendMessage" placeholder="請輸入訊息..." />
        <button @click="sendMessage">發送</button>
      </div>
    </div>
    <div v-else class="chat-container">
      <div class="selected-member">選擇聊天對象</div>
    </div>
  </div>
</template>

<script>
import SidebarMenu from '../components/SidebarMenu.vue'

export default {
  name: 'ChatWidget',
  components:{
    SidebarMenu,
  },
  data() {
    return {
      // members: [
      //   { id: 1, name: '小明', messages: [] },
      //   { id: 2, name: '小红', messages: [] },
      //   { id: 3, name: '其他會員', messages: [] },
      // ],
      members: [
        { id: 1, name: '小紅', messages: [{ id: 1, sender: '小紅', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 2, name: '小黃', messages: [{ id: 2, sender: '小黃', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 3, name: '小藍', messages: [{ id: 3, sender: '小藍', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 4, name: '小綠', messages: [{ id: 4, sender: '小綠', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 5, name: '小紫', messages: [{ id: 5, sender: '小紫', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 6, name: '小白', messages: [{ id: 6, sender: '小白', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 7, name: '小黑', messages: [{ id: 7, sender: '小黑', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 8, name: '小灰', messages: [{ id: 8, sender: '小灰', content: '你好 請問需要什麼幫助呢?' }] },
        { id: 9, name: '小咖', messages: [{ id: 9, sender: '小咖', content: '你好 請問需要什麼幫助呢?' }] },
      ],
      selectedMember: null,
      inputMessage: '',
    };
  },
  computed: {
    getMessagesForSelectedMember() {
      if (this.selectedMember) {
        return this.selectedMember.messages;
      }
      return [];
    },
    
  },
  methods: {
    selectMember(member) {
      this.selectedMember = member;
    },
    getLastMessageTime(member) {
    if (member.messages.length > 0) {
      const lastMessage = member.messages[member.messages.length - 1];
      return lastMessage.time;
    }
    return '';
  },
  getLastMessage(member) {
    if (member.messages.length > 0) {
      const lastMessage = member.messages[member.messages.length - 1];
      return lastMessage.content;
    }
    return '';
  },
   
    sendMessage() {
  if (this.selectedMember && this.inputMessage.trim() !== '') {
    const newMessage = {
      id: this.selectedMember.messages.length + 1,
      sender: '你',
      content: this.inputMessage.trim(),
      time: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }),
    };
    this.selectedMember.messages.push(newMessage);
    this.inputMessage = '';
  }
}
  },
};
</script>


<style scoped>
.chat-member{
  height: 570px;
  width: 400px;
  position: absolute;
  top:110px;
  left: 360px;
  z-index: 999999;
  border-radius: 0 0 20px 20px;
  background-color:#F8F5EB ;
  overflow-x: hidden; /* 隐藏水平滚动条 */
  overflow-y: scroll; /* 显示垂直滚动条 */
}
.selected-member {
   position: relative;
   margin-bottom: 5px;
   min-height: 50px;
  width: 600px;
  height: 50px;
  background-color: #A79D89;
  color: #ffffff;
  border-radius: 20px 20px 0 0;  
  text-align: center;
  line-height: 50px;
  
}

.chat-member-title{
  position: absolute;
  top: 60px;
  left: 360px;
  width: 400px;
  min-height: 50px;
  height: 50px;
  background-color: #A79D89;
  color: #ffffff;
  border-radius: 20px 20px 0 0;  
  text-align: center;
  line-height: 50px;
}
.select-member-box{
  margin-left: 6px;
  /* margin-top:8px ; */
  height: 72px;
  width: 380px;
  position: relative;
  /* background-color: #faf5f3; */
  /* border-bottom: #52504f solid 0.2px; */
  border-radius: 5px;
  cursor: pointer;
}
.select-member-box::after{
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 380px; 
  height: 1px; /* 设置底部边框的粗细 */
  background-color: rgba(223, 181, 123, 0.538);
}
.select-member-box:hover{
  background-color: #e4dccc69;
  transition: background-color 0.8s;
  border: none;
}
.select-member-box.active {
  background-color: rgba(212, 200, 177, 0.534);
}
.member-name{
  position: absolute;
  top: 10px;
  left: 8px;
  font-weight: 600;
  color: #333232;
}
.member-time{
  font-size: 14px;
  color: #9e9992;
  position: absolute;
  top: 5px;
  right: 10px;
}
.member-message{
  font-size: 14px;
  color: #8f8b8b;
  position: absolute;
  bottom: 15px;
  left: 8px;
}
.chat-container {
  display: flex;
  flex-direction: column;
  width: 600px;
  height: 620px;
  background-color: #F8F5EB;
  border-radius: 20px;
  /* padding: 10px; */
  position: absolute;
  top: 60px;
  left: 762px;
  z-index: 999999;
}

.sender-container {
  min-height: 50px;
  position: relative;
  margin-top: 5px;
  margin-bottom: 4px;
  margin-left: auto; 
  width: 590px;
  /* border: red solid 1px; */
  height: auto;
  overflow: hidden; 
  
}

.receiver-container {
  min-height: 56px;
  position: relative;
  margin-top: 5px;
  margin-bottom: 4px;
  margin-left: 0;
  width: 590px;
  /* border: red solid 1px; */
  height: auto;
  overflow: hidden; 
}

.chat-messages {
  flex-grow: 1;
  overflow: auto;;
}

.message {
  max-width: 300px;
  width: auto;
  border-radius: 15px;
  margin-bottom: 10px;
  margin-top: 5px;
  padding: 6px;
  padding-left: 15px;
  padding-right: 15px;
  overflow:hidden;
  
}
.content{
  word-wrap: break-word; /* 文字超过容器宽度时自动换行 */
  white-space: pre-wrap; /* 保留换行符，显示换行文本 */
}
.sender {
  font-size: 14px;
  color: #808080;
  margin-left: auto;
  font-weight: bold;
  word-wrap: break-word; /* 文字超过容器宽度时自动换行 */
  overflow-wrap: break-word; /* 兼容性写法，支持更多浏览器 */
  white-space: pre-wrap; /* 保留换行符，显示换行文本 */
}
.sender-name{
  /* color: rgb(0, 255, 132); */
  position: absolute;
  margin-bottom: 10px;
  right: 10px;
}
.receiver-name{
  /* color: red; */
  position: absolute;
  margin-bottom: 10px;
  left: 10px;
}

.sender-message {
  /* display: inline-block; */
  position: relative; /* 将位置改为相对定位 */
  top: 12px;
  right: 10px;
  background-color: #fcd587;
  margin-left: 10px; 
  float:right;
  color: #524f4e;
}

.receiver-message {
  position: relative;
  top:12px;
  left: 10px;
  background-color: #ffffff;
  float:left;
}
.time{
  position: absolute;
  transform: translateY(200%);
  font-size: 12px;
}
.sender-time{
  position: relative;
  display: block; /* 修改为块级元素，使其出现在下一行 */
  /* color: rgb(0, 255, 132); */
  float:right;
  right: 5px;
  bottom: 0;
}
.receiver-time{
  position: relative;
  display: block; /* 修改为块级元素，使其出现在下一行 */
  /* color: rgb(0, 255, 132); */
  float:left;
  left: 8px;
    bottom: 0;

}
.chat-input {
  display: flex;
}

.chat-input input {
  color: #808080;
  height: 60px;
  flex-grow: 1;
  padding: 5px;
  outline: none;
  border-radius: 15px 5px 5px 15px;
  border: 0px;
  margin: 5px;
}

.chat-input button {
  position: relative;
  bottom: -4px;
  height: 70px;
  width: 80px;
  color: #524d46;
  padding: 5px 10px;
  background-color: #ffaa3a;
  border-radius: 5px 15px 15px 5px;
  border: none;
  cursor: pointer;
  margin: 0 5px 0px 0;
}
.chat-input button:hover {
  background-color: #ffc374;
  transition: background-color 0.8s;
  color: #6b625b;
  transition: color 0.8s;
}

/* 設置整個滾動條的寬度和高度 */
::-webkit-scrollbar {
  width: 7px;
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
  background-color: rgba(204, 191, 176, 0.26);
} 
</style>
