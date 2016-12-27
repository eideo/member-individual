/* 
 * AccountTest.java  
 * 
 * version TODO
 *
 * 2016年11月7日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.member.individual.test;



import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.zlebank.zplatform.acc.bean.BusiAcctQuery;
import com.zlebank.zplatform.acc.bean.enums.Usage;
import com.zlebank.zplatform.acc.service.AccountQueryService;
import com.zlebank.zplatform.member.individual.bean.MemberAccountBean;
import com.zlebank.zplatform.member.individual.bean.MemberBean;
import com.zlebank.zplatform.member.individual.bean.PoMemberApplyBean;
import com.zlebank.zplatform.member.individual.bean.enums.MemberType;
import com.zlebank.zplatform.member.individual.service.MemberAccountService;
import com.zlebank.zplatform.member.individual.service.MemberService;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月7日 上午9:26:46
 * @since 
 */
//@Component
public class AccountTest extends BaseTest{
    
    @Reference(version="1.0")
    private AccountQueryService accountQuery;
    @Reference(version="1.0")
    private MemberService memberServie;
    @Reference(version="1.0")
    private MemberAccountService memberAccountService;
    @Test
    public void accountQueryService(){
        
       try {                                                    
           BusiAcctQuery accts=accountQuery.getBusiQueryBybCode("9010102200000000000604");
           System.out.println(accts);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    @Test
    public void memberService(){
          try {
              //BusiAcctQuery query=  memberServie.getBusiQueryBybCode("6010101100000000000616");
              //System.out.println(JSONObject.toJSONString(query));
              PoMemberApplyBean queryApply=  memberServie.getMemberApply("200000000000613");
              System.out.println(JSONObject.toJSONString(queryApply));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    @Test
    public void memberAccountService(){
          try {
              MemberBean memberBean=new MemberBean();
              memberBean.setMemberId("200000000000611");
              MemberAccountBean query=  memberAccountService.queryBalance(MemberType.ENTERPRISE,memberBean, Usage.BASICPAY);
              System.out.println(JSONObject.toJSONString(query));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
