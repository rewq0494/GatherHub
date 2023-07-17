package com.gatherhub;

import com.gatherhub.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChBeApplicationTests {
    @Autowired
    CompanyDao companyRepo;
//    @Autowired
//    private StringEncryptor stringEncryptor;


//    @Test
//    void encryptPwd(){
//        String secret="connectU";
//        String url="jdbc:mysql://mydb.cru9r2lrbscf.ap-northeast-1.rds.amazonaws.com:3306/gatherHub?serverTimezone=Asia/Taipei&characterEncoding=utf-8";
//        System.out.println("ENC("+stringEncryptor.encrypt(url)+")");
//
//        String userName="admin";
//        System.out.println("ENC("+stringEncryptor.encrypt(userName)+")");
//
//        String password="en5u7TOslolm96AAZUDz";
//        System.out.println("ENC("+stringEncryptor.encrypt(password)+")");
//        System.out.println(stringEncryptor.decrypt("Dn9JuVp7UegTW2i3zaTX7S+1LnKAjTu02zzDFkTX6rOzGeozIL4Bd6I48Ld17i8p"));
//    }
}
