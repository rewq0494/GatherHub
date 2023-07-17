<template>
  <div class="upload-area">
    <p class="upload-text">選擇檔案</p>
    <div class="dropbox" @click="openFileInput">
      <span>
        <img class="upload-icon" src="../../assets/dialog-icon/upload.png" >
      </span>
      <input type="file" ref="fileInput" id="fileToUpload" multiple style="display: none" @change="setFiles($event)" />
    </div>
    <div v-show="files.length">
      <div v-for="file in files" :key="file.name">
        <span class="file-name">
          已選取：
          <img class="pdf-icon" src="../../assets/dialog-icon/pdf.png">
          {{ file.name }}</span>
      </div>
    </div>
    <!-- <button v-show="files.length" @click="uploadFile">上傳</button> -->
  </div>
</template>

<script>
import { ref, reactive } from 'vue';

export default {
  setup() {
    const fileInput = ref(null);
    const selectedFiles = ref([]);
    const files = reactive([]);

    function openFileInput() {
      fileInput.value.click();
    }

    function setFiles(event) {
      const target = event.target;
      selectedFiles.value = Array.from(target.files);
      files.splice(0, files.length, ...selectedFiles.value);
    }
// 上傳檔案方法
    // function uploadFile() {
    //   const formData = new FormData();
    //   selectedFiles.value.forEach((file) => {
    //     formData.append('uploadedFile', file);
    //   });

    //   const xhr = new XMLHttpRequest();
    //   xhr.open('POST', '/fileupload');
    //   xhr.send(formData);
    // }

    return {
      fileInput,
      selectedFiles,
      files,
      openFileInput,
      setFiles,
      // uploadFile,
    };
  },
};
</script> 
  
  <style scoped>
  *{
  font-family: '微軟正黑體';
}
  .upload-area{
    position:absolute;
    top: 130px;
    left: 440px;
  }
  .dropbox {
    width: 230px;
    height: 120px;
    border-radius: 8px;
    background-color: #FFF0DE;
    text-align: center;
    color: #BBB;
    cursor: pointer;
  }
  .dropbox:hover{
    background-color: #ffe7ce;
    transition: background-color 0.5s;
  }
  .dropbox span {
    margin-top: 0.9em;
    display: block;
  }
  .dropbox.not-available {
    background-color: #F88;
  }
  .dropbox.over {
    background-color: #bfb;
  }
  .upload-text{
    /* color: #80786F; */
    position: absolute;
    /* top:20px; */
    /* left: 120px; */
    font-size: 16px;
    color: #777777;
    top: 15px;
    left: -80px;
    font-weight:700;
  }
  
  .upload-icon{
    width: 30px;
    height: 30px;
    position: absolute;
    top: 60px;
    left: 100px;
  }
  .pdf-icon{
     width: 20px;
    height: 20px;
    position: relative;
    top: 4px;
  }
  .file-name{
    color: #80786F;
  }


  </style>
  