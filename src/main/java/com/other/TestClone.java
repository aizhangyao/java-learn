package com.other;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestClone
 * @description 测试深浅克隆
 * @date Create in 10:51 2023/5/23
 */
public class TestClone {
    public static void main1(String[] args) {
        List<B> bList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            B b = new B();

            A a1 = new A();
            a1.setAge(2);
            a1.setName("bqy");

            b.setA(a1);
            b.setTutu("tt");

            B bClone = b.clone();
            bList.add(bClone);
        }

        for (B b : bList) {
            System.out.println("b address is " + b.hashCode());
            //System.out.println("bClone address is " + bClone.hashCode());

            System.out.println("b.a address is " + b.getA().hashCode());
            //System.out.println("bClone.a address is " + bClone.getA().hashCode());
        }


    }

    public static class A {
        private Integer age;
        private String name;

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class B implements Cloneable {
        private A a;
        private String tutu;

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }

        public void setTutu(String tutu) {
            this.tutu = tutu;
        }

        @Override
        public B clone() {
            try {
                return (B) super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("clone error");
            }
            return null;
        }
    }


    public Map<String, OrderEntryResponseInfoDTO> checkSpecialIdentityPurchase(Long tenantId, RequestDTO requestDto) {
        // (key,value) (platformSkuCode,OrderEntryResponseInfoDTO)
        return new HashMap<>();
    }

    public static class RequestDTO {
        private String userId;
        private String platformOrderCode;
        private Date platformCreateDate;
        private List<EntryRequestDTO> entryRequestDtoList;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPlatformOrderCode() {
            return platformOrderCode;
        }

        public void setPlatformOrderCode(String platformOrderCode) {
            this.platformOrderCode = platformOrderCode;
        }

        public Date getPlatformCreateDate() {
            return platformCreateDate;
        }

        public void setPlatformCreateDate(Date platformCreateDate) {
            this.platformCreateDate = platformCreateDate;
        }

        public List<EntryRequestDTO> getEntryRequestDtoList() {
            return entryRequestDtoList;
        }

        public void setEntryRequestDtoList(List<EntryRequestDTO> entryRequestDtoList) {
            this.entryRequestDtoList = entryRequestDtoList;
        }
    }

    public static class EntryRequestDTO {
        private String spuCode;
        private String platformOrderEntryCode;

        public String getSpuCode() {
            return spuCode;
        }

        public void setSpuCode(String spuCode) {
            this.spuCode = spuCode;
        }

        public String getPlatformOrderEntryCode() {
            return platformOrderEntryCode;
        }

        public void setPlatformOrderEntryCode(String platformOrderEntryCode) {
            this.platformOrderEntryCode = platformOrderEntryCode;
        }
    }

    public static class OrderEntryResponseInfoDTO {
        private String 特殊身份限购商品数量;
        private String 已用额度购买商品数量;

        public String get特殊身份限购商品数量() {
            return 特殊身份限购商品数量;
        }

        public void set特殊身份限购商品数量(String 特殊身份限购商品数量) {
            this.特殊身份限购商品数量 = 特殊身份限购商品数量;
        }

        public String get已用额度购买商品数量() {
            return 已用额度购买商品数量;
        }

        public void set已用额度购买商品数量(String 已用额度购买商品数量) {
            this.已用额度购买商品数量 = 已用额度购买商品数量;
        }
    }

    public static void main(String[] args) {
        OrderEntryResponseInfoDTO dto1 = new OrderEntryResponseInfoDTO();
        dto1.set已用额度购买商品数量("1");
        dto1.set特殊身份限购商品数量("2");

        OrderEntryResponseInfoDTO dto2 = new OrderEntryResponseInfoDTO();
        dto2.set已用额度购买商品数量("3");
        dto2.set特殊身份限购商品数量("4");

        Map<String, OrderEntryResponseInfoDTO> map = new HashMap<>();
        map.put("spu1", dto1);
        map.put("spu2", dto2);
        System.out.println(JSONObject.toJSONString(map));
    }
}
