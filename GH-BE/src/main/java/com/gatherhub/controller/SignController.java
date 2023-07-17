package com.gatherhub.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gatherhub.configuration.util.JwtUtil;
import com.gatherhub.dao.MemberDao;
import com.gatherhub.entity.Member;
import com.gatherhub.service.impl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SignController {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private TokenService tokenService;

    //{
    //  "memberName":"木和",
    //  "memberPhone":"123",
    //  "memberEmail":"456",
    //  "memberAccount":"042613",
    //  "memberPassword":"0426"
    //} 新增的格式
    @PostMapping("/members")
    public String insert(@RequestBody Member member){
        String memberAccount = member.getMemberAccount();
        if (memberDao.existsByMemberAccount(memberAccount)) {
            return "帳號已存在";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(member.getMemberPassword());
        member.setMemberPassword(encryptedPassword);

        memberDao.save(member);



        return "新增成功";
    }
//    @PostMapping("/login")
//    public String login(@RequestBody Member member) {
//        String memberAccount = member.getMemberAccount();
//        String memberPassword = member.getMemberPassword();
//
//        // 根据成员帐号从数据库中检索成员信息
//        Member existingMember = memberDao.findByMemberAccount(memberAccount);
//
//        if (existingMember == null) {
//            return "帳號不存在";
//        }
//
//        // 验证密码是否匹配
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (!encoder.matches(memberPassword, existingMember.getMemberPassword())) {
//            return "密碼錯誤";
//        }
//
//        return "登入成功";
//
//    }

    @PostMapping("/login")
    public String login(@RequestBody Member member) {

        JSONObject json=new JSONObject();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        try {
            Member user1 = memberDao.findByMemberAccount(member.getMemberAccount());
            if (user1!=null) {
                String dbPassWord = user1.getMemberPassword();
                if (bCryptPasswordEncoder.matches(member.getMemberPassword(),dbPassWord)) {
                    //创建token

                    String token = JwtUtil.generateToken(member.getMemberAccount());
                    json.put("success", true);
                    json.put("code", 1);
                    //json.put("result", user1);
                    json.put("message", "登入成功");
                    json.put(JwtUtil.AUTHORIZATION,token);
                } else {
                    json.put("success", false);
                    json.put("code", -1);
                    json.put("message", "登入失敗,密碼錯誤");
                }
            }else {
                json.put("success", false);
                json.put("code", 0);
                json.put("message", "無此用戶資料");
            }
        } catch (Exception e) {
            json.put("code", -2);
            json.put("success", false);
            json.put("message", e.getMessage());

        }
        return JSON.toJSONString(json);

//        String memberAccount = member.getMemberAccount();
//        String memberPassword = member.getMemberPassword();
//
//        // 根据成员帐号从数据库中检索成员信息
//        Member existingMember = memberDao.findByMemberAccount(memberAccount);
//
//        if (existingMember == null) {
//            return "帳號不存在";
//        }
//
//        // 验证密码是否匹配
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (!encoder.matches(memberPassword, existingMember.getMemberPassword())) {
//            return "密碼錯誤";
//        }
//
//        return "登入成功";

    }


//    @RequestMapping("/getInfo")
//    public String test(){
//        return memberDao.findByMemberAccount(tokenService.getAccount()).toString();
//    }

    @RequestMapping("/getInfo")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> test() {
        Map<String, Object> response = new HashMap<>();
        response.put("data", memberDao.findByMemberAccount(tokenService.getAccount()));
        // 可以根據需要添加其他字段或處理
        System.out.println("tokenService.getAccount() = " + tokenService.getAccount());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
