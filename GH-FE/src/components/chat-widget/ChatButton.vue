<template>
  <div>
    <div v-if="showFloatingButton" class="floating-button" @click="openChatWidget">
      <span>Chat</span>
    </div>

    <div v-if="showChatWidget" class="chat-widget">
      <div class="chat-header">
        <span>即時客服</span>
        <button @click="closeChatWidget">╳</button>
      </div>
      <div class="chat-body">
        <div v-if="messages.length === 0" class="chat-message">
          <div class="other-message">
            <span>您好，請問需要什麼服務呢?</span>
          </div>
        </div>
        <div v-for="(message, index) in messages" :key="index" class="chat-message">
          <div :class="{'my-message': message.isMine, 'other-message': !message.isMine}">
            <!-- <div :class="{'sender':true, 'sender-name':message.isMine,'receiver-name': !message.isMine}">{{ message.sender }}</div> -->
            <div :class="{'message': true, 'sender-message': message.isMine, 'receiver-message': !message.isMine}">
              <div class="content">{{ message.content }}</div>
            </div>
            <!-- <div :class="{'time': true, 'sender-time': message.isMine, 'receiver-time': !message.isMine}" v-if="message.time">{{ message.time }}</div> -->
          </div>
        </div>
      </div>
      <div class="chat-footer">
        <input v-model="newMessage" placeholder="Type your message" />
        <button @click="sendMessage">發送</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showFloatingButton: true,
      showChatWidget: false,
      messages: [],
      newMessage: "",
    };
  },
  methods: {
    openChatWidget() {
      this.showFloatingButton = false;
      this.showChatWidget = true;
    },
    closeChatWidget() {
      this.showFloatingButton = true;
      this.showChatWidget = false;
    },
    sendMessage() {
      if (this.newMessage) {
        this.messages.push({
          content: this.newMessage,
          isMine: true,
          sender: "你",
        });
        this.newMessage = "";

        this.scrollToBottom();
      }
    },
    scrollToBottom() {
      const chatBody = document.querySelector(".chat-body");
      chatBody.scrollTop = chatBody.scrollHeight;
    },
  },
};
</script>

<style>
.floating-button {
  position: fixed;
  bottom: 20px;
  right: 20px;
  background-color: rgb(242, 182, 80);
  color: #fff;
  padding: 10px 20px;
  border-radius: 20px;
  cursor: pointer;
}
.floating-button:hover{
  background-color: rgb(238, 198, 129);
  transition: background-color 0.8s;
  position: fixed;
  bottom: 22px;
  right: 22px;
}
.chat-widget {
  position: fixed;
  bottom: 80px;
  right: 40px;
  width: 350px;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 20px;
}

.chat-header {
  background-color:  rgb(242, 182, 80);
  color: #fff;
  padding: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 20px 20px 0 0;
}

.chat-body {
  padding: 10px;
  height: 300px;
  /* max-height: 200px; */
  overflow-y: auto;
}

.chat-message {
  margin-bottom: 10px;
}

.my-message {
  background-color: #fbe4be;
  color: #565151;
  align-self: flex-end;
  width: 200px;
  border-radius: 15px;
  float: right;
  padding: 10px

}

.other-message {
  background-color: #dcf1b8;
  color: #4d4c4c;
  align-self: flex-end;
  width: 200px;
  border-radius: 15px;
  float:left;
  padding: 10px
}

.sender,
.receiver {
  font-weight: bold;
}


.content {
  margin-bottom: 5px;
}



.chat-footer {
  padding: 10px;
  display: flex;
  align-items: center;
}

.chat-footer input {
  flex: 1;
  padding: 5px;
  border: 1px solid #f3a653;
  border-radius: 10px;
  outline: none;
  color: #4d4c4c;
}

.chat-footer button {
  margin-left: 10px;
  border: none;
}
</style>
