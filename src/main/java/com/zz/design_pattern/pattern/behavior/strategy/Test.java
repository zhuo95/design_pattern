package com.zz.design_pattern.pattern.behavior.strategy;

public class Test {
//    public static void main(String[] args) {
//        PromotionActivity promotionActivity11 =  new PromotionActivity(new DaZhePromotion());
//
//        PromotionActivity promotionActivity12 = new PromotionActivity(new FanXianPromotion());
//
//        promotionActivity11.executePromotionStrategy();
//
//        promotionActivity12.executePromotionStrategy();
//    }

    public static void main(String[] args) {
        PromotionActivity promotionActivity = null;
        String promotionKey = "DAZHE";

//        if(promotionKey.equals("DAZHE")){
//            promotionActivity = new PromotionActivity(new DaZhePromotion());
//        }else if(promotionKey.equals("FANXIAN")){
//            promotionActivity = new PromotionActivity(new FanXianPromotion());
//        }

        promotionActivity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));

        promotionActivity.executePromotionStrategy();
    }
}
