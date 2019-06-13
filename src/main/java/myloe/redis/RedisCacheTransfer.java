package myloe.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @program: mybatis-spring
 * @description:
 * @author: Mr.Loe
 * @create: 2019-06-11 12:31
 **/
public class RedisCacheTransfer  {

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisCache.setRedisTemplate(redisTemplate);
    }
}
