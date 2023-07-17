<template>
    
  <footer>
    <div class="footer-container">
      <div class="footer-left">
        <h3>Gather Hub</h3>
        <hr>
        <p>營業時間：</p>
        <p>平日&nbsp;09:00-18:00</p>
        <p>週六&nbsp;09:00-21:00</p>
        <router-link class="router" to="AdminLogin"><p>企業登入</p></router-link>
      </div>
  
      <div class="footer-center">
        <h4>聯絡資訊</h4>
        <hr>
        <p>電話：07-975-8228</p>
        <p>信箱：gatherhub@hub.com</p>
        <p>地址：台中市南屯區文心南三路528號1樓</p>
      </div>
  
      <div class="pay">
        <h4>付款方式</h4>
        <hr>
        <ul>
          <li class="applepay"><img id="applepayimg" src="../assets/footer-icon/apple-pay.png"></li>
          <li class="master"><img id="masterimg" src="../assets/footer-icon/mastercard.png"></li>
          <li class="visa"><img id="visaimg" src="../assets/footer-icon/visa.png"></li>
          <li class="linepay"><img id="linepayimg" src="../assets/footer-icon/card_linepay.png"></li>
  
        </ul>
      </div>
  
      <div class="footer-right">
        <h4>關注我們</h4>
        <hr>
        <ul>
          <li class="facebook"><img id="fbimg" src="../assets/footer-icon/facebook.png"></li>
          <li class="instagram"><img id="igimg" src="../assets/footer-icon/instagram.png"></li>
          <li class="line"><img id="lineimg" src="../assets/footer-icon/line.png"></li>
          <li class="google"><img id="gmailimg" src="../assets/footer-icon/gmail.png"></li>
        </ul>
      </div>
    </div>
  </footer>
</template>
<script>

</script>
<style scoped>

footer {
    background-color: #373633;
    color:  rgb(243, 195, 113);
    padding: 10px 0;
    font-size: 14px;
    text-align: left;
    width: 100%;
}

.footer-container {
    display: flex;
    justify-content: space-between;
    max-width: 1300px;
    margin: 0px auto;
}

.footer-left {
    width: 280px;
    margin-right: 10px;
}

.footer-left h3 {
    margin-bottom: 5px;
    font-size: 20px;
    color:  rgb(243, 195, 113);
}

.footer-left p {
    margin: 10px;
}

.router{
    /* text-decoration: none ; */
    color:  rgb(243, 195, 113);
}


.footer-center {
    width: 280px;
    margin-right: 20px;
}

.footer-center h4 {
    color:  rgb(243, 195, 113);
    margin-bottom: 5px;
    font-size: 18px;
}

.footer-center p {
    margin: 10px;
}

.footer-right ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    justify-content: flex-end;
}

.footer-right li {
    margin-left: 20px;
}

.footer-right li:first-child {
    margin-left: 0;
}

.footer-right a {
    color: #878181;
    text-decoration: none;
}

.footer-right a:hover {
    text-decoration: underline;
}


/* 支付方式 */
.pay {
    width: 280px;
    margin-right: 10px;
}

.pay h4 {
    margin-bottom: 5px;
    font-size: 20px;
    color:  rgb(243, 195, 113);
}

.pay ul {
    display: flex;
    justify-content: center;
    align-items: center;
    list-style: none;
    padding: 0;
    margin: 0;
}

.pay li {
    margin-right: 30px;
}

.pay li:last-child {
    margin-right: 0;
}

.pay ul {
    list-style: none;
}

#applepayimg {
    width: 35px;
    height: 30px;
    margin-top: 5px;
}

#masterimg {
    width: 35px;
    height: 30px;
    margin-top: 5px;
}
#visaimg {
    width: 35px;
    height: 30px;
    margin-top: 5px;
}
#linepayimg {
    width: 70px;
    height: 20px;
    margin-top: 5px;
}



/* 關注我們 */

.footer-right {
    width: 280px;
    margin-right: 10px;
}

.footer-right h4 {
    margin-bottom: 5px;
    font-size: 20px;
    color:  rgb(243, 195, 113);
}

.footer-right ul {
    list-style: none;
    padding: 0;
    text-align: left;
    justify-content: space-between;
    
}


.footer-right ul li {
    font-size: 20px;
    width: 40px;
    height: 40px;
    line-height: 30px;
    text-align: center;
    cursor: pointer;
    border-radius: 50%;
    border: 0px solid #D8E2DC;
    float: left;
    transition: all 0.2s ease;
}



#fbimg {
    width: 30px;
    height: 30px;
    margin-top: 5px;
}

#igimg {
    width: 30px;
    height: 30px;
    margin-top: 5px;
}

#lineimg {
    width: 30px;
    height: 30px;
    margin-top: 5px;
}
#gmailimg {
    width: 30px;
    height: 30px;
    margin-top: 5px;
}
#shoppeeimg {
    width: 33px;
    height: 33px;
    margin-top: 5px;
}




/* 動態 */
/*facebook*/
.footer-right ul li:hover.facebook {
    border: 3px solid #3b5998;
    box-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

.footer-right ul li:hover .fa-facebook {
    color: #3b5998;
    text-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

/*twitter*/
.footer-right ul li:hover.twitter {
    border: 3px solid #00aced;
    box-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

.footer-right ul li:hover .fa-twitter {
    color: #00aced;
    text-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

/* instagram */
.footer-right ul li:hover.instagram {
    border: 3px solid #d13050;
    box-shadow: 0 0 5px #313337ce;
    transition: all 0.1s ease;
}

.footer-right ul li:hover .fa-instagram {
    color: #d13050;
    text-shadow: 0 0 5px #313337ce;
    transition: all 0.1s ease;
}

/* google */
.footer-right ul li:hover.google {
    border: 3px solid #dd4b39;
    box-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

.footer-right ul li:hover .fa-google {
    color: #dd4b39;
    text-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

/* line */
.footer-right ul li:hover.line {
    border: 3px solid #4dc247;
    box-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

.footer-right ul li:hover .fa-line {
    color: #4dc247;
    text-shadow: 0 0 5px #313337ce;
    transition: all 0.2s ease;
}

</style>