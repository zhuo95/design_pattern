package com.zz.design_pattern.pattern.behavior.strategy;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {
    private static Map<String,PromotionStrategy> PROMOTION_MAP = new HashMap<>();

    private PromotionStrategyFactory() {
    }

    static {
        PROMOTION_MAP.put("DAZHE",new DaZhePromotion());
        PROMOTION_MAP.put("DIJIAN",new FanXianPromotion());
        PROMOTION_MAP.put("EMPTY", new EmptyPromotion());
    }

    public static PromotionStrategy getPromotionStrategy(String key) {
        if(!PROMOTION_MAP.containsKey(key)) return PROMOTION_MAP.get("EMPTY");
        return PROMOTION_MAP.get(key);
    }
}
